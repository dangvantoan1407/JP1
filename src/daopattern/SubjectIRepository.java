package daopattern;

import javafx.Student;
import javafx.Subject;

import java.util.ArrayList;

public class SubjectIRepository implements IRepository<Subject> {
    private static SubjectIRepository instance;
    private SubjectIRepository() {

    }
    public static SubjectIRepository getInstance() {
        if (instance == null)
            instance = new SubjectIRepository();
        return instance;
    }
    @Override
    public ArrayList<Subject> getAll() {
        return null;
    }

    @Override
    public Boolean create(Subject subject) {
        return null;
    }

    @Override
    public Boolean update(Subject subject) {
        return null;
    }

    @Override
    public Boolean delete(Subject subject) {
        return null;
    }

    @Override
    public Student find(Integer id) {
        return null;
    }
}
