/*
 * Channel
 * incapsula un socket in metodi di read/write
 */

package my.net;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author Sandro
 */
public class Channel {
    
    Socket socket;
    BufferedReader in;
    PrintStream out;

    private void log(String msg) {
        System.out.println(msg);
    }
    
    public Channel(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            out = new PrintStream(socket.getOutputStream());
        } catch (IOException ex) {
            log("Errore di rete: " + ex.getMessage());
        }
        
    }
    
    public void writeLine(String line) {
        out.println(line);
        out.flush();
    }
    
    public String readLine() {
        String line = null;
        try {
            line = in.readLine();
        } catch (IOException ex) {
            log(ex.getMessage());
        }
        return line;
    }

    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException ex) {
            log("Errore di rete: " + ex.getMessage());
        }
    }
    
}
