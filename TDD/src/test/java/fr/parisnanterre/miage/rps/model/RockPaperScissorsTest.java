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

}