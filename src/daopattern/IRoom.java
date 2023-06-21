package daopattern;

import javafx.Student;
import javafx2.Classroom;

import java.util.ArrayList;

public interface IRoom <R>{
    ArrayList<R> getAll();
    Boolean create(R r);
    Boolean update(R r);
    Boolean delete(R r);
   Classroom find(Integer id);
}
