package be.lens.syntra.junit.extra;

public class BowlingGame {
    public int turn = 0;
    public int totalPinsDown = 0;
    public boolean strike;
    public boolean spare;
    public int score = 0;
    public boolean gameCanContinue = true;

    public void calculateThrow(int ballthrow, int pinsDown) {
        if(ballthrow == 1){
            turn++;
        }
        totalPinsDown += pinsDown;

        if ((ballthrow == 0) && (totalPinsDown == 10)) {
            strike = true;
            spare = false;
        }
        if ((ballthrow == 1) && (totalPinsDown == 10)) {
            strike = false;
            spare = true;
        }
            score += pinsDown;
        if(turn < 10){
            gameCanContinue = true;
        }else{
            gameCanContinue = false;
        }
    }

    public int getTotalPinsDown() {
        return totalPinsDown;
    }

    public boolean isStrike() {
        return strike;
    }

    public boolean isSpare() {
        return spare;
    }

    public int getScore() {
        return score;
    }

    public int getTurn() {
        return turn;
    }

    public boolean isGameCanContinue() {
        return gameCanContinue;
    }
}
