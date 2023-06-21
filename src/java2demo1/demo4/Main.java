package java2demo1.demo4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
//       Thread t1 = new Thread(() ->{
//           for (int i=0; i<20;i++) {
//               System.out.println("t1" + i);
//               try {
//                   Thread.sleep(1000);
//               } catch (Exception e) {
//               }
//           }
//       });
//        Thread t2 = new Thread(() ->{
//            for (int i=0; i<50;i++) {
//                System.out.println("t2" + i);
//                try {
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//                }
//            }
//        });
//        t2.setDaemon(true);
//        t1.start();
//        t2.start();

    }
    public static Stage mainStage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        Parent root = FXMLLoader.<Parent>load(getClass().getResource("hours.fxml"));
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.setTitle("Time");
        primaryStage.show();
    }
}
