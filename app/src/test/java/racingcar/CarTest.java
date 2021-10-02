package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
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
}
