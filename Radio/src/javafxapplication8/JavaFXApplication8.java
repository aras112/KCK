/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sun.net.www.content.image.png;

/**
 *
 * @author aras1
 */
public class JavaFXApplication8 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        String tlo = getClass().getResource("4.jpg").toString();
        root.setStyle("-fx-background-image: url("+tlo+")");
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setMaxHeight(300);
        stage.setMinHeight(300);
        stage.setMaxWidth(1200);
        stage.setMinWidth(1200);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
