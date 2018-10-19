/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Circle;

/**
 *
 * @author aras1
 */
public class FXMLDocumentController implements Initializable {
    
    
    
    @FXML
    private Label label;
    @FXML
    private ImageView image;
    @FXML
    private ImageView image2;
    @FXML
    private ProgressBar pb;
    @FXML
    private ProgressBar pb2;
    @FXML
    private ProgressBar pb3;
    @FXML
    private ProgressBar pb4;
    
    @FXML
    private RadioButton rb;
    
    @FXML
    private RadioButton rb2;
    
    @FXML
    private Slider sli;
    
    @FXML
    private ToggleButton tg;
    Boolean isOn=false;
    
    @FXML
   private ToggleGroup group;       
    
    AudioClip ac1=new AudioClip(getClass().getResource("1.wav").toExternalForm());
    AudioClip ac2=new AudioClip(getClass().getResource("1.wav").toExternalForm());
    AudioClip ac3=new AudioClip(getClass().getResource("1.wav").toExternalForm());
    AudioClip ac4=new AudioClip(getClass().getResource("1.wav").toExternalForm());
    AudioClip major;
   
    Double i=0.0;
    Double value=1.0;
    
    void right()
    {
        pb.setProgress(pb.getProgress()+0.003);
        pb2.setProgress(pb.getProgress()+0.003);
        pb3.setProgress(pb.getProgress()+0.003);
        pb4.setProgress(pb.getProgress()+0.003);
        checkWave();
         
    }
    
    public void checkWave()
    {
        
    if(rb.isSelected())
    {
    if(isOn&&pb.getProgress()>0.2&&pb.getProgress()<0.4)
        play(ac1);
        else
        stopPlay(ac1);
    
    if(isOn&&pb.getProgress()>0.6&&pb.getProgress()<0.8)
        play(ac2);
        else
        stopPlay(ac2);
    }
    
    if(rb2.isSelected())
    {
    if(isOn&&pb.getProgress()>0.2&&pb.getProgress()<0.4)
        play(ac3);
        else
        stopPlay(ac3);
    
    if(isOn&&pb.getProgress()>0.6&&pb.getProgress()<0.8)
        play(ac4);
        else
        stopPlay(ac4);
    }
    }
    
    void left()
    {
        pb.setProgress(pb.getProgress()-0.003);
        pb2.setProgress(pb.getProgress()-0.003);
        pb3.setProgress(pb.getProgress()-0.003);
        pb4.setProgress(pb.getProgress()-0.003);
        checkWave();
    }
    
    void off()
    {
    pb.setStyle("-fx-accent: black");
    pb2.setStyle("-fx-accent: black");
    pb3.setStyle("-fx-accent: black");
    pb4.setStyle("-fx-accent: black");
    }
    
    void on()
    {
    pb.setStyle("-fx-accent: orange ");
    pb2.setStyle("-fx-accent: orange ");
    pb3.setStyle("-fx-accent: orange ");
    pb4.setStyle("-fx-accent: orange ");
    }
    
    void play(AudioClip x)
    {
    if(!x.isPlaying())
    x.play(value);
    major=x;
    }
    void stopPlay(AudioClip x)
    {
    if(x.isPlaying())
    x.stop();
    }
    


    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        off();
        
        sli.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                value=newValue.doubleValue();
                if(major!=null&&major.isPlaying())
                {
                major.stop();
                major.play(value);
                }
                
            }
        });
        
        image2.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>()
         {
         @Override
         public void handle(MouseEvent event) {
             image.setRotate(event.getX());
             if(event.getX()>i&&pb.getProgress()<1)
             right();
             else if(event.getX()<i&&pb.getProgress()>0.01)
             left();
             i=event.getX();
         }
         



        
        });
     tg.addEventHandler(MouseEvent.MOUSE_PRESSED,  new EventHandler<MouseEvent>()
         {
         @Override
         public void handle(MouseEvent event) {
             isOn=!isOn;
             
             if(isOn.equals(true))
             on();
             else 
             off();
             
         checkWave();   
         }
         
         
         



        
        });
        
    }
    
    
    
    
}
