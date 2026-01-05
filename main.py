import socket
import threading

# Configurações do Servidor
HOST = '0.0.0.0'  # Escuta em todas as interfaces
PORT = 9999       # Tem de ser igual ao do Java (SmartHomeApp.java)

class Command:
    def __init__(self, raw):
        parts = raw.split(":")

        self.device_type = parts[0]
        self.device_id = parts[1]
        self.action = parts[2]
        self.params = {}

        for part in parts[3:]:
            if "=" in part:
                key, value = part.split("=", 1)
                self.params[key] = value

class SmartDevice:

    def __init__(self, device_id):
        self.device_id = device_id

    def handle(self, command: Command):
        print("handle() must be implemented by subclasses")

class Light(SmartDevice):

    def handle(self, command: Command):
        if command.action == "SET":
            brightness = command.params.get("BRIGHT")

            return f"Luz {self.device_id} brilho={brightness}%"

        return f"Luz {self.device_id} está {command.action}"


class AirConditioner(SmartDevice):

    def handle(self, command: Command):
        if command.action == "SET":
            temp = command.params.get("TEMP")

            return f"AC {self.device_id} temperatura={temp}°C"

        return f"Ar Condicionado {self.device_id} está {command.action}"


class Alarm(SmartDevice):

    def handle(self, command: Command):
        return f"Alarme {self.device_id} status={command.action}"

DEVICE_TYPES = {
    "LIGHT": Light,
    "AC": AirConditioner,
    "ALARM": Alarm
}

def process_command(raw_command):
    try:
        command = Command(raw_command)
    except Exception:
        return "Erro ao processar comando"

    print(f"   [Ação] A processar comando para: {command.device_type}")

    device_class = DEVICE_TYPES.get(command.device_type)

    if not device_class:
        return "Dispositivo desconhecido"

    device = device_class(command.device_id)

    return device.handle(command)

def handle_client(client_socket, addr):
    """
    Gere uma conexão individual com um cliente Java.
    """
    print(f"\n[+] Nova conexão de {addr}")

    try:
        while True:
            # Recebe dados (buffer de 1024 bytes)
            request = client_socket.recv(1024).decode('utf-8')

            if not request:
                break  # Conexão fechada pelo cliente

            # Remove espaços e quebras de linha
            command = request.strip()
            print(f"-> Comando recebido: {command}")

            # Processa e gera resposta
            response_msg = process_command(command)

            # Envia resposta de volta ao Java (IMPORTANTE: adicionar \n)
            client_socket.send((response_msg + "\n").encode('utf-8'))

    except Exception as e:
        print(f"[-] Erro na conexão: {e}")
    finally:
        client_socket.close()
        print(f"[-] Conexão encerrada com {addr}")

def start_server():
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind((HOST, PORT))
    server.listen(5)

    print(f"=== Servidor SmartHome Python a correr na porta {PORT} ===")
    print("À espera do Cliente Java...")

    while True:
        client_sock, addr = server.accept()
        # Cria uma thread para não bloquear se tiveres múltiplos clientes
        client_handler = threading.Thread(target=handle_client, args=(client_sock, addr))
        client_handler.start()

if __name__ == "__main__":
    start_server()