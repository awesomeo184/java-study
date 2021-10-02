import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import task2.controller.GameController;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class GameControllerTest {
    private static GameController gameController;

    @BeforeAll
    static void initAll() {
        gameController = new GameController();
    }


    @Test
    @DisplayName("빈 문자열을 입력했을 경우 에러를 발생시킨다.")
    void testBlankInput() {
        String input = " ";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        assertThatThrownBy(() -> gameController.run(scanner))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차의 이름은 1자 이상이어야 한다.");
    }

    @Test
    @DisplayName("자동차의 이름이 누락된 경우 에러를 발생시킨다.")
    void testNameOmitted() {
        String input = ",,,asd,,";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        assertThatThrownBy(() -> gameController.run(scanner))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차의 이름은 1자 이상이어야 한다.");
    }

    @Test
    @DisplayName("자동차의 이름이 중복될 경우 에러를 발생시킨다.")
    void testOverrapingNames() {
        String input = "car,car,car";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        assertThatThrownBy(() -> gameController.run(scanner))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차의 이름은 고유해야만 한다.");
    }

    @Test
    @DisplayName("5자를 초과하는 자동차의 이름이 입력된 경우 에러를 발생시킨다.")
    void testOverLengthName() {
        String input = "car1234,carA,carB";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        assertThatThrownBy(() -> gameController.run(scanner))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차의 이름은 5자 이하여야 한다.");
    }

    @Test
    @DisplayName("시도할 회수로 문자가 입력된 경우 에러를 발생시킨다.")
    void testStringRound() {
        Scanner input = new Scanner(
                "현대,기아,페라리\n" +
                "add\n");

        assertThatThrownBy(() -> gameController.run(input)).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 시도 횟수는 숫자여야 한다.");
    }

    @Test
    @DisplayName("시도할 회수로 1 이하가 입력된 경우 에러를 발생시킨다.")
    void testNotPositiveIntRound() {
        Scanner input = new Scanner(
                "현대,기아,페라리\n" + "0\n");

        assertThatThrownBy(() -> gameController.run(input)).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 시도 횟수는 1 이상이어야 한다.");
    }

    @Test
    @DisplayName("정상적인 입력1")
    void testAppRunning1() {
        Scanner input = new Scanner(
                "pobi,woni,jun\n" + "5\n");
        gameController.run(input);
    }

    @Test
    @DisplayName("정상적인 입력2")
    void testAppRunning2() {
        Scanner input = new Scanner(
                "현대,기아,페라리\n" + "5\n");
        gameController.run(input);
    }
}
