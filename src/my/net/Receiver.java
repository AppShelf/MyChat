/*
 * Receiver: Thread del client che raccoglie i post della chat trasmessi in broadcast
 */

package my.net;

/**
 *
 * @author Sandro
 */
public class Receiver extends Thread {
    boolean isRunning;
    Channel channel;

    public Receiver( Channel channel ) {
        this.channel = channel;
        isRunning = true;
    }
    
    @Override
    public void run() {
        String msg;
        while (isRunning) {
            msg = channel.readLine();
            if (msg==null) isRunning=false;
            else System.out.println(msg);
        }
    }

    public void stopRunning() {
        isRunning = false;
    }
}
