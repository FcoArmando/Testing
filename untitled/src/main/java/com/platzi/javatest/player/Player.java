package com.platzi.javatest.player;

public class Player {
    private Dice dice;

    public Player(Dice dice, int minNumberWin) {
        this.dice = dice;
        this.minNumberWin = minNumberWin;
    }

    private int minNumberWin;
    public boolean play(){
        int diceNumber = dice.roll();
        return diceNumber > minNumberWin;
    }
}
