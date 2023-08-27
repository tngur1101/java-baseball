package view;

public class View {

    private static final String ASK_PLAYER_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String BALL_COUNT = "%d볼 ";
    private static final String STIKE_COUNT = "%d스트라이크 ";
    private static final String NOTHING = "낫싱";
    private static final String WIN = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_REPLAY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    //플레이어에게 번호를 요구하는 함수
    public static void askPlayerNumbers(){
        System.out.print(ASK_PLAYER_NUMBERS);
    }

    //Replay할건지 묻는 함수
    public static void askReplay(){
        System.out.println(ASK_REPLAY);
    }

    //이겼음을 알려주는 함수
    public static void alertWin(){
        System.out.println(WIN);
    }

    public static void printStatus(long ballCount, long strikeCount) {
        //ball 개수 출력
        if(ballCount > 0){
            System.out.printf(BALL_COUNT, ballCount);
        }
        //strike 개수 출력
        if(strikeCount > 0){
            System.out.printf(STIKE_COUNT, strikeCount);
        }
        //ball도 없고 strike도 없으면 낫싱 출력
        if(ballCount == 0 && strikeCount == 0){
            System.out.print(NOTHING);
        }
        //모든 것을 출력하면 다음 줄로 넘기기
        System.out.println();
    }
}
