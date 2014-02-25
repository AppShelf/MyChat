/*
 * MyChat client application.
 */

package mychat;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sandro
 */
public class MyChat extends Application {
    
    Stage stage;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        open("/my/net/view/chatview.fxml");
    }
    
    void open( String fxml ) {
        stage.setTitle("My Chat");
        try {
            Parent root = FXMLLoader.load( this.getClass().getResource( fxml ) );
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.printf("FXML %s non trovato!\n[%s]\n", fxml, ex.getMessage());
        }
    }
    
}
