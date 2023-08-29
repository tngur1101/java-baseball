package baseball;

import camp.nextstep.edu.missionutils.Console;
import view.View;

import java.util.Scanner;

public class Player {

    // 게임을 다시 진행하고 싶다면 1번, 게임을 종료하고 싶다면 2번
    //만약 1번과 2번이 아니라면 "올바른 선택지가 아닙니다";출력
    public static final int WANT_REPLAY = 1;
    public static final int WANT_FINISH = 2;
    public static final String CHOICE_ERROR_MESSAGE = "올바른 선택지가 아닙니다.";

    //다시 시작할 번호 받는 변수
    private int replayDecision;

    //Scanner로 받기
    private String playerInput;

    //생성자
    public Player(){

    }

    public void setPlayer(){
        this.playerInput = Console.readLine();
    }

    //GETTER
    public int getReplayDecision(){
        return replayDecision;
    }

    public void checkReplayDecision(){
        //View에 이제 어떤 함수가 있어야할듯
        View.askReplay();
        String input = playerInput;
        replayDecision = checkDecision(input);
    }

    //사용자의 결정을 확인하는 함수
    public int checkDecision(String input){
        try{
            return checkValidInteger(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(CHOICE_ERROR_MESSAGE);
        }
    }

    //유효한 숫자인지 확인해주는 함수
    private int checkValidInteger(String input){
        //입력받고
        int choice = Integer.parseInt(input);
        //만약 1번과 2번이 아니라면
        if(isNotValidOption(choice)){
            //에러를 띄워준다.
            throw new IllegalArgumentException(CHOICE_ERROR_MESSAGE);
        }
        return choice;
    }

    //리플레이 혹은 끝내기(1번 || 2번)인지 확인하는 함수
    private boolean isNotValidOption(int choice){
        return choice != WANT_REPLAY && choice != WANT_FINISH;
    }

}
