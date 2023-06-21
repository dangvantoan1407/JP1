package daopattern;

import javafx.Student;

import java.util.ArrayList;
import java.util.List;

public interface IRepository <S> {
    ArrayList<S> getAll();
    Boolean create(S s);
    Boolean update(S s);
    Boolean delete(S s);
    Student find(Integer id);

}
