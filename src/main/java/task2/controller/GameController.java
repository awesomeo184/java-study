package task2.controller;

import task2.racingcar.Car;

import java.util.*;
import java.util.stream.Collectors;

public class GameController {
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_ROUND_COUNT = 1;

    private List<Car> cars = new ArrayList<>();
    private int round;

    public void run(Scanner scanner) {
        setCars(scanner);
        setRound(scanner);
        printResult();
    }

    private void setCars(Scanner scanner) throws IllegalArgumentException {
        List<String> names;
        String[] input;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        input = scanner.nextLine().split(",");
        names = Arrays.stream(input).map(String::trim).collect(Collectors.toList());
        validateNames(names);
        names.forEach(name -> {
            cars.add(new Car(name));
        });
    }

    private void setRound(Scanner scanner) throws IllegalArgumentException {
        String input;

        System.out.println("시도할 회수는 몇회인가요?");
        input = scanner.nextLine().trim();
        validateRound(input);
        round = Integer.parseInt(input);
    }

    private void printResult() {

    }


    private void validateNames(List<String> names) throws IllegalArgumentException{
        checkOverlappingNames(names);

        for(String name:names) {
            validateName(name);
        }
    }

    private void validateName(String name) {
        if (name.length() < MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 1자 이상이어야 한다.");
        }
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하여야 한다.");
        }
    }

    private void checkOverlappingNames(List<String> names) {
        HashSet<String> set = new HashSet<>(names);
        if (set.size() != names.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 고유해야만 한다.");
        }
    }

    private void validateRound(String round){
        try {
            if (Integer.parseInt(round) < MIN_ROUND_COUNT) {
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 한다.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
    }

}
