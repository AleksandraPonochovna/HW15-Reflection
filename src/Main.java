import controller.ConsoleHandler;
import dao.BetDaoImpl;
import dao.DaoInterface;
import dao.HumanDaoImpl;
import lib.Injector;

public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Если хотите сделать ставку, введите: \n" +
                "имя и фамилию, сумму и риск через пробел");
        ConsoleHandler.handle();
        DaoInterface humanDao = new HumanDaoImpl();
        DaoInterface dao = new BetDaoImpl();
        System.out.println(dao.getAll());
        System.out.println(humanDao.getAll());
    }
}




