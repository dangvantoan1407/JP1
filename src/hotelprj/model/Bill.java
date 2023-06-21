package hotelprj.model;

public class Bill {
    Integer id;
    String nameRoom;
    String price;
    String customerName;
    String cccd;
    String phone;
    String checkIn;
    String checkOut;

    public Bill(Integer id, String nameRoom, String price, String customerName, String cccd, String phone, String checkIn, String checkOut) {
        this.id = id;
        this.nameRoom = nameRoom;
        this.price = price;
        this.customerName = customerName;
        this.cccd = cccd;
        this.phone = phone;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Bill(Integer id, String nameRoom, String price, String nameCustomer, String phone, String checkIn, String checkOut) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
}
