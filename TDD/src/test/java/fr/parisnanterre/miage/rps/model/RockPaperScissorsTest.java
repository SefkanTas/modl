package fr.parisnanterre.miage.rps.model;

import org.testng.annotations.*;

import static fr.parisnanterre.miage.rps.model.Play.*;
import static org.testng.Assert.*;

public class RockPaperScissorsTest {

    RockPaperScissors rps;

    @BeforeClass
    public void setUp() {
        rps = new RockPaperScissors();
    }

    @AfterClass
    public void tearDown() {
        rps = null;
    }

    @Parameters({"papier", "pierre"})
    @Test
    public void testWinPlay(String p1, String p2){
        assertEquals(rps.play(Play.valueOf(p1),Play.valueOf(p2)), Result.WIN);
    }

    @Parameters({"papier", "papier"})
    @Test
    public void testTiePlay(String p1, String p2){
        assertEquals(rps.play(Play.valueOf(p1),Play.valueOf(p2)), Result.TIE);
    }

    @Parameters({"papier", "ciseaux"})
    @Test
    public void testLostPlay(String p1, String p2){
        assertEquals(rps.play(Play.valueOf(p1),Play.valueOf(p2)), Result.LOST);
    }

    @DataProvider(name = "winData")
    public Object[][] createWinData() {
        return new Object[][] {
                { PAPER, ROCK },
                { ROCK, SCISSORS },
                { SCISSORS, PAPER },
        };
    }

    @DataProvider(name = "tieData")
    public Object[][] createTieData() {
        return new Object[][] {
                { PAPER, PAPER },
                { ROCK, ROCK },
                { SCISSORS, SCISSORS },
        };
    }

    @DataProvider(name = "lostData")
    public Object[][] createLostData() {
        return new Object[][] {
                { ROCK, PAPER },
                { SCISSORS, ROCK },
                { PAPER, SCISSORS },
        };
    }


    @Test(dataProvider = "winData")
    public void testWinPlay(Play p1, Play p2){
        assertEquals(rps.play(p1, p2), Result.WIN);
    }

    @Test(dataProvider = "tieData")
    public void testTiePlay(Play p1, Play p2){
        assertEquals(rps.play(p1, p2), Result.TIE);
    }

    @Test(dataProvider = "lostData")
    public void testLostPlay(Play p1, Play p2){
        assertEquals(rps.play(p1, p2), Result.LOST);
    }
}