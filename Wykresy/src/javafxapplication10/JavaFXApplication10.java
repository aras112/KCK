/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication10;

import javafx.application.Application;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author aras1
 */
public class JavaFXApplication10 extends Application {
    
     ObservableList<Model> data=FXCollections.observableArrayList();

    public JavaFXApplication10() {
     data.add(new Model("Styczeń","2000"));
    }
     
    public ObservableList<Model> getModel() {
        return data;
    }
     
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(this.getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        FXMLDocumentController c=loader.getController();
        c.mainApp(this);
        
      
        Scene scene = new Scene(root);
        stage.setMinHeight(600);
        stage.setMinWidth(600);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
