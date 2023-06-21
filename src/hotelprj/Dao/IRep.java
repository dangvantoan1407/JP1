package hotelprj.Dao;

import hotelprj.model.Bill;
import javafx.Student;

import java.util.ArrayList;

public interface IRep <B>{
    ArrayList<B> getAll();
    Boolean create(B b);
    Boolean update(B b);
    Boolean delete(B b);
   Bill find(Integer id);
   Bill search(B b);
}
