package baseball;

import java.util.Scanner;

public class Game {

    //승리하기 위해 필요한 strike의 개수
    private static final long STRIKE_CONDITION_TO_WIN = 3;
    //공의 최고 번호
    private static final int MAX_BALL_VALUE = 9;
    //공의 최소 번호
    private static final int MIN_BALL_VALUE = 1;

    private final Scanner userInput;

    public Game(Scanner userInput){
        this.userInput = userInput;
    }




}
