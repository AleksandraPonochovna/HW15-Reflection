package controller;

import dao.DaoInterface;
import lib.Inject;
import model.Bet;
import model.Human;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static DaoInterface<Human> humanDao;
    @Inject
    private static DaoInterface<Bet> betDao;

    static public void handle() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }
                String[] data = command.split(" ");
                Human human = new Human(data[0], data[1]);
                int value = Integer.parseInt(data[2]);
                double risk = Double.parseDouble(data[3]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
                humanDao.add(human);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Данные введены некорректно");
        }
    }
}

