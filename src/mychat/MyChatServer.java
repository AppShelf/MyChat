/*
 * MyChatServer: Chat Server Application
 */

package mychat;

import my.net.Config;
import my.net.*;

/**
 *
 * @author Sandro
 */
public class MyChatServer {
    
    /**
     * @param args the command line arguments
     * args[0] = serverport | <null>
     */
    public static void main(String[] args) {

        int porta = Config.port;
        
        if (args.length>0) {
            int n = Integer.parseInt(args[0]);
            if (n>1024 && n<=65535) porta=n;
        }
        
        ChatServer s = new ChatServer( porta );
        s.start();

    }
    
}
