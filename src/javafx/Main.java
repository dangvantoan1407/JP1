package javafx;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import database.Connector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Locale;

public class Main extends Application {
    public static void main(String[] args) {
        String name = "abc xyz";
        String email = "abcxyz@gmail.com";
        String pwd="123456";
        //hash password
        String salt = BCrypt.gensalt();
        String hashedPwd = BCrypt.hashpw(pwd,salt);
 //save db
        String sql = "insert into users(name,email,password) values(?,?,?)";
        try {
//            Connection conn = Connector.getInstance().getConn();
//            PreparedStatement ptt = (PreparedStatement) conn.prepareStatement(sql);
//            ptt.setString(1, name);
//            ptt.setString(2, email);
//            ptt.setString(3,hashedPwd);
//            ptt.executeUpdate();

        }catch (Exception e){}
        //login
//        String dbPass = "$2a$10$j85Fvg/0TVfA1XMv6WTmOOdy4Yoz9Ed8R6aF3vQ/jiP...\n";
//        String pass = "123456";
//        boolean check = BCrypt.checkpw(pass,dbPass);
//        System.out.println(check);
        launch(args);
    }

    public static Stage mainStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        Locale EN = new Locale("en","VN");
        Locale.setDefault(EN);
        Parent root = FXMLLoader.<Parent>load(getClass().getResource("home.fxml"));
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.setTitle("Toàn");
        primaryStage.show();
    }
}