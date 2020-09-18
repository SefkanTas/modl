package fr.parisnanterre.miage.rps.model;

import java.util.List;

public class Player {

    private String nom;
    private int score;
    private List<Play> mouvements;

    private int currentMouvIndex;

    public Player(String nom) {
        this.nom = nom;
        this.mouvements = PlayGenerator.generatePlays(10);
        currentMouvIndex = 0;
    }

    public Player(String nom, List<Play> mouvements) {
        this(nom);
        this.mouvements = mouvements;
    }

    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public int getNbMouvements() {
        return mouvements.size();
    }

    public Play getNextMove(){
        currentMouvIndex++;
        // if(currentMouvIndex-1 > getNbMouvements()){
            // TODO: 18/09/2020 throw exception
        //}
        return mouvements.get(currentMouvIndex-1);
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void resetMoveIndexAndScore(){
        setScore(0);
        currentMouvIndex = 0;
    }

}
