/*
 * ChatControl controlla l'interazione delle comunicazioni
 * via rete con l'interfaccia utente.
 */

package my.net;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 *
 * @author Sandro
 */
public class ChatControl {

    int count;
    private final ChatClient m;
    
    public ChatControl() {
        m = new ChatClient();
        m.start();
    }
    
    @FXML private Text txtStatus;
    @FXML private TextField txtNick, txtPost;
    @FXML private TextArea txtMsg;

    @FXML
    protected void initialize() {
        count = 0;
        txtNick.setText(m.getNickname());
        JOptionPane.showMessageDialog(null, "Dati registrati", "Inserimento", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void postAction(ActionEvent event) {
        txtStatus.setText("Pulsante Post cliccato!");
        String p = txtPost.getText();
        count++;
        m.post(p);
        txtMsg.appendText("[" + count + "] " + p + "\n");
    }
    
    public void nickAction(ActionEvent event) {
        m.setNickname(txtNick.getText());
    }
    
}
