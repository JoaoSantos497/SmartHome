# 🏠 SmartHome System (IoT Simulation)

> **Simulação de um sistema de Casa Inteligente com arquitetura Cliente-Servidor.**
>
> *Um projeto que integra a robustez do **Java (POO)** com a versatilidade do **Python** através de comunicação via Sockets TCP.*

![Status](https://img.shields.io/badge/Status-Concluído-brightgreen)
![Java](https://img.shields.io/badge/Client-Java%2017+-orange)
![Python](https://img.shields.io/badge/Server-Python%203.8+-blue)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

## 📋 Índice
- [Sobre o Projeto](#-sobre-o-projeto)
- [Arquitetura](#-arquitetura)
- [Funcionalidades](#-funcionalidades)
- [Pré-requisitos](#-pré-requisitos)
- [Como Executar](#-como-executar)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Protocolo de Comunicação](#-protocolo-de-comunicação)
- [Autor](#-autor)

---

## 📖 Sobre o Projeto
Este projeto académico demonstra a interoperabilidade entre sistemas distribuídos. O objetivo é controlar dispositivos domésticos (Luzes, Ar Condicionado, Alarmes) a partir de um cliente Java orientado a objetos, enviando comandos para um servidor central ("Hub") escrito em Python.

---

## 🏗 Arquitetura

O sistema utiliza uma arquitetura **Cliente-Servidor** síncrona:

1.  **Servidor (Python):** Atua como o Hub da casa. Escuta na porta `9999`, processa a lógica de negócio e mantém o estado dos dispositivos.
2.  **Cliente (Java):** Interface de consola interativa. Utiliza conceitos de POO (Herança, Polimorfismo, Encapsulamento) para modelar os dispositivos e comunica via Sockets.

---

✨ Funcionalidades💡 Iluminação (SmartLight)Controlo de Estado: Ligar e desligar luzes remotamente.Dimmer: Ajustar a intensidade do brilho (0-100%).❄️ Climatização (AirConditioner)Controlo de Energia: Ligar e desligar o ar condicionado.Termóstato: Definir a temperatura desejada em graus Celsius.🚨 Segurança (SecuritySystem)Armar/Desarmar: Ativa ou desativa os sensores de movimento da casa.Botão de Pânico: Funcionalidade de segurança crítica que envia um sinal de emergência imediato para o servidor, ignorando o estado atual do alarme.🛠 Pré-requisitosPara executar este projeto sem erros, necessitas do seguinte ambiente configurado:Java Development Kit (JDK): Versão 8 ou superior.Python: Versão 3.x instalada e adicionada ao PATH.IDE: IntelliJ IDEA (recomendado para a estrutura do projeto), Eclipse ou VS Code.
### Parte 2 (Do "Como Executar" até ao fim)
*Cola isto logo abaixo do texto anterior.*


## 🚀 Como Executar

Siga estes passos na ordem exata para garantir que a conexão TCP é estabelecida corretamente.

### Passo 1: Iniciar o Servidor (Python)
O servidor deve ser o primeiro a arrancar para abrir a porta de escuta.
No terminal, navegue até à pasta raiz do projeto e execute:

python main.py

Deverá ver a mensagem: === Servidor SmartHome Python a correr na porta 9999 ===Passo 2: Iniciar o Cliente (Java)Com o servidor a correr, abra o projeto no IDE e execute a classe principal:src/pt/smarthome/SmartHomeApp.javaDeverá ver o menu interativo na consola:Plaintext--- BEM-VINDO À SMART HOME ---
Escolha uma opção:
1. Ligar Luz
2. Desligar Luz
...
📂 Estrutura do ProjetoA organização segue as boas práticas de separação de responsabilidades (MVC/Layered):PlaintextSmartHome/
│
├── main.py                     # Servidor Python (Hub Central)
├── README.md                   # Documentação do Projeto
│
└── src/pt/smarthome/           # Código Fonte Java (Cliente)
    │
    ├── SmartHomeApp.java       # Classe Main (Menu e Execução)
    │
    ├── core/                   # Camada de Abstração
    │   └── SmartDevice.java    # Classe Abstrata (Base para dispositivos)
    │
    ├── devices/                # Implementação dos Dispositivos
    │   ├── SmartLight.java     # Lógica das Luzes
    │   ├── AirConditioner.java # Lógica do AC
    │   └── SecuritySystem.java # Lógica do Alarme
    │
    └── system/                 # Camada de Infraestrutura
        └── Connection.java     # Gestão de Sockets e I/O
📡 Protocolo de ComunicaçãoA troca de mensagens é feita através de strings em texto claro, utilizando o delimitador : para separar os argumentos.DispositivoComando EnviadoResposta EsperadaLuzLIGHT:1:ONLuz 1 está ONLuz (Brilho)LIGHT:1:BRIGHT:50Luz 1 brilho ajustado para 50%ACAC:2:TEMP:22AC 2 temperatura definida para 22CAlarmeALARM:3:PANIC(Ação de emergência no servidor)👨‍💻 AutorDesenvolvido por JoaoSantos497 no âmbito da unidade curricular de Programação Orientada a Objetos.


graph LR
    A[Java Client] -- Socket TCP (Port 9999) --> B[Python Server]
    B -- Response (String) --> A
```markdown
