package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7 , 8, 9})
    @DisplayName("4이상 9이하의 값이 들어오는 경우 한 칸 이동한다.")
    void can_move(int random) {
        // given
        Car car = new Car("toby");

        // when
        int initPosition = car.getPosition();
        car.move(random);
        int afterMovePosition = car.getPosition();

        //then
        assertThat(initPosition).isEqualTo(0);
        assertThat(afterMovePosition).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3 , 10, 11})
    @DisplayName("4이상 9이하의 값 외에는 움직이지 않는다.")
    void dont_move(int random) {
        // given
        Car car = new Car("toby");

        // when
        int initPosition = car.getPosition();
        car.move(random);
        int afterMovePosition = car.getPosition();

        // then
        assertThat(initPosition).isEqualTo(0);
        assertThat(afterMovePosition).isEqualTo(0);
    }

    @Test
    @DisplayName("대소 비교가 잘 되는지")
    void test_comparison() {
        // given
        Car test1 = new Car("test1");
        Car test2 = new Car("test2");
        Car test3 = new Car("test3");

        // when
        for (int i = 0; i < 4; i++) {
            test1.move(5);
        }
        for (int i = 0; i < 3; i++) {
            test2.move(5);
        }
        for (int i = 0; i < 2; i++) {
            test3.move(5);
        }

        List<Car> reverseOrder = new ArrayList<>();
        reverseOrder.add(test1);
        reverseOrder.add(test2);
        reverseOrder.add(test3);

        Collections.sort(reverseOrder);

        // then
        assertThat(reverseOrder).containsExactly(test3, test2, test1);
    }
}
