/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class AppTest {

    @ParameterizedTest
    @DisplayName("입력 값이 공백, 빈 문자열일 경우 예외를 발생시킨다.")
    @ValueSource(strings = {"", " "})
    void no_comma_or_blank_or_null(String input) {
        assertThatThrownBy(
            () -> App.validateCarName(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름은 5자 이하여야 한다.")
    void name_length_should_be_less_then_5() {
        String name = "aaaaaa";
        assertThatThrownBy(
            () -> App.validateCarName(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수는 100을 초과해서는 안된다.")
    void trial_should_be_le_than_100() {
        int trial = 101;
        assertThatThrownBy(
            () -> App.validateTrial(trial)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("콤마로 이름을 구분해 배열을 반환한다.")
    void preprocessNames() {
        // given
        String input = "toby,brown,kenny";

        //when
        String[] names = App.splitNamesBySeparator(input);

        // then
        assertThat(names).containsOnly("toby", "brown", "kenny");
    }

    @Test
    @DisplayName("이름이 하나만 입력되는 경우 예외를 발생시킨다.")
    void throw_exception_when_single_player() {
        String input = "one";

        assertThatThrownBy(
            () -> App.splitNamesBySeparator(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참가자가 10명이 넘는 경우 예외를 발생시킨다.")
    void throw_exception_when_more_than_10_players() {
        String input = "1,2,3,4,5,6,7,8,9,10,11";

        assertThatThrownBy(
            () -> App.splitNamesBySeparator(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
