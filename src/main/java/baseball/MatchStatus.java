package baseball;

public class MatchStatus {

    private long strikeCount;
    private long ballCount;

    //처음에 strike와 ball 개수를 모두 0으로 초기화
    public MatchStatus(){
        strikeCount = 0;
        ballCount = 0;
    }

    public long getStrikeCount(){
        return strikeCount;
    }

    public long getBallCount(){
        return ballCount;
    }

    public void check(int x, Baseballs answerBalls, Baseballs guessBalls){
        ballCount = checkBalls(x, answerBalls, guessBalls);
        strikeCount = checkStrikes(x, answerBalls, guessBalls);

    }

    private long checkStrikes(int x, Baseballs answerBalls, Baseballs guessBalls) {
        if(guessBalls.getBalls().indexOf(x)==answerBalls.getBalls().indexOf(x)){
            return guessBalls.getBalls().stream().filter(m->answerBalls.getBalls().contains(m)).count();
        }
        return 0;
    }

    private long checkBalls(int x, Baseballs answerBalls, Baseballs guessBalls) {
        if(guessBalls.getBalls().indexOf(x)!=answerBalls.getBalls().indexOf(x)){
            return guessBalls.getBalls().stream().filter(m->answerBalls.getBalls().contains(m)).count();
        }
        return 0;
    }

}
