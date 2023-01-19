package com.platzi.javatest.util;

import org.junit.Test;

import static com.platzi.javatest.util.PasswordUtil.SecurityLevel.*;
import static com.platzi.javatest.util.PasswordUtil.assesPassword;
import static org.junit.Assert.*;

public class PasswordUtilTest {
    @Test
    public void weakWhenHasLessThan8letters() {
        assertEquals(WEAK, assesPassword("123AA!"));
    }

    @Test
    public void weakWhenHasOnlyLetters() {
        assertEquals(WEAK,assesPassword("abcdefgh"));
    }

    @Test
    public void mediumWhenHasLettersAndNumbers(){
        assertEquals(MEDIUM, assesPassword("abcdefgh1"));
    }

    @Test
    public void strongWhenHasLettersNumbersAndSymbols() {
        assertEquals(STRONG,assesPassword("abcdesgh1!"));
    }
}