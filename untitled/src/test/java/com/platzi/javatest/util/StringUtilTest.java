package com.platzi.javatest.util;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
    @Test
    public void testRepeatOnce() {
        Assert.assertEquals( "holaholahola", StringUtil.repeat("hola", 3));
        Assert.assertEquals("holahola", StringUtil.repeat("hola", 2));
    }
    @Test
    public void testRepeatMultipleTimes() {
        Assert.assertEquals( "holaholahola", StringUtil.repeat("hola", 3));
        Assert.assertEquals("holahola", StringUtil.repeat("hola", 2));
    }
    @Test
    public void testRepeatZeroTimes () {
        Assert.assertEquals( "holaholahola", StringUtil.repeat("hola", 3));
        Assert.assertEquals("holahola", StringUtil.repeat("hola", 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRepeatNegativeTimes () {
        Assert.assertEquals( "holaholahola", StringUtil.repeat("hola", -1));
        Assert.assertEquals("holahola", StringUtil.repeat("hola", 2));
    }

    //ejercicios de la sesión 11 de Testing en Java
    @Test
    public void testIsEmpty() {
        Assert.assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void testIsEmptyWithSpace() {
        Assert.assertTrue(StringUtil.isEmpty(" "));
    }

    @Test
    public void testIsEmptyWithTabs() {
        Assert.assertTrue(StringUtil.isEmpty("\t"));
    }

    @Test
    public void testIsNotEmpty() {
        Assert.assertFalse(StringUtil.isEmpty("Arabarero"));
    }

    @Test
    public void testIsEmptyWithNull() {
        Assert.assertFalse(StringUtil.isEmpty(null));
    }
}