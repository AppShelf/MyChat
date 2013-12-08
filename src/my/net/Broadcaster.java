/*
 * Broadcaster: Classe che permette ai services di un server
 * di scambiarsi messaggi in broadcast fra loro
 */

package my.net;

import java.util.ArrayList;

/**
 *
 * @author Sandro
 */
public class Broadcaster {
    ArrayList<Service> servizi;

    public Broadcaster() {
        servizi = new ArrayList<>();
    }
    
    public void sendAll(String msg, Service mittente) {
        for (Service servizio : servizi) {
            if (servizio != mittente) {
                servizio.doBroadcast(msg);
            }
        }
    }
    public void addService(Service s) {
        servizi.add(s);
    }
    
    public boolean deleteService(Service s) {
        return servizi.remove(s);
    }
}
