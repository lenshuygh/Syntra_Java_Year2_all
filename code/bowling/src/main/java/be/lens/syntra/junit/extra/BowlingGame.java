package be.lens.syntra.junit.extra;

public class BowlingGame {
    public int turn = 0;
    public int totalPinsDown = 0;
    public boolean strike;
    public boolean spare;
    public int score = 0;
    public boolean gameCanContinue = true;
    public int ballNumber = 0;

    public void calculateThrow(int pinsDown) {

        totalPinsDown += pinsDown;
        spare= false;
        strike = false;
        if ((ballNumber == 0) && (totalPinsDown == 10)) {
            strike = true;
            spare = false;
        }
        if ((ballNumber == 1) && (totalPinsDown == 10)) {
            strike = false;
            spare = true;
        }
        score += pinsDown;
        if (turn < 10) {
            gameCanContinue = true;
        } else {
            gameCanContinue = false;
        }
        if (ballNumber == 1) {
            if(!isSpare()){
                turn++;
                ballNumber = 0;
            }
        } else {
            if(isStrike()) {
                ballNumber = 0;
            }else{
                ballNumber = 1;
            }
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

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public boolean isGameCanContinue() {
        return gameCanContinue;
    }
}
