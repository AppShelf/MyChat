package my.net;

import java.io.*;
import java.net.Socket;

public class ChatClient {

    private String nickName;
    private final int hostPort;
    private final String hostName;

    Socket socket = null;
    Channel channel = null;
    Receiver receiver = null;
    
    public ChatClient() {
        nickName = Config.nick;
        hostPort = Config.port;
        hostName = Config.name;
    }
    
    public void start() {
        try {
            socket = new Socket(hostName, hostPort);
            channel = new Channel(socket);
            receiver = new Receiver(channel);
            receiver.start();
            log("Client di chat avviato per " + nickName);
        } catch (IOException ex) {
            log("Errore di IO: " + ex.getMessage());
        }
    }
    
    public void stop() {
        receiver.stopRunning();
        channel.close();
    }

    private void log(String msg) {
        System.out.println(msg);
    }
    
    public String getNickname() {
        return nickName;
    }
    
    public void setNickname(String nickName) {
        this.nickName = nickName;
    }
    
    public void post(String msg) {
        if (msg.equalsIgnoreCase("quit")) {
            channel.writeLine(msg);
            stop();
        } else channel.writeLine( nickName + "> " + msg );
    }
    
}
