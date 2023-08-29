package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class Application {
    public static void main(String [] args) {
        // TODO: 프로그램 구현
//        final String scanner = Console.readLine();
//        Player player = new Player();
        Game game = new Game();

//        do{
//            game.play();
//            checkReplayDecisionOfPlayer(player);
//        }while (player.getReplayDecision()==Player.WANT_REPLAY);
        game.play();

    }

    private static void checkReplayDecisionOfPlayer(Player player){
//        try {
//            player.checkReplayDecision();
//        }catch (IllegalArgumentException e){
//            System.out.println(e.getMessage());
//            checkReplayDecisionOfPlayer(player);
//        }
        player.checkReplayDecision();
    }

}
