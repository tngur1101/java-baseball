package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import view.View;

import java.util.*;

public class Game {

    //승리하기 위해 필요한 strike의 개수
    private static final long STRIKE_CONDITION_TO_WIN = 3;
    //공의 최고 번호
    private static final int MAX_BALL_VALUE = 9;
    //공의 최소 번호
    private static final int MIN_BALL_VALUE = 1;

    private String userInput;
    private Baseballs answerBalls;
    private Baseballs guessBalls;
    private MatchStatus gameStatus;



    public Game(){
    }

    public void setGame(){
        this.userInput = Console.readLine();
    }

    public void play(){
        View.startGame();
        initialize();
        while(gameStatus.getStrikeCount() != STRIKE_CONDITION_TO_WIN){
            proceedGame();
        }
        View.alertWin();
        String a = Console.readLine();
        int num = Integer.parseInt(a);
        if(num==1){
            play();
        }
    }

    private void proceedGame() {
//        System.out.println(answerBalls);
        setGame();
        generateGuessingBalls();
//        System.out.println(guessBalls);
        gameStatus.check(answerBalls, guessBalls);
        View.printStatus(gameStatus.getBallCount(), gameStatus.getStrikeCount());
    }

    private void initialize(){
        gameStatus = new MatchStatus();
        generateAnswerBalls();
    }

    private void generateAnswerBalls() {
        answerBalls = new Baseballs(createNonDuplicateNumbers(Baseballs.BALLS_CONTAINER_SIZE));
    }

    private List<Integer> createNonDuplicateNumbers(int size) {
        List<Integer> generatedNumbers = new ArrayList<>();
        while (generatedNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
            }
        }
        return generatedNumbers;
    }

    private void generateGuessingBalls(){
//        View.askPlayerNumbers();
        guessBalls = new Baseballs(userInput);

    }

}
