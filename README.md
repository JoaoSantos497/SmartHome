✨ Funcionalidades💡
- Iluminação (SmartLight)Ligar/Desligar luzes remotamente.
- Ajustar intensidade do brilho (0-100%).

❄️ Climatização (AirConditioner)
- Ligar/Desligar o ar condicionado.
- Definir a temperatura desejada.
  
🚨 Segurança (SecuritySystem)
- Armar/Desarmar: Ativa ou desativa os sensores de movimento.
- Botão de Pânico: Envia um sinal de emergência imediato para o servidor, independentemente do estado do sistema.

🛠 Pré-requisitos
Para executar este projeto, necessitas de ter instalado:
- Java JDK 8 ou superior.
- Python 3.x.
- Um IDE (recomendado: IntelliJ IDEA ou VS Code).

🚀 Como Executar

Siga estes passos na ordem exata para garantir a conexão.

Passo 1: Iniciar o Servidor (Cérebro)No terminal, navegue até à pasta raiz do projeto e execute:
- python main.py ou python3 main.py ou py main.py

Deverá ver a mensagem:
=== Servidor SmartHome Python a correr na porta 9999 ===

Passo 2: Iniciar o Cliente (Comando)No teu IDE Java (ou outro terminal), compila e executa a classe principal:src/pt/smarthome/SmartHomeApp.javaDeverá ver o menu interativo:
Plaintext--- BEM-VINDO À SMART HOME ---
Escolha uma opção:
1. Ligar Luz
...

📂 Estrutura do ProjetoPlaintextSmartHome/
│
├── main.py                     # Servidor Python (Hub)
├── README.md                   # Documentação
│
└── src/pt/smarthome/           # Código Fonte Java
    ├── SmartHomeApp.java       # Aplicação Principal (Menu)
    │
    ├── core/                   # Camada Abstrata
    │   └── SmartDevice.java    # Classe Pai (Abstract)
    │
    ├── devices/                # Dispositivos Concretos
    │   ├── SmartLight.java
    │   ├── AirConditioner.java
    │   └── SecuritySystem.java
    │
    └── system/                 # Camada de Rede
        └── Connection.java     # Gestão de Sockets
        
👨‍💻 Desenvolvido por João Santos, Daniel Nunes e Alexandre Silva no âmbito da unidade curricular de Programação Orientada a Objetos.
