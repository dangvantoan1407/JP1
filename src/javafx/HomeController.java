package javafx;

import javafx.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeController implements  Initializable {
    public static ObservableList<Student> listStudents = FXCollections.observableArrayList();
    public ListView<Student> lv;
    public static Student editStudent;





    public void goToForm(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("form.fxml"));
        Main.mainStage.setScene(new Scene(root,600,400));

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lv.setItems(listStudents);
    }
}
