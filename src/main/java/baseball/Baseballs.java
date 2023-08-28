package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Baseballs {

    public static final int BALLS_CONTAINER_SIZE = 3;
    private final List<Integer> balls;
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "중복되는 수는 포함할 수 없습니다.";
    private static final String ZERO_FOUND_ERROR_MESSAGE = "0은 포함할 수 없습니다.";

    public Baseballs(List<Integer> balls){
        this.balls = balls;
    }

    public Baseballs(String rawBallsInput){
        balls = Stream.of(rawBallsInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getBalls(){
        return balls;
    }

    private void validate(String rawBallsInput){
        validateNoZero(rawBallsInput);
        validateNoDuplicate(rawBallsInput);
    }

    private void validateNoZero(String rawBallsInput) {
        if(hasZero(rawBallsInput)){
            throw new IllegalArgumentException(ZERO_FOUND_ERROR_MESSAGE);
        }
    }

    private boolean hasZero(String rawBallsInput) {
        return Stream.of(rawBallsInput.split(""))
                .map(Integer::parseInt)
                .anyMatch(x->x==0);
    }

}
