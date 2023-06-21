package factory;

import daopattern.IRepository;
import daopattern.StudentIReponsitory;
import daopattern.SubjectIRepository;
import enums.RepositoryType;

public class RepositoryFactory {
    public static IRepository createRepositoryInstance(RepositoryType type) {
        if (type==RepositoryType.SUBJECT)
            return SubjectIRepository.getInstance();
        else if (type == RepositoryType.STUDENT)
            return StudentIReponsitory.getInstance();
        return null;
    }
}
