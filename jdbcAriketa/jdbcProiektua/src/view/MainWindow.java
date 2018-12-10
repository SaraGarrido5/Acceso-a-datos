/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GestionListaEnMemoria;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javax.xml.parsers.ParserConfigurationException;
import model.Person;
import org.xml.sax.SAXException;

/**
 *
 * @author DM3-2-17
 */
public class MainWindow extends Application{
    private final TableView<Person> table = new TableView<>();

    final HBox hb = new HBox();
    File f;
    
    
    public void start(Stage stage) throws ParserConfigurationException, SAXException, SQLException, ClassNotFoundException {
       Scene scene = new Scene(new Group());
      /*  FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Aukeratu fitxategia");
        fileChooser.showOpenDialog(stage);
        f=fileChooser.getInitialDirectory();*/
        ObservableList<Person> data = GestionListaEnMemoria.cargarDatos();
        
        stage.setTitle("Datuen Taula");
        stage.setWidth(700);
        stage.setHeight(550);
        final Label label = new Label("Jokalariak");
        label.setFont(new Font("Arial", 20));
        
        table.setEditable(true);
        
        TableColumn<Person, String> firstNameCol = new TableColumn<>("Izena");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        firstNameCol.setOnEditCommit((TableColumn.CellEditEvent<Person, String> t) -> 
        {((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFirstName(t.getNewValue());
           try {
               GestionListaEnMemoria.aldatu((Person) t.getTableView().getItems().get(t.getTablePosition().getRow()));
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
           }
        });
        
        TableColumn<Person, String> lastNameCol = new TableColumn<>("Abizena");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        lastNameCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Person, String> t) -> {
            ((Person) t.getTableView().getItems().get(
            t.getTablePosition().getRow())
            ).setLastName(t.getNewValue());
           try {
               GestionListaEnMemoria.aldatu((Person) t.getTableView().getItems().get(t.getTablePosition().getRow()));
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
           }
            });
        
        TableColumn<Person, String> emailCol = new TableColumn<>("eMaila");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
        new PropertyValueFactory<>("email"));
        emailCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        emailCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Person, String> t) -> {
                ((Person) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
                ).setEmail(t.getNewValue());
           try {
               GestionListaEnMemoria.aldatu((Person) t.getTableView().getItems().get(t.getTablePosition().getRow()));
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
           }
            });
        
        TableColumn<Person, String> postuaCol =new TableColumn<>("Postua");
        postuaCol.setMinWidth(100);
        postuaCol.setCellValueFactory(new PropertyValueFactory<>("postua"));
        postuaCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        postuaCol.setOnEditCommit((TableColumn.CellEditEvent<Person, String> t) -> 
        {((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPostua(t.getNewValue());
           try {
               GestionListaEnMemoria.aldatu((Person) t.getTableView().getItems().get(t.getTablePosition().getRow()));
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
           }
        });
        
        TableColumn<Person, Integer> urtea = new TableColumn<>("Urtea"); // zutabearen titulua
        urtea.setMinWidth(75); // zabalera minimoa
        urtea.setCellValueFactory(new PropertyValueFactory<Person, Integer>("urtea"));
        urtea.setCellFactory(TextFieldTableCell.<Person, Integer>forTableColumn(new IntegerStringConverter())); // Integerrera bihurtu
        urtea.setOnEditCommit(
            (TableColumn.CellEditEvent<Person, Integer> t) -> {
            ((Person) t.getTableView().getItems().get(
            t.getTablePosition().getRow())
            ).setUrtea(t.getNewValue());
           try {
               GestionListaEnMemoria.aldatu((Person) t.getTableView().getItems().get(t.getTablePosition().getRow()));
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
           }
            });
        
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,postuaCol,urtea);
        
        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("izen");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("abizen");
        
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("email");
        
        final TextField addPostua = new TextField();
        addPostua.setMaxWidth(postuaCol.getPrefWidth());
        addPostua.setPromptText("postua");
        
        final TextField addUrtea = new TextField();
        addUrtea.setMaxWidth(postuaCol.getPrefWidth());
        addUrtea.setPromptText("urtea");
       
        final Button addButton = new Button("Gehitu");
        addButton.setStyle("-fx-background-color:green; ");        
        addButton.setOnAction((ActionEvent e) -> {
            Person p = new Person(
                addFirstName.getText(),
                addLastName.getText(),
                addEmail.getText(),
                addPostua.getText(),
                Integer.parseInt(addUrtea.getText()));
            data.add(p);//añadiendo al observable list
           try {
               GestionListaEnMemoria.Gorde(p);
           } catch (SQLException ex) {
               Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            addFirstName.clear();
            addLastName.clear();
            addEmail.clear();
            addPostua.clear();
            addUrtea.clear();
        });
        
        
        final Button removeButton = new Button("Ezabatu");        
        removeButton.setStyle("-fx-background-color:green; ");
        removeButton.setOnAction((ActionEvent e) -> {
            Person person = table.getSelectionModel().getSelectedItem();    
            data.remove(person);
           try {
                 GestionListaEnMemoria.ezabatu(person);
           } catch (SQLException ex) {
               Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
           }
        });
        
        hb.getChildren().addAll(addFirstName, addLastName, addEmail,addPostua,addUrtea, addButton, removeButton);
        hb.setSpacing(3);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();        
        
    }

        /* Scene scene = new Scene(new Group());
        
        ObservableList<Person> data = GestionListaEnMemoria.cargarDatos();
        
        stage.setTitle("Datuen Taula");
        stage.setWidth(550);
        stage.setHeight(550);
        final Label label = new Label("Jokalariak");
        label.setFont(new Font("Arial", 20));
        
        table.setEditable(true);
        
        TableColumn<Person, String> firstNameCol = new TableColumn<>("Izena");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        firstNameCol.setOnEditCommit((TableColumn.CellEditEvent<Person, String> t) -> 
        {((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFirstName(t.getNewValue());});
        
        TableColumn<Person, String> lastNameCol = new TableColumn<>("Abizena");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        lastNameCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Person, String> t) -> {
            ((Person) t.getTableView().getItems().get(
            t.getTablePosition().getRow())
            ).setLastName(t.getNewValue());
            });
        
        TableColumn<Person, String> emailCol = new TableColumn<>("eMaila");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
        new PropertyValueFactory<>("email"));
        emailCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        emailCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Person, String> t) -> {
                ((Person) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
                ).setEmail(t.getNewValue());
            });
        
        TableColumn<Person, String> postuaCol =new TableColumn<>("Postua");
        postuaCol.setMinWidth(100);
        postuaCol.setCellValueFactory(new PropertyValueFactory<>("postua"));
        postuaCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        postuaCol.setOnEditCommit((TableColumn.CellEditEvent<Person, String> t) -> 
        {((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPostua(t.getNewValue());});
        
        TableColumn<Person, Integer> urtea = new TableColumn<>("Urtea"); // zutabearen titulua
        urtea.setMinWidth(75); // zabalera minimoa
        urtea.setCellValueFactory(new PropertyValueFactory<Person, Integer>("urtea"));
        urtea.setCellFactory(TextFieldTableCell.<Person, Integer>forTableColumn(new IntegerStringConverter())); // Integerrera bihurtu
        urtea.setOnEditCommit(
            (TableColumn.CellEditEvent<Person, Integer> t) -> {
            ((Person) t.getTableView().getItems().get(
            t.getTablePosition().getRow())
            ).setUrtea(t.getNewValue());
            });
        
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,postuaCol,urtea);
        
        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("izen");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("abizen");
        
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("email");
        
        final TextField addPostua = new TextField();
        addPostua.setMaxWidth(postuaCol.getPrefWidth());
        addPostua.setPromptText("postua");
        
        final TextField addUrtea = new TextField();
        addUrtea.setMaxWidth(urtea.getPrefWidth());
        addUrtea.setPromptText("urtea");
       
        final Button addButton = new Button("Gehitu");        
        addButton.setOnAction((ActionEvent e) -> {
            Person p = new Person(
                addFirstName.getText(),
                addLastName.getText(),
                addEmail.getText(),
                addPostua.getText(),
            Integer.parseInt(addUrtea.getText()));
            data.add(p);//añadiendo al observable list
            GestionListaEnMemoria.Gorde(data);
            
            addFirstName.clear();
            addLastName.clear();
            addEmail.clear();
            addPostua.clear();
            addUrtea.clear();
        });
        
        
        final Button removeButton = new Button("Ezabatu");        
        removeButton.setOnAction((ActionEvent e) -> {
            Person person = table.getSelectionModel().getSelectedItem();    
            data.remove(person);
            GestionListaEnMemoria.Gorde(data);
        });
        
        hb.getChildren().addAll(addFirstName, addLastName, addEmail,addPostua,addUrtea, addButton, removeButton);
        hb.setSpacing(3);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
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
