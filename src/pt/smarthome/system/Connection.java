package pt.smarthome.system;

import java.io.*;
import java.net.Socket;

public class Connection {
    private String host;
    private int port;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private Protocol protocol;

    public Connection(String host, int port, Protocol protocol) {
        this.host = host;
        this.port = port;
        this.protocol = protocol;
    }

    public void connect() {
        try {
            if (socket != null && !socket.isClosed()) return;

            this.socket = new Socket(host, port);
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(">> [REDE] Ligado ao servidor Python em " + host + ":" + port);

        } catch (IOException e) {
            System.err.println(">> [ERRO] Não foi possível ligar ao Python: " + e.getMessage());
        }
    }

    public String sendCommand(Command command) {
        if (socket == null || socket.isClosed()) connect();

        try {
            System.out.println("-> A enviar: " + protocol.generate(command));
            out.println(protocol.generate(command));

            String response = in.readLine();
            System.out.println("<- Recebido: " + response);
            return response;

        } catch (IOException e) {
            System.err.println("Erro de IO: " + e.getMessage());
            return "ERROR";
        }
    }

    public void disconnect() {
        try {
            if (socket != null) socket.close();
            System.out.println(">> [REDE] Desligado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}