package baseball;

import java.util.*;

public class Game {

    //승리하기 위해 필요한 strike의 개수
    private static final long STRIKE_CONDITION_TO_WIN = 3;
    //공의 최고 번호
    private static final int MAX_BALL_VALUE = 9;
    //공의 최소 번호
    private static final int MIN_BALL_VALUE = 1;

    private final Scanner userInput;
    private Baseballs answerBalls;
    private Baseballs guessBalls;
    private MatchStatus gameStatus;

    public Game(Scanner userInput){
        this.userInput = userInput;
    }

    private void initialize(){
        gameStatus = new MatchStatus();
        generateAnswerBalls();
    }

    private void generateAnswerBalls() {
        answerBalls = new Baseballs(createNonDuplicateNumbers(Baseballs.BALLS_CONTAINER_SIZE));
    }

    private List<Integer> createNonDuplicateNumbers(int size) {
        List<Integer> generatedNumbers = new ArrayList<>(createNumberSet(size));
        Collections.shuffle(generatedNumbers);
        return generatedNumbers;
    }

    private Set<Integer> createNumberSet(int ballContainerSize) {
        Set<Integer> generatedNumbers = new HashSet<>();
        while(generatedNumbers.size() != ballContainerSize){
            generatedNumbers.add(new Random().nextInt(MAX_BALL_VALUE - MIN_BALL_VALUE +1));
        }
        return generatedNumbers;
    }


}
