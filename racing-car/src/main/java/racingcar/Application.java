package racingcar;

import racingcar.io.ConsoleIO;
import racingcar.io.IO;
import utils.RandomUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    final static int RAND_START_NUM = 0;
    final static int RAND_END_NUM = 9;
    final static int MOVE_THRESHOLD = 4;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        new Application().run(scanner);
    }

    public void run(Scanner scanner) {
        IO io = new ConsoleIO(scanner);

        io.printHelp();

        // 올바른 입력을 받을때까지 반복 후 자동차 생성
        List<Car> cars = Collections.emptyList();
        while (cars.isEmpty()) {
            cars = getCars(io);
        }

        // 올바른 입력을 받을때까지 반복 후 라운드 횟수 추출
        Optional<Integer> round = Optional.empty();
        while (round.isEmpty()) {
            round = getRound(io);
        }

        // 라운드마다 자동차별로 레이스
        for (int r = 0; r < round.get(); r++) {
            cars.forEach(this::race);
            io.printRace(cars);
        }

        List<Car> winners = getWinners(cars);
        io.printWinner(winners);
        }

    private List<Car> getCars(IO io) {
        try {
            return io.getCarNames()
                .stream()
                .map(Car::new)
                .toList();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    private Optional<Integer> getRound(IO io) {
        try {
            return Optional.of(io.getRound());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    private void race(Car car) {
        var num = RandomUtils.nextInt(RAND_START_NUM, RAND_END_NUM);
        if (num >= MOVE_THRESHOLD)
            car.goForward();
    }

    private List<Car> getWinners(List<Car> cars) {
        return cars.stream()
            .collect(Collectors.groupingBy(Car::getPosition))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByKey())
            .orElseThrow()
            .getValue();
    }
}
