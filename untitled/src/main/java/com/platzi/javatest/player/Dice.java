package com.platzi.javatest.player;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.Random;

public class Dice {
    public Dice(int sides) {
        this.sides = sides;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    private int sides;
    public int roll(){
        return new Random().nextInt(sides + 1);
    }
}
