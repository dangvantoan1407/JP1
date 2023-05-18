package product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class Controller {


    public TextField txtName;
    public TextArea txtMoTa;
    public TextField txtDanhMuc;
    public TextField txtGia;
    public TextField txtSoLuong;
    public static Product editProduct;
    public static ObservableList<Product> listProduct = FXCollections.observableArrayList();
    public ListView<Product> lvi;

    public void creat(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String price = txtGia.getText();
            String quantity = txtSoLuong.getText();
            String description = txtMoTa.getText();
            String category = txtDanhMuc.getText();
           lvi.setItems(listProduct);
           if(editProduct != null) {
               editProduct.setName(name);
               editProduct.setPrice(price);
               editProduct.setQuantity(quantity);
               editProduct.setDescription(description);
               editProduct.setCategory(category);
               lvi.setItems(listProduct);
               lvi.refresh();
               txtGia.clear();
               txtSoLuong.clear();
               txtDanhMuc.clear();
               txtName.clear();
               txtMoTa.clear();
               editProduct = null;
               return;


           }
            for (Product p : listProduct){
                if (p.getName().equals(name))
                    throw new Exception("Da ton tai");

            }
            Product pr = new Product(name,price,quantity,description,category);
            listProduct.add(pr);

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }


    public void update(ActionEvent actionEvent) {
    }

    public void delete(ActionEvent actionEvent) {
        int selectID = lvi.getSelectionModel().getSelectedIndex();
        lvi.getItems().remove(selectID);
        txtName.clear();
        txtGia.clear();
        txtSoLuong.clear();
        txtMoTa.clear();

    }

    public void editProduct(MouseEvent mouseEvent) {
        editProduct =lvi.getSelectionModel().getSelectedItem();
        if (editProduct != null) {
            txtName.setText(editProduct.getName());
            txtMoTa.setText(editProduct.getDescription());
            txtGia.setText(editProduct.getPrice());
            txtDanhMuc.setText(editProduct.getCategory());
            txtSoLuong.setText(editProduct.getQuantity());
        }

    }
}
