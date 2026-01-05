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
