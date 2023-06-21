package javafx2;
import javafx.scene.control.Button;

public class Classroom {
    private Integer id;
    private String name;
    private String room;
    private Button edit;


    public Classroom(Integer id, String name, String room) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.edit = new Button("Edit");
    }

    public Classroom(String name, String room) {
        this.name = name;
        this.room = room;
    }

    public Button getEdit() {
        return edit;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

}
