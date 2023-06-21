package javafx2;

import daopattern.RoomIRepository;
import database.Connector;
import javafx.Main;
import javafx.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ClassroomController implements Initializable {

    public TableView<Classroom> tbvC;
    public TableColumn<Classroom, Integer> cID;
    public TableColumn<Classroom, String> cName;
    public TableColumn <Classroom,String>cRoom;
    public TableColumn <Classroom, Button> cAction;
    public Button create;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cID.setCellValueFactory(new PropertyValueFactory<>("id"));
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cRoom.setCellValueFactory(new PropertyValueFactory<>("room"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("edit"));
        System.out.println("2");

      try{

          ObservableList<Classroom> list = FXCollections.observableArrayList();
          list.addAll(RoomIRepository.getInstance().getAll());
          tbvC.setItems(list);


      }catch (Exception e) {
          System.out.println(e.getMessage());

      }
    }


    public void gotoForm(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("formlist.fxml"));
        Main.mainStage.setScene(new Scene(root,600,400));
    }
}
