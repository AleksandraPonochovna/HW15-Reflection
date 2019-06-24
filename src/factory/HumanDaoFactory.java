package factory;

import dao.DaoInterface;
import dao.HumanDaoImpl;

public class HumanDaoFactory {
    private static DaoInterface instance;

    public static DaoInterface getHumanDao() {
        if (instance == null) {
            instance = new HumanDaoImpl();
        }
        return instance;
    }
}
