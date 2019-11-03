package be.lens.syntra.junit.extra;

public class BowlingGame2 {
    private int ballNumber = 0;
    private int totalScore = 0;
    private int frameNumber = 0;
    private boolean canThrowNext = true;
    private boolean spare = false;
    private boolean strike = false;
    private int pinsDownInFirstThrow = 0;
    private int extraThrowsEarned = 0;

    public BowlingGame2() {
    }

    public void addThrow(int pinsDown) {
        if (extraThrowsEarned > 0) {
            addToScore(pinsDown);
            extraThrowsEarned--;
        } else {
            if (canThrowNext) {
                addToScore(pinsDown);

                if (ballNumber == 1) {
                    resetThrowNumber();
                    addFrame();
                    checkMaxNumberOfFrames();
                    checkForSpare(pinsDown);
                    if (spare) {
                        addExtraThrows(1);
                    }
                } else {
                    checkForStrike(pinsDown);
                    if (strike) {
                        addExtraThrows(2);
                        resetThrowNumber();
                    }
                    addThrow();
                    pinsDownInFirstThrow = pinsDown;
                }
            }
        }
    }

    private void addExtraThrows(int earnedExtraThrows) {
        extraThrowsEarned += earnedExtraThrows;
    }

    private void checkForStrike(int pinsDown) {
        strike = pinsDown == 10;
    }

    private void checkForSpare(int pinsDown) {
        spare = pinsDownInFirstThrow + pinsDown == 10;
    }

    private void addToScore(int pinsDown) {
        totalScore += pinsDown;
    }

    private void addThrow() {
        ballNumber++;
    }

    private void checkMaxNumberOfFrames() {
        canThrowNext = frameNumber < 9;
    }

    private void addFrame() {
        frameNumber++;
    }

    private void resetThrowNumber() {
        ballNumber = 0;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public boolean isCanThrowNext() {
        return canThrowNext;
    }

    public boolean isSpare() {
        return spare;
    }

    public boolean isStrike() {
        return strike;
    }

    public int getExtraThrowsEarned() {
        return extraThrowsEarned;
    }
}
