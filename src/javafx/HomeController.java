package javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class HomeController {
    public ListView<Student> lv;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtPhone;

    public static ObservableList<Student> listStudents = FXCollections.observableArrayList();
    public static Student editStudent;


    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String tel = txtPhone.getText();
            if (editStudent != null) {
                editStudent.setName(name);
                editStudent.setEmail(email);
                editStudent.setTel(tel);
                lv.setItems(listStudents);
                lv.refresh();
                editStudent = null;
                txtName.clear();
                txtEmail.clear();
                txtPhone.clear();
                return;
            }
            for (Student s : listStudents) {
                if (s.getName().equals(name))
                    throw new Exception("Tên sinh viên đã tồn tại");
                if (s.getEmail().equals(email))
                    throw new Exception("Email đã tồn tại");
            }
            Student sv = new Student(name, email, tel);
            listStudents.add(sv);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }


    }

    public void editStudent(MouseEvent mouseEvent) {
        editStudent = lv.getSelectionModel().getSelectedItem();
        if (editStudent != null) {
            txtName.setText(editStudent.getName());
            txtEmail.setText(editStudent.getEmail());
            txtPhone.setText(editStudent.getTel());
        }
    }//ListView
}
