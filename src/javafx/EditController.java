package javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class EditController {
    public void edit(ActionEvent actionEvent)throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
            Main.mainStage.setScene(new Scene(root,600,400));
    }

    public void Delete(ActionEvent actionEvent) {
    }
}
