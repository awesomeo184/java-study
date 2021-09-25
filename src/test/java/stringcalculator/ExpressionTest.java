package stringcalculator;

import static org.assertj.core.api.Assertions.*;

import java.util.Queue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpressionTest {

    @Test
    @DisplayName("빈 문자열을 전달할 경우 오류를 발생시킨다.")
    void testNotBlank() {
        String input = " ";

        assertThatThrownBy(() -> new Expression(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("빈 값");
    }


    @Test
    @DisplayName("문자열을 연산으로 파싱한다.")
    void testParseExpr() {
        //given
        String input1 = "1 + 2";
        Expression expression1 = new Expression(input1);

        String input2 = "1 + 2 - 3";
        Expression expression2 = new Expression(input2);

        String input3 = "3 * 5 + 1";
        Expression expression3 = new Expression(input3);

        String input4 = "4 / 2 - 1";
        Expression expression4 = new Expression(input4);

        //when
        Queue<String> elements1 = expression1.getElements();
        Queue<String> elements2 = expression2.getElements();
        Queue<String> elements3 = expression3.getElements();
        Queue<String> elements4 = expression4.getElements();

        //then
        assertThat(elements1).containsExactly("1", "+", "2");
        assertThat(elements2).containsExactly("1", "+", "2", "-", "3");
        assertThat(elements3).containsExactly("3", "*", "5", "+", "1");
        assertThat(elements4).containsExactly("4", "/", "2", "-", "1");
    }

    @Test
    @DisplayName("입력 가능한 숫자는 정수여야 한다.")
    void testIllegalExpressionWithNotInteger() {
        String input = "1.3 + 2.5";

        assertThatThrownBy(() -> new Expression(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("식은 숫자로 시작해야한다.")
    void testIllegalExpressionNotStartsWithNumber() {
        String input = "+ 3 - 2";

        assertThatThrownBy(() -> new Expression(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("식은 숫자로 끝나야한다.")
    void testIllegalExpressionNotEndsWithNumber() {
        String input = "3 - 2 +";

        assertThatThrownBy(() -> new Expression(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("연산자와 피연산자는 번갈아 등장해야한다.")
    void testValidOrder() {
        String continuousNumber = "3 3 - 2 +";
        String continuousOperator = "2 + - 3";

        assertThatThrownBy(() -> new Expression(continuousNumber))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Expression(continuousOperator))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
