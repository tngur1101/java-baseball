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

    public void check(Baseballs answerBalls, Baseballs guessBalls){
        ballCount = checkBalls(answerBalls, guessBalls);
        strikeCount = checkStrikes(answerBalls, guessBalls);

    }

    private long checkStrikes(Baseballs answerBalls, Baseballs guessBalls) {
        return guessBalls.getBalls().stream()
                .filter(x->answerBalls.getBalls().contains(x))
                .filter(x->isInSameIndex(x, answerBalls, guessBalls))
                .count();
    }

    private long checkBalls(Baseballs answerBalls, Baseballs guessBalls) {
        return guessBalls.getBalls().stream()
                .filter(x->answerBalls.getBalls().contains(x))
                .filter(x->isInDifferentIndex(x,answerBalls,guessBalls))
                .count();
    }

    private boolean isInSameIndex(int x, Baseballs answerBalls, Baseballs guessBalls){
        return answerBalls.getBalls().indexOf(x)==guessBalls.getBalls().indexOf(x);
    }

    private boolean isInDifferentIndex(int x, Baseballs answerBalls, Baseballs guessBalls){
        return answerBalls.getBalls().indexOf(x)!=guessBalls.getBalls().indexOf(x);
    }
}
