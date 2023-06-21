package hotelprj.databases;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;

public class Connector {

    private final static String connectionString = "jdbc:mysql://localhost:3306/prj_hotel";
    private final  static String user="root";
    private final  static String pwd=""; //xampp: "" mamp: "root"
    private Connection connection;
   private static Connector instance;
    private Connector() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        this.connection = (Connection) DriverManager.getConnection(connectionString,user,pwd);
    }

    public static Connector getInstance() throws Exception {
        if (instance == null) {
            instance = new Connector();

        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
