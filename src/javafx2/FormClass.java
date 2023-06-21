package javafx2;

import database.Connector;
import javafx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FormClass {
    public TextField txtId;
    public TextField txtName;
    public TextField txtRoom;

    public void gotoAdd(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String room = txtRoom.getText();
            Classroom cl2 = new Classroom(name,room);
//
//            String sql = "insert into classrooms(name,room) values(?,?)";
//            PreparedStatement stt = conn.prepareStatement(sql);
//            stt.setString(1,cl2.getName());
//            stt.setString(2,cl2.getRoom());
//
//            stt.executeUpdate();
           gotoBack(null);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();

        }
    }

    public void gotoBack(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("listclass.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
    }
}




