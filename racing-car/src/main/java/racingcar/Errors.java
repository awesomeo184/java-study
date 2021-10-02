package racingcar;

public enum Errors {
    EMPTY_SPACE_ERROR {
        @Override
        public IllegalArgumentException getError() {
            return new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다");
        }
    },
    MIN_RACE_CAR_ERROR {
        @Override
        public IllegalArgumentException getError() {
            return new IllegalArgumentException("[ERROR] 최소 1대의 자동차를 입력해야합니다");
        }
    },
    CAR_NAME_LENGTH_ERROR {
        @Override
        public IllegalArgumentException getError() {
            return new IllegalArgumentException("[ERROR] 이름은 5자 이하여야 합니다");
        }
    };

    public abstract IllegalArgumentException getError();
}
