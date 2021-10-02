package racingcar;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현


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
}