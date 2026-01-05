package pt.smarthome;

import pt.smarthome.core.SmartDevice;
import pt.smarthome.devices.AirConditioner;
import pt.smarthome.devices.SecuritySystem;
import pt.smarthome.devices.SmartLight;
import pt.smarthome.system.Connection;
import pt.smarthome.system.VirtualProtocol;

import java.util.List;
import java.util.Scanner;

public class SmartHomeApp {

    public static void main(String[] args) {
        // 1. Configurar a ligação
        Connection conn = new Connection("127.0.0.1", 9999, new VirtualProtocol());
        conn.connect();

        // 2. Criar os dispositivos
        SmartLight luz = new SmartLight(1, "Luz da Sala", conn);
        AirConditioner ac = new AirConditioner(2, "AC do Quarto", conn);
        SecuritySystem alarme = new SecuritySystem(3, "Alarme Geral", conn);

        List<SmartDevice> devices = List.of(luz, ac, alarme);

        // 3. Iniciar o Scanner para ler do teclado
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        System.out.println("--- BEM-VINDO À SMART HOME ---");

        // 4. Loop do Menu (corre até escolheres Sair)
        while (opcao != 0) {
            System.out.println("\nEscolhe uma opção:");
            System.out.println("1. Ligar a Luz");
            System.out.println("2. Desligar a Luz");
            System.out.println("3. Definir Brilho da Luz");
            System.out.println("4. Ligar AC");
            System.out.println("5. Desligar AC");
            System.out.println("6. Definir a Temperatura do AC");
            System.out.println("7. Ligar o Alarme");
            System.out.println("8. Desligar o Alarme");
            System.out.println("9. Emergência (Alarme)");
            System.out.println("10. Ligar todos os dispositivos");
            System.out.println("11. Desligar todos os dispositivos");
            System.out.println("0. Sair");
            System.out.print("-> ");

            try {
                // Ler a opção do utilizador
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        luz.turnOn();
                        break;
                    case 2:
                        luz.turnOff();
                        break;
                    case 3:
                        System.out.print("Qual o nível de brilho (0-100)? ");
                        int brilho = scanner.nextInt();
                        luz.setBrightness(brilho);
                        break;
                    case 4:
                        ac.turnOn();
                        break;
                    case 5:
                        ac.turnOff();
                        break;
                    case 6:
                        System.out.print("Qual a temperatura desejada? ");
                        int temp = scanner.nextInt();
                        ac.setTemperature(temp);
                        break;
                    case 7:
                        alarme.turnOn();
                        break;
                    case 8:
                        alarme.turnOff();
                        break;
                    case 9:
                        alarme.triggerPanic();
                        break;
                    case 10:
                        for(SmartDevice device: devices) {
                            device.turnOn();
                        }
                        break;
                    case 11:
                        for(SmartDevice device: devices) {
                            device.turnOff();
                        }
                        break;
                    case 0:
                        System.out.println("A desligar o sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (Exception e) {
                System.out.println("Erro: Por favor insira apenas números.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }

        // 5. Fechar ligação e scanner
        conn.disconnect();
        scanner.close();
    }
}