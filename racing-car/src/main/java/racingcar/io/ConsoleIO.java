package racingcar.io;

import racingcar.Car;
import racingcar.Errors;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleIO implements IO {
    private final Scanner scanner;

    public ConsoleIO(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> getCarNames() {
        var DELIMITER = ",";
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        var userInput = scanner.nextLine();

        if (userInput.contains(" "))
            throw Errors.EMPTY_SPACE_ERROR.getError();

        if (userInput.isBlank())
            throw Errors.MIN_RACE_CAR_ERROR.getError();

        return Arrays.stream(userInput.split(DELIMITER)).toList();
    }

    public int getRound() throws NumberFormatException{
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(scanner.nextLine());
    }


    public void printHelp() {
        System.out.println(
            """
                          자동차 경주 게임!!!
            ===========================================
            주어진 횟수 동안 랜덤하게 자동차를 움직이거나 멈춥니다      
            """
        );
    }

    public void printRace(List<Car> cars) {
        cars.forEach(this::printCar);
        System.out.println();
    }

    private void printCar(Car car) {
        System.out.print(car.getName() + ": ");
        System.out.println(new String(new char[car.getPosition()]).replace("\0", "-"));
    }

    public void printWinner(List<Car> winners) {
        System.out.print("최종 우승자: ");
        winners.forEach(System.out::print);
        System.out.println();
    }
}
