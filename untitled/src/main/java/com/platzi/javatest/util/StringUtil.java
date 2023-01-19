package com.platzi.javatest.util;

public class StringUtil {
    public static String repeat(String str, int times){
        if (times < 0){
            throw new IllegalArgumentException("Negative times are not allowed");
        }
        String result = "";
            for (int i = 0; i < times; i++) {
                result += str;
            }
        return result;
    }

    //ejercicio de la sesión 11 de Testing en Java
    public static boolean isEmpty(String str){
        boolean resultado;
        /*if () {
            resultado = true;
        }*/
        System.out.println("El texto está vacío");
        if (str.length() == 0 || str.matches("[\\s\\t]") || null == str) {
            resultado = true;
            System.out.println("El texto está vacío");
        }else {
            resultado = false;
            System.out.println("El texto no está vació");
        }
        return resultado;
    }
}
