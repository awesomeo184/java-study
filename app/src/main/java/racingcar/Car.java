package racingcar;

import org.checkerframework.checker.nullness.qual.NonNull;

public class Car implements Comparable<Car>{

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int random) {
        if (isAbleToMove(random)) {
            position++;
        }
    }

    private boolean isAbleToMove(int random) {
        return random >= 4 && random <= 9;
    }

    @Override
    public int compareTo(@NonNull Car o) {
        return position - o.position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(Math.max(0, position));
    }

    public String getName() {
        return name;
    }

    public boolean isSamePositionWith(Car max) {
        return position == max.position;
    }
}