package lib;

import controller.ConsoleHandler;
import dao.BetDaoImpl;
import dao.HumanDaoImpl;
import factory.BetDaoFactory;
import factory.HumanDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<HumanDaoImpl> humanDaoImplClass = HumanDaoImpl.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getName().equals("humanDao") && humanDaoImplClass.getAnnotation(Dao.class) != null) {
                    field.set(null, HumanDaoFactory.getHumanDao());
                }
                if (field.getName().equals("betDao") && betDaoImplClass.getAnnotation(Dao.class) != null) {
                    field.set(null, BetDaoFactory.getBetDao());
                }
            }
        }
    }
}
