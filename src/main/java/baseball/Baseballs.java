package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Baseballs {

    public static final int BALLS_CONTAINER_SIZE = 3;
    private final List<Integer> balls;

    public Baseballs(List<Integer> balls){
        this.balls = balls;
    }

    public Baseballs(String rawBallsInput){
        balls = Stream.of(rawBallsInput.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public List<Integer> getBalls(){
        return balls;
    }

}
