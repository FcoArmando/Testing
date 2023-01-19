package com.platzi.javatest.ejercicio2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {
    @Test
    public void numberIsDivisibleby3() {
        FizzBuzz texto = new FizzBuzz();

        Assert.assertEquals("Fizz", texto.fizzBuzz(3));
    }

    @Test
    public void numberIsDivisibleby5() {
        FizzBuzz texto = new FizzBuzz();
        Assert.assertEquals("Buzz", texto.fizzBuzz(10));
    }

    @Test
    public void numberDivisibleBy3And5() {
        FizzBuzz texto = new FizzBuzz();
        Assert.assertEquals("FizzBuzz", texto.fizzBuzz(15));
    }

    @Test
    public void numberNotDivisibleBy3Or5() {
        FizzBuzz texto = new FizzBuzz();
        Assert.assertEquals("28", texto.fizzBuzz(28));
    }
}