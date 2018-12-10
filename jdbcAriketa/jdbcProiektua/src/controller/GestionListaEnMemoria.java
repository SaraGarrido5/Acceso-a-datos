/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.parsers.ParserConfigurationException;

import model.Person;

import org.xml.sax.SAXException;




/**
 *
 * @author DM3-2-17
 */
public class GestionListaEnMemoria {


    
    
    public static ObservableList<Person> cargarDatos() throws ParserConfigurationException, SAXException, SQLException, ClassNotFoundException {
        //sartzen ditu taulan datuak 

        ObservableList<Person> listia = FXCollections.observableArrayList();
        dbkon conex= new dbkon();//Konexioa burutu
        ResultSet res = null;
        PreparedStatement kontsulta = null;
        
        try
        {
            kontsulta = conex.getConnection().prepareStatement("SELECT * FROM jokalariak");
            res = kontsulta.executeQuery();//kontsulta exekutatu eta amaitzarekin kurtsorea kargatu

            while(res.next())
            {
                String izena = res.getString("izena");
                String abizena = res.getString("abizena");
                String email = res.getString("emaila");
                String postua = res.getString("postua");
                int urtea= res.getInt("urtea");
                Person per = new Person(izena,abizena,email,postua,urtea);
                listia.add(per);
                
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(dbkon.class.getName()).log(Level.SEVERE, null, ex);
        }
        conex.desconectar();
        res.close();
        kontsulta.close();
          
     return listia;   
           
        }
        
      
 public static void Gorde(Person per) throws SQLException, ClassNotFoundException 
    {
        dbkon conex= new dbkon();//Konexioa burutu
        PreparedStatement kontsulta = conex.getConnection().prepareStatement("INSERT INTO jokalariak (izena,abizena,emaila,postua,urtea) VALUES(?,?,?,?,?)");
        
        try
        {
            kontsulta.setString(1,per.getFirstName());
            kontsulta.setString(2,per.getLastName());
            kontsulta.setString(3,per.getEmail());
            kontsulta.setString(4,per.getPostua());
            kontsulta.setInt(5,per.getUrtea());
          
            
            kontsulta.executeUpdate();
            kontsulta.close();
            conex.desconectar();
                    
        }
        catch(SQLException e)
        {
            System.out.println("Error no se conecto");
        }
    }
    public static void ezabatu(Person per) throws ClassNotFoundException, SQLException {

        dbkon conex= new dbkon();
        PreparedStatement kontsulta = conex.getConnection().prepareStatement("DELETE FROM jokalariak WHERE emaila = ?");
            kontsulta.setString(1, per.getEmail());
            kontsulta.executeUpdate();
   
            
              
}
    
    public static void aldatu(Person per) throws ClassNotFoundException, SQLException
    {
        dbkon conex= new dbkon();
        PreparedStatement kontsulta = conex.getConnection().prepareStatement("UPDATE  jokalariak SET  izena = ?,abizena = ?, emaila = ?, postua = ?, urtea = ? WHERE emaila = ? ");
        kontsulta.setString(1, per.getFirstName());
            kontsulta.setString(2,per.getLastName());
            kontsulta.setString(3, per.getEmail());
            kontsulta.setString(4,per.getPostua());
            kontsulta.setInt(5,per.getUrtea());
            kontsulta.setString(6, per.getEmail());
            kontsulta.executeUpdate();
        
       
    }
  }

   

/*    public static void Gorde(ObservableList<Person> lista) {
       
        try {
            // Create file 
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            
            Element eRaiz = doc.createElement("jokalariak");
            doc.appendChild(eRaiz);
            
            for(Person per:lista)
            {
                Element ePerson = doc.createElement("jokalaria");
                eRaiz.appendChild(ePerson);
                
                Element efirstName = doc.createElement("izena");
                efirstName.appendChild(doc.createTextNode(per.getFirstName()));
                ePerson.appendChild(efirstName);
                
                Element eabizena = doc.createElement("abizena");
                eabizena.appendChild(doc.createTextNode(per.getLastName()));
                ePerson.appendChild(eabizena);
                
                Element email = doc.createElement("emaila");
                email.appendChild(doc.createTextNode(per.getEmail()));
                ePerson.appendChild(email);
                
                Element epostua = doc.createElement("postua");
                epostua.appendChild(doc.createTextNode(per.getPostua()));
                ePerson.appendChild(epostua);
                
                Element eurtea = doc.createElement("urtea");
                eurtea.appendChild(doc.createTextNode(String.valueOf(per.getUrtea())));
                ePerson.appendChild(eurtea);
            }
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           DOMSource source = new DOMSource(doc);
           StreamResult result = new StreamResult(new File("fitxeroa.xml"));
           transformer.transform(source, result);
        } catch (Exception e) 
        {//Catch exception if any
            e.printStackTrace();
        }
    }

}
*/