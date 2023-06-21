package daopattern;

import database.Connector;
import javafx2.Classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RoomIRepository implements IRoom<Classroom>{
    private static RoomIRepository instance;

    private RoomIRepository() {

    }
    public  static RoomIRepository getInstance() {
        if(instance == null) {
            instance = new RoomIRepository();
        }
        return instance;
    }
    @Override
    public ArrayList<Classroom> getAll() {
        ArrayList<Classroom> classrooms = new ArrayList<>();
        try{
            Connection conn = Connector.getInstance().getConn();

            //Query
            Statement stt = conn.createStatement();
            String sql1 = "select * from classrooms";
            ResultSet rs = stt.executeQuery(sql1);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String room = rs.getString("room");
                Classroom clr = new Classroom(id,name,room);
                classrooms.add(clr);
                System.out.println("1");

            }

        } catch (Exception e){

        }
        return classrooms;
    }

    @Override
    public Boolean create(Classroom classroom) {
        try {
            Connection conn = Connector.getInstance().getConn();
            //Query
            String sql1 = "insert into classrooms(id, name, room) values(?,?,?)";
            PreparedStatement stt = conn.prepareStatement(sql1);
            ResultSet rs = stt.executeQuery(sql1);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String room = rs.getString("room");
                Classroom clr = new Classroom(id, name, room);

                return true;

            }

        } catch (Exception e){

        }
        return false;
    }

    @Override
    public Boolean update(Classroom classroom) {
        return null;
    }

    @Override
    public Boolean delete(Classroom classroom) {
        return null;
    }


    public Classroom find(Integer id) {
        return null;
    }
}
