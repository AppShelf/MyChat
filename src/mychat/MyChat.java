/*
 * MyChat TUI client/server application.
 */

package mychat;

import java.util.Scanner;
import my.net.*;

/**
 *
 * @author Sandro
 */
public class MyChat {

    /**
     * @param args the command line arguments
     * args[0] = server | <null>
     */
    public static void main(String[] args) {
        
        int porta = 9999;
        String remotehost = "localhost";
        
        if ( args.length>0 && args[0].equalsIgnoreCase("server") ) {
            if (args.length>1) {
                int n = Integer.parseInt(args[1]);
                if (n>1024 && n<=65535) porta=n;
            }
            ChatServer s = new ChatServer( porta );
            s.start();
            System.out.println("MyChat Server avviato sulla porta: " + porta + "\n");
        } else {
            Scanner lettore = new Scanner(System.in);
            System.out.print("Nome o IP del server remoto: ");
            String s = lettore.nextLine();
            if (s.length()>0) remotehost = s;
            ChatClient c = new ChatClient( remotehost, porta );
            c.start();
        }
        
    }
    
}
