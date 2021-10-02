package racingcar;

public class Car {
    private final String name;
    private int position = 0;
    private final int MAX_NAME_LENGTH = 5;

    public Car(String name) {
        if (name.length() > MAX_NAME_LENGTH)
            throw Errors.CAR_NAME_LENGTH_ERROR.getError();
        this.name = name;
    }

    public void goForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
