package javafx;

import com.sun.deploy.util.Property;
import daopattern.StudentIReponsitory;
import database.Connector;
import enums.RepositoryType;
import factory.RepositoryFactory;
import javafx.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class  HomeController implements  Initializable {

    public static Student editStudent;
    public TableColumn<Student, Integer> tcId;
    public TableView<Student> tbV;
    public TableColumn <Student,String>tcName;
    public TableColumn <Student,String>tcEmail;
    public TableColumn <Student,String>tcTel;
    public TableColumn <Student, Button> tcAction;
    public Text txtMin;
    public Text txtSec;
    public Text lbPage;
    public Button btnCreate;
    public ComboBox<Locale> cbLang;
    private Integer x = 10;
    private Integer y = 0;

    public void goToForm(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("form.fxml"));
        Main.mainStage.setScene(new Scene(root,600,400));

    }
    private void initMessages(){
    ResourceBundle rb = ResourceBundle.getBundle("resources.messages");
       lbPage.setText(rb.getString("student_list"));
       btnCreate.setText(rb.getString("create_student"));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //set list items for cbLang
        ObservableList<Locale> langs = FXCollections.observableArrayList();
        langs.add(new Locale("vi","VN"));
        langs.add(new Locale("en","VN"));
        cbLang.setItems(langs);
        cbLang.setValue(Locale.getDefault());

        initMessages();
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        tcAction.setCellValueFactory(new PropertyValueFactory<>("edit"));

        try {
            ObservableList<Student> list = FXCollections.observableArrayList();
            list.addAll(RepositoryFactory.createRepositoryInstance(RepositoryType.STUDENT).getAll());
            tbV.setItems(list);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       // lv.setItems(listStudents);


        new Thread(()->{
            boolean flag = true;
            while (flag){
                String m = x>=10?x.toString():"0"+x;
                String s = y>=10?y.toString():"0"+y;
                txtMin.setText(m);
                txtSec.setText(s);
                y--;
                if(y <0){
                    y = 59;
                    x--;
                }
                if(x<0){
                    flag = false;
                }
                try{
                    Thread.sleep(1000);
                }catch (Exception e){}
            }

        }).start();

    }

    public void editstd(ActionEvent actionEvent)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("edit.fxml"));
        Main.mainStage.setScene(new Scene(root,600,400));

    }

    public void chooseLang(ActionEvent actionEvent) throws Exception {
        Locale ch = cbLang.getValue();
        Locale.setDefault(ch);
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.mainStage.setScene(new Scene(root,1000,600));

    }
}
