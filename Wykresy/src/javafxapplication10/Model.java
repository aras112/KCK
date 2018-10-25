/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication10;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author aras1
 */
public class Model {
    final private StringProperty miesiac;
    final private StringProperty place;

    public Model(String miesiac, String place) {
        this.miesiac = new SimpleStringProperty(miesiac);
        this.place = new SimpleStringProperty(place);
    }

    public StringProperty getMiesiac() {
        return miesiac;
    }

    public StringProperty getPlace() {
        return place;
    }
    
    
    
    
    
}
