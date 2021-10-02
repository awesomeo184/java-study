package task2;

import task2.controller.GameController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
        gameController.run(scanner);
        // TODO 구현 진행
    }
}
