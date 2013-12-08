/*
 * Service: Thread che serve la comunicazione con un singolo client connesso
 */

package my.net;

import java.net.Socket;

/**
 *
 * @author Sandro
 */
public class Service extends Thread {

    boolean isRunning;
    Socket socket;
    Channel channel;
    Broadcaster broadcaster;
    
    public Service(Socket socket, Broadcaster broadcaster) {
        isRunning = true;
        this.socket = socket;
        this.broadcaster = broadcaster;
    }

    @Override
    public void run() {
        channel = new Channel(socket);
        broadcaster.addService(this);
        while (isRunning) {
            String line = channel.readLine();
            if (line.equalsIgnoreCase("quit")) isRunning=false;
            else {
                System.out.println(line);
                broadcaster.sendAll(line, this);
            }
        }
        broadcaster.deleteService(this);
        channel.close();
    }
    
    public void doBroadcast( String msg ) {
        channel.writeLine(msg);
    }
    
}
