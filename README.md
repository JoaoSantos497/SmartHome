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

```mermaid
graph LR
    A[Java Client] -- Socket TCP (Port 9999) --> B[Python Server]
    B -- Response (String) --> A

```

✨ Funcionalidades💡 Iluminação (SmartLight)Ligar/Desligar luzes remotamente.Ajustar intensidade do brilho (0-100%).❄️ Climatização (AirConditioner)Ligar/Desligar o ar condicionado.Definir a temperatura desejada.🚨 Segurança (SecuritySystem)Armar/Desarmar: Ativa ou desativa os sensores de movimento.Botão de Pânico: Envia um sinal de emergência imediato para o servidor, independentemente do estado do sistema.🛠 Pré-requisitosPara executar este projeto, necessitas de ter instalado:Java JDK 8 ou superior.Python 3.x.Um IDE (recomendado: IntelliJ IDEA ou VS Code).🚀 Como ExecutarSiga estes passos na ordem exata para garantir a conexão.Passo 1: Iniciar o Servidor (Cérebro)No terminal, navegue até à pasta raiz do projeto e execute:Bashpython main.py
Deverá ver a mensagem: === Servidor SmartHome Python a correr na porta 9999 ===Passo 2: Iniciar o Cliente (Comando)No teu IDE Java (ou outro terminal), compila e executa a classe principal:src/pt/smarthome/SmartHomeApp.javaDeverá ver o menu interativo:Plaintext--- BEM-VINDO À SMART HOME ---
Escolha uma opção:
1. Ligar Luz
...
📂 Estrutura do ProjetoSmartHome/
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
📡 Protocolo de ComunicaçãoA comunicação é feita através de strings simples formatadas com o separador :.DispositivoComando EnviadoResposta do ServidorLuzLIGHT:1:ONLuz 1 está ONLuz (Brilho)LIGHT:1:BRIGHT:50Luz 1 brilho ajustado para 50%ACAC:2:TEMP:22AC 2 temperatura definida para 22CAlarmeALARM:3:PANIC(Ação de emergência)👨‍💻 AutorDesenvolvido por JoaoSantos497 no âmbito da unidade curricular de Programação Orientada a Objetos.
