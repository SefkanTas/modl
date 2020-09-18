package fr.parisnanterre.miage.rps.model;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static fr.parisnanterre.miage.rps.model.Play.*;
import static org.testng.Assert.*;

public class RockPaperScissorsTest {

    RockPaperScissors rps;

    Player player1;
    Player player2;

    @BeforeClass
    public void setUp() {
        rps = new RockPaperScissors();

        //Win, tie, lose for player 1
        List<Play> mouvementsP1 = new ArrayList<>();
        List<Play> mouvementsP2 = new ArrayList<>();

        assignWinTieLoseMoves(mouvementsP1, mouvementsP2);
        player1 = new Player("Poizat", mouvementsP1);
        player2 = new Player("Delboy", mouvementsP2);
    }

    @AfterClass
    public void tearDown() {
        rps = null;
        player1 = null;
        player2 = null;
    }

    private void assignWinTieLoseMoves(List<Play> movesP1, List<Play> movesP2){
        movesP1.add(ROCK);
        movesP1.add(ROCK);
        movesP1.add(ROCK);

        movesP2.add(SCISSORS);
        movesP2.add(ROCK);
        movesP2.add(PAPER);
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

    @Test
    public void testWinPlay(){
        assertEquals(rps.play(player1, player2), Result.WIN);
    }

    @Test
    public void testTiePlay(){
        assertEquals(rps.play(player1, player2), Result.TIE);
    }

    @Test
    public void testLostPlay(){
        assertEquals(rps.play(player1, player2), Result.LOST);
    }




}