package hotelprj.Dao;

import com.mysql.jdbc.Connection;
import daopattern.RoomIRepository;
import hotelprj.databases.Connector;
import hotelprj.model.Bill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BillIReponsitory implements IRep<Bill> {
    private static BillIReponsitory instance;

    private BillIReponsitory() {

    }
    public  static BillIReponsitory getInstance() {
        if(instance == null) {
            instance = new BillIReponsitory();
        }
        return instance;
    }

    @Override
    public ArrayList<Bill> getAll() {
        ArrayList<Bill> bills = new ArrayList<>();
        try{
            Connection connection = Connector.getInstance().getConnection();
              String sql ="select * from bills";
              Statement sqt = connection.createStatement();
              ResultSet rs = sqt.executeQuery(sql);
            while (rs.next()) {
               String nameRoom = rs.getString("nameRoom");
               Integer id = rs.getInt("billId");
               String phone = rs.getString("phone");
               String nameCustomer = rs.getString("customerName");
               String checkIn = rs.getString("checkIn");
               String checkOut = rs.getString("checkOut");
               String price = rs.getString("price");
               Bill b = new Bill(id,nameRoom,price,nameCustomer,phone,checkIn,checkOut);
               bills.add(b);
            }
        }catch (Exception e) {
           // e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return bills;
    }

    @Override
    public Boolean create(Bill bill) {
        return null;
    }

    @Override
    public Boolean update(Bill bill) {
        return null;
    }

    @Override
    public Boolean delete(Bill bill) {
        return null;
    }

    @Override
    public Bill find(Integer id) {
        return null;
    }

    @Override
    public Bill search(Bill bill) {
        return null;
    }

    //  @Override
//    public Bill search(Bill bill) {
//        ArrayList<Bill> bills = new ArrayList<>();
//        bills.clear();
//        for (int i = 0; i< bills.size(); i++) {
//            if(bills.get(i).getDateIn().indexOf(String.valueOf(bills)) == 0) {
//                bills.add(bills.get(i));
//            }
//        }
//        return null;
//    }
}
