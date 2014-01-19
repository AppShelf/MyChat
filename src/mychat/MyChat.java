/*
 * MyChat client application.
 */

package mychat;

import my.net.*;

/**
 *
 * @author Sandro
 */
public class MyChat {

    /**
     * @param args the command line arguments
     * args[0] = servername | <null>
     * args[1] = serverport | <null>
     */
    public static void main(String[] args) {
        
        int remoteport = Config.port;
        String remotehost = "localhost";

        if (args.length>0) {
            remotehost = args[0];
        }
        if (args.length>1) {
            int n = Integer.parseInt(args[1]);
            if (n>1024 && n<=65535) remoteport=n;
        }
        
        ChatClient c = new ChatClient( remotehost, remoteport );
        c.start();
        
    }
    
}
