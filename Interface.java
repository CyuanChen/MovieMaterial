import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.*;
import java.util.*;
 
public class Interface extends Application {
 
    private final TableView<value> table = new TableView<>();
    private final ObservableList<value> data =
            FXCollections.observableArrayList(
                     new value("Jacob", ""),
                     new value("Jacob", "")
           );
    final HBox hb = new HBox();
 
    public void test(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Qtag");
        stage.setWidth(800);
        stage.setHeight(600);
 
        
        
       final Label label = new Label("");
       
        table.setEditable(true);
 
        TableColumn fileCol = new TableColumn("File Name");
        fileCol.setMinWidth(200);
        fileCol.setCellValueFactory(
                new PropertyValueFactory<>("file"));
 
 
        TableColumn tagCol = new TableColumn("Tag");
        tagCol.setMinWidth(400);
        tagCol.setCellValueFactory(
                new PropertyValueFactory<>("email"));
 
        table.setItems(data);
        table.getColumns().addAll(fileCol, tagCol);
 
       final TextField addFirstName = new TextField();
        addFirstName.setPromptText("First Name");
        addFirstName.setMaxWidth(fileCol.getPrefWidth());
 
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(tagCol.getPrefWidth());
        addEmail.setPromptText("Email");
 
       
        
        final TextField search = new TextField();
        search.setPromptText("search tag");
        search.setMaxWidth(search.getPrefWidth());
        
        final Button searchButton = new Button("Search");
        searchButton.setOnAction((ActionEvent e) -> {
           
        });
        
        final Button infoButton = new Button("Info");
        searchButton.setOnAction((ActionEvent e) -> {
           
        });
        
        final Button pathButton = new Button("Path");
        searchButton.setOnAction((ActionEvent e) -> {
           
        });
        
        final Button removeButton = new Button("Remove");
        searchButton.setOnAction((ActionEvent e) -> {
           
        });
 
        hb.getChildren().addAll(search, searchButton,infoButton,pathButton,removeButton);
        hb.setSpacing(8);
       
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
 
    public static class value {
 
        private final SimpleStringProperty file;
   
        private final SimpleStringProperty tag;
 
        private value(String file,  String tag) {
            this.file = new SimpleStringProperty(file);
            
            this.tag = new SimpleStringProperty(tag);
        }
 
        public String getFile() {
            return file.get();
        }
// 
//        public void setFirstName(String fName) {
//            firstName.set(fName);
//        }
 
      
        public String gettag() {
            return tag.get();
        }
 
//        public void setEmail(String fName) {
//            email.set(fName);
//        }
    }
}