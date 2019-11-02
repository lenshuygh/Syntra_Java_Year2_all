package be.lens.syntra.junit.extra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {
    BowlingGame bowlingGame;

    @BeforeEach
    public void prepareBowlingGame() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void canPlay5Turns() {
        for (int i = 0; i < 5; i++) {
            bowlingGame.calculateThrow( 0);
            bowlingGame.calculateThrow( 0);
        }
        assertEquals(bowlingGame.isGameCanContinue(),true);
    }

    @Test
    public void stopsAfter10Turns(){
        for (int i = 0; i < 11; i++) {
            bowlingGame.calculateThrow( 0);
            bowlingGame.calculateThrow( 0);
        }
        assertEquals(bowlingGame.isGameCanContinue(),false);
    }

    @Test
    public final void ThrowDown10PinsInTurnOne() {
        bowlingGame.calculateThrow( 10);
        assertEquals(bowlingGame.isStrike(), true);
        assertEquals(bowlingGame.isSpare(), false);
    }

    @Test
    public final void ThrowDown10PinsInTwoThrows() {
        bowlingGame.calculateThrow( 5);
        bowlingGame.calculateThrow( 5);
        assertEquals(bowlingGame.isSpare(), true);
        assertEquals(bowlingGame.isStrike(), false);
    }

    @Test
    public final void ThrowDownOnePinsIsOnePoint() {
        bowlingGame.calculateThrow( 1);
        assertEquals(bowlingGame.getScore(), 1);
    }

    @Test
    public final void ThrowDownTwoPinsIsTwoPoints() {
        bowlingGame.calculateThrow( 1);
        bowlingGame.calculateThrow( 1);
        assertEquals(bowlingGame.getScore(), 2);
    }

    @Test
    public final void ThrowDownTwoPinsIsTwoPointsInOneThrow() {
        bowlingGame.calculateThrow(2);
        assertEquals(bowlingGame.getScore(), 2);
    }

    @Test
    public final void aStrikeResultsIn10Points(){
        bowlingGame.calculateThrow(10);
        assertEquals(bowlingGame.getScore(),10);
    }

    @Test
    public final void afterAStrikePlayerGets2ThrowsAfterStrikeWith10Points(){
        bowlingGame.calculateThrow(10);
        assertEquals(bowlingGame.getScore(),10);
        assertEquals(bowlingGame.getTurn(),0);
        bowlingGame.calculateThrow(5);
        assertEquals(bowlingGame.getScore(),15);
        assertEquals(bowlingGame.getTurn(),0);
        bowlingGame.calculateThrow(5);
        assertEquals(bowlingGame.getScore(),20);
        assertEquals(bowlingGame.getTurn(),1);
    }

    @Test
    public final void afterTurn10ASpareGetsAnExtraTurn(){
        bowlingGame.setTurn(10);
        bowlingGame.calculateThrow(5);
        bowlingGame.calculateThrow(5);
        assertEquals(bowlingGame.isGameCanContinue(),false);
    }

    @Test
    public final void afterTurn10AStrikeGets2ExtraThrows(){
        bowlingGame.setTurn(10);
        bowlingGame.calculateThrow(10);
        assertEquals(bowlingGame.isGameCanContinue(),true);
        bowlingGame.calculateThrow(5);
        assertEquals(bowlingGame.isGameCanContinue(),true);
        bowlingGame.calculateThrow(5);
        assertEquals(bowlingGame.isGameCanContinue(),false);
    }
}
