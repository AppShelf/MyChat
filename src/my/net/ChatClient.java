package my.net;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient extends Thread {

    boolean isRunning;
    String hostName;
    private final int hostPort;

    public ChatClient(String hostName, int hostPort) {
        isRunning = true;
        this.hostPort = hostPort;
        this.hostName = hostName;
    }

    private void log(String msg) {
        System.out.println(msg);
    }
    
    @Override
    public void run() {
        Scanner lettore;
        lettore = new Scanner(System.in);
        System.out.print("Inserire un NICKNAME: ");
        String nick = lettore.nextLine();
        Socket socket;
        try {
            socket = new Socket(hostName, hostPort);
            Channel channel = new Channel(socket);
            Receiver receiver = new Receiver(channel);
            receiver.start();
            System.out.println("Client di chat avviato per " + nick);
            while (isRunning) {
                // System.out.print(nick + "> ");
                String line = lettore.nextLine();
                if (line.equalsIgnoreCase("quit")) {
                    channel.writeLine(line);
                    isRunning = false;
                } else channel.writeLine(nick + "> " + line);
            }
            channel.close();
            lettore.close();
        } catch (IOException ex) {
            log("Errore di IO: " + ex.getMessage());
        }
    }
    
}
