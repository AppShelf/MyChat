package my.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer extends Thread {

    boolean isRunning;
    private final int port;

    private void log(String msg) {
        System.out.println(msg);
    }
    
    public ChatServer(int port) {
        isRunning = true;
        this.port = port;
    }

    @Override
    public void run() {
        ServerSocket serverSocket;
        Broadcaster broadcaster = new Broadcaster();
        try {
            serverSocket = new ServerSocket(port);
            log("ChatServer su porta " + port + " avviato!");
            while (isRunning) {
                Socket socket = serverSocket.accept();
                Service service = new Service(socket, broadcaster);
                service.start();
            }
            serverSocket.close();
        } catch (IOException ex) {
            log( "Errore di IO: "+ ex.getMessage() );
        }
        log("ChatServer su porta " + port + " terminato!");
    }

}
