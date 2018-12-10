/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author DM3-2-17
 */
public class Person {
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty email;
    private final SimpleStringProperty postua;
    private final SimpleIntegerProperty urtea;
    
    public Person(String fName, String lName, String email, String postua, int urtea) { //derrigortuta nago, ezta? public jartzera beste pakete batetik sortuko dudalako?
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.email = new SimpleStringProperty(email);
        this.postua = new SimpleStringProperty(postua);
        this.urtea = new SimpleIntegerProperty(urtea);
    }

   
    public String getFirstName() 
    {
        return firstName.get();
    }
    public void setFirstName(String fName) 
    {
        firstName.set(fName);
    }
    public String getLastName() 
    {
        return lastName.get();
    }
    public void setLastName(String fName)
    {
        lastName.set(fName);
    }
    public String getEmail() 
    {
        return email.get();
    }
    public void setEmail(String fName) 
    {
        email.set(fName);
    }
    public String getPostua()
    {
        return postua.get();
    }
    public void setPostua(String fName) 
    {
        postua.set(fName);
    }
    public int getUrtea()
    {
        return urtea.get();
    }
    public void setUrtea(int fName) 
    {
        urtea.set(fName);
    }
}
