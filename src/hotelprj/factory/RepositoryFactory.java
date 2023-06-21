package hotelprj.factory;

import hotelprj.Dao.BillIReponsitory;
import hotelprj.Dao.IRep;
import hotelprj.enums.RepType;

public class RepositoryFactory {
    public static IRep createRepositoryInstance(RepType type ) {
        if (type==RepType.BILLS)
            return BillIReponsitory.getInstance();
        return null;

    }
}
