package hotelprj.controller;

import com.mysql.jdbc.Connection;
import hotelprj.databases.Connector;
import hotelprj.enums.RepType;
import hotelprj.factory.RepositoryFactory;
import hotelprj.model.Bill;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BillController implements Initializable {

    public TextField search;
    public TableView<Bill> billTable;
    public TableColumn<Bill,Integer> txtID;
    public TableColumn<Bill,String> txtName;
    public TableColumn <Bill,String>txtTel;
    public TableColumn<Bill,String> txtNumber;
    public TableColumn<Bill,String> txtIn;
    public TableColumn <Bill,String>txtOut;
    public TableColumn <Bill,String>txtPrice;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtID.setCellValueFactory(new PropertyValueFactory<>("billID"));
        txtIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        txtOut.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        txtPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        txtNumber.setCellValueFactory(new PropertyValueFactory<>("nameRoom"));
        txtName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        txtTel.setCellValueFactory(new PropertyValueFactory<>("phone"));



        try {
            ObservableList<Bill> list = FXCollections.observableArrayList();
            list.addAll(RepositoryFactory.createRepositoryInstance(RepType.BILLS).getAll());
            billTable.setItems(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


//    public void handleSearchKey(KeyEvent event) {
//        ObservableList<Bill> bills = FXCollections.observableArrayList();
//        bills.addAll();
//        if(event.getEventType() == KeyEvent.KEY_RELEASED) {
//            String s = search.getText();
//            Search(bills,s);
//        }
//    }
//    public void clickBill(MouseEvent event) throws IOException {
//        if (event.getClickCount() == 2) {
//            if (billTable.getSelectionModel().getSelectedItems() !=null) {
//                String path = "C:\\Users\\FPT\\IdeaProjects\\JP1\\src\\res\\";
//                Bill selectedBill = billTable.getSelectionModel().getSelectedItem();
//                File file = new File(path + "bill" + selectedBill.getBillID() + ".pdf");
//                if (file.toString().endsWith(".pdf"))
//                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler \" + file");
//                else {
//                    Desktop desktop = Desktop.getDesktop();
//                    desktop.open(file);
//                }
//            }
//        }
//    }


    public void goToHome(ActionEvent actionEvent) {

    }
}
