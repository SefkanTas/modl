package fr.parisnanterre.miage.rps.model;

public class RockPaperScissors {
    public RockPaperScissors(){

    }

    Result play(Play p1, Play p2){
        if(p1 == p2){
            return Result.TIE;
        }
        if(p2 == Play.SCISSORS){
            return Result.LOST;
        }
        return Result.WIN;
    }
}
