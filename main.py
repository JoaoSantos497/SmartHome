import socket
import threading

# Configurações do Servidor
HOST = '0.0.0.0'  # Escuta em todas as interfaces
PORT = 9999       # Tem de ser igual ao do Java (SmartHomeApp.java)

def process_command(command):
    """
    Processa o texto recebido do Java e executa a ação.
    Retorna a resposta para enviar de volta ao Java.
    """
    parts = command.split(":")
    device_type = parts[0]

    printf(f"   [Ação] A processar comando para: {device_type}")

    if device_type == "LIGHT":
        # Ex: LIGHT:1:ON
        device_id = parts[1]
        action = parts[2]
        if action == "BRIGHT":
            level = parts[3]
            return f"Luz {device_id} brilho ajustado para {level}%"
        return f"Luz {device_id} está {action}"

    elif device_type == "AC":
        # Ex: AC:2:TEMP:22
        device_id = parts[1]
        action = parts[2]
        if action == "TEMP":
            temp = parts[3]
            return f"AC {device_id} temperatura definida para {temp}C"
        return f"Ar Condicionado {device_id} está {action}"

    elif device_type == "ALARM":
        # Ex: ALARM:3:ARM
        device_id = parts[1]
        action = parts[2]
        return f"Alarme {device_id} status: {action}"

    return "Comando desconhecido"

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