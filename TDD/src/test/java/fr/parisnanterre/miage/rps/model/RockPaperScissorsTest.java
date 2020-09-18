package fr.parisnanterre.miage.rps.model;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static fr.parisnanterre.miage.rps.model.Play.*;
import static org.testng.Assert.*;

public class RockPaperScissorsTest {

    RockPaperScissors rps;

    Player playerWIN;
    Player playerLOSE;

    @BeforeClass
    public void setUp() {
        rps = new RockPaperScissors();

        //Win, tie, lose for player 1
        List<Play> mouvementsWin = new ArrayList<>();
        List<Play> mouvementsLose = new ArrayList<>();

        assignWinningLoosingMoves(mouvementsWin, mouvementsLose);
        playerWIN = new Player("Poizat", mouvementsWin);
        playerLOSE = new Player("Delboy", mouvementsLose);
    }

    @AfterClass
    public void tearDown() {
        rps = null;
        playerWIN = null;
        playerLOSE = null;
    }

    private void assignWinningLoosingMoves(List<Play> movesWin, List<Play> movesLose){
        movesWin.add(ROCK);
        movesWin.add(PAPER);
        movesWin.add(SCISSORS);

        movesLose.add(SCISSORS);
        movesLose.add(ROCK);
        movesLose.add(PAPER);
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
        assertEquals(rps.play(playerWIN, playerLOSE), Result.TIE);
    }

    @Test
    public void testTiePlay(){
        playerWIN.resetMoveIndexAndScore();
        playerLOSE.resetMoveIndexAndScore();
        assertEquals(rps.play(playerWIN, playerWIN), Result.TIE);
    }

    @Test
    public void testLostPlay(){
        assertEquals(rps.play(playerWIN, playerLOSE), Result.TIE);
    }


}