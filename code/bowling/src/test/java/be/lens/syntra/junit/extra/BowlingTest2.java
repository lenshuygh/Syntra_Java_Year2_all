package be.lens.syntra.junit.extra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest2 {
    static BowlingGame2 bowlingGame2;

    @BeforeEach
    public final void createClass() {
        bowlingGame2 = new BowlingGame2();
    }

    @Test
    public final void canThrow1score() {
        bowlingGame2.addThrow(5);
        assertEquals(bowlingGame2.getTotalScore(),5);
    }

    @Test
    public final void canThrowAFrame(){
        bowlingGame2.addThrow(4);
        bowlingGame2.addThrow(4);
        assertEquals(bowlingGame2.getTotalScore(),8);
    }

    @Test
    public final void canPlay8Frames() {
        assertEquals(bowlingGame2.isCanThrowNext(),true);
        for (int i = 0; i < 8; i++) {
            bowlingGame2.addThrow(2);
            bowlingGame2.addThrow(6);
        }
        assertEquals(bowlingGame2.isCanThrowNext(),true);
    }

    @Test
    public final void cannotPlay11Frames() {
        assertEquals(bowlingGame2.isCanThrowNext(),true);
        for (int i = 0; i < 11; i++) {
            bowlingGame2.addThrow(2);
            bowlingGame2.addThrow(6);
        }
        assertEquals(bowlingGame2.isCanThrowNext(),false);
    }

    @Test
    public final void canDetectASpare(){
        bowlingGame2.addThrow(4);
        bowlingGame2.addThrow(6);
        assertEquals(bowlingGame2.isSpare(),true);
    }

    @Test
    public final void canDetectAStrike(){
        bowlingGame2.addThrow(10);
        assertEquals(bowlingGame2.isStrike(),true);
    }

    @Test
    public final void aSpareGets1ExtraThrow(){
        bowlingGame2.addThrow(4);
        bowlingGame2.addThrow(6);
        assertEquals(bowlingGame2.getExtraThrowsEarned(),1);
    }

    @Test
    public final void aStrikeGets2ExtraThrows(){
        bowlingGame2.addThrow(10);
        assertEquals(bowlingGame2.getExtraThrowsEarned(),2);
    }

    @Test
    public final void perfectSpareIs20Points(){
        bowlingGame2.addThrow(4);
        bowlingGame2.addThrow(6);
        bowlingGame2.addThrow(10);
        assertEquals(bowlingGame2.getTotalScore(),20);
    }

    @Test
    public final void perfectStrikeIs30Points(){
        bowlingGame2.addThrow(10);
        bowlingGame2.addThrow(10);
        bowlingGame2.addThrow(10);
        assertEquals(bowlingGame2.getTotalScore(),30);
    }

    @Test
    public final void perfectGameIs300Points(){
        for (int i = 0; i < 30; i++) {
            bowlingGame2.addThrow(10);
        }
        assertEquals(bowlingGame2.getTotalScore(),300);
    }
}
