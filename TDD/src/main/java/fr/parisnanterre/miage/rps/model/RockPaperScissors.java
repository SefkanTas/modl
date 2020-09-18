package fr.parisnanterre.miage.rps.model;

public class RockPaperScissors {
    public RockPaperScissors(){

    }

    Result play(Play p1, Play p2){

        if(p1 == p2){
            return Result.TIE;
        }

        if(p1 == Play.ROCK && p2 == Play.SCISSORS){
            return Result.WIN;
        }

        if(p1 == Play.PAPER && p2 == Play.ROCK){
            return Result.WIN;
        }

        if(p1 == Play.SCISSORS && p2 == Play.PAPER){
            return Result.WIN;
        }

        return Result.LOST;

    }

    Result play(Player p1, Player p2){
        return Result.LOST;
    }
}
