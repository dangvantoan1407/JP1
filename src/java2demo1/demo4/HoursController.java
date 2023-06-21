package java2demo1.demo4;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class HoursController implements Initializable {

    public Text txtMin;
    public Text txtSec;
    private Integer x = 30;
    private Integer y = 0;
    boolean flag = true;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Thread(()->{
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

        });

    }
    public void start(ActionEvent actionEvent) {
        new Thread(()->{
            flag = true;
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

    public synchronized void pause(ActionEvent actionEvent) throws Exception{
//        try {
//            wait();
//        }catch (Exception e){}
       flag = false;

    }

    public void stop(ActionEvent actionEvent) {
        flag = false;
        x = 30;
        y=0;
        txtMin.setText("30");
        txtSec.setText("00");

    }


}
