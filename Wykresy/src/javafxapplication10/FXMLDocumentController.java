/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author aras1
 */
public class FXMLDocumentController implements Initializable {
    
    
    private JavaFXApplication10 mainApp;
    
    @FXML
    private TableView<Model> table;
    @FXML
    private TableColumn<Model, String> firstNameColumn;
    @FXML
    private TableColumn<Model, String> lastNameColumn;
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    
    boolean i=false;
    
    final CategoryAxis x = new CategoryAxis();
    final NumberAxis y = new NumberAxis();
    
    
    @FXML
    private BarChart<String,Number> bc=new BarChart<>(x,y);
    
    XYChart.Series series1 = new XYChart.Series();
            
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        
        bc.getData().add(series1);
        
        firstNameColumn.setCellValueFactory(value->
                value.getValue().getMiesiac()
        );
        
        lastNameColumn.setCellValueFactory(value->
                value.getValue().getPlace()
        );
        table.getSelectionModel().selectedIndexProperty().addListener(
                
                
                (observable, oldValue, newValue) -> {
                
                tf1.setText(table.getSelectionModel().getSelectedItem().getMiesiac().get());
                tf2.setText(table.getSelectionModel().getSelectedItem().getPlace().get());
                
                }
        
        );

    } 
    
    @FXML
    void add() throws InterruptedException
    {
    
    table.getItems().add(new Model(tf1.getText(),tf2.getText()));
    series();
    }
    @FXML
    void edit()
    {
    
    
    for(Model model :table.getItems())
        {
        if(model.getMiesiac().get().equals(tf1.getText()))
        {
        i=true;
        }
        }
    
    table.getItems().add(table.getSelectionModel().getSelectedIndex(), new Model(tf1.getText(),tf2.getText()));
    
    if(i)
        {
        table.getItems().remove(table.getSelectionModel().getSelectedIndex());
        }
    
    i=false;
    
    series();
    }
    
     void series()
    {
        bc.getData().remove(0);
        series1 = new XYChart.Series();
        
        for(Model model :table.getItems())
        {
        series1.getData().add(new XYChart.Data(model.getMiesiac().get(), Integer.valueOf(model.getPlace().get())/1000D));
        }
        
         
         bc.getData().add(series1);
        
        
       
    }

 

    public void mainApp(JavaFXApplication10 mainApp) {
        this.mainApp = mainApp;
        table.setItems(mainApp.getModel());
        table.getSelectionModel().clearAndSelect(0);
        series();
    }
    
    
    
}
