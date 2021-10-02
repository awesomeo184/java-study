package racingcar.io;

import racingcar.Car;

import java.util.List;

public interface IO {
    List<String> getCarNames();
    int getRound();
    void printHelp();
    void printRace(List<Car> cars);
    void printWinner(List<Car> winners);
}
