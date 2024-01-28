package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // это 2 разных символа
        System.out.println("\u0061\u0300"); // a и  ̀
        System.out.println("\u00E0");       // à

        // он найдет "à" но не найдет "a и  ̀"
        Pattern p1 = Pattern.compile("\u00E0");
        Matcher m1 = p1.matcher("à");
        while (m1.find()){
            System.out.println(m1.start() +" "+ m1.group()+" ");
        }

        //Можно указать какие символы нас интересуют
        Pattern p2 = Pattern.compile("\\p{L}"); // обычная буква
        /*
        Pattern p2 = Pattern.compile("\\p{M}"); // спец символ для букв
        Pattern p2 = Pattern.compile("\\p{Z}"); // любой пробел
        Pattern p2 = Pattern.compile("\\p{N}"); // число (либо вместо N использовать Digit)
        Pattern p2 = Pattern.compile("\\p{P}"); // пунктуация
        Pattern p2 = Pattern.compile("\\p{C}"); // любой невидимый символ
         */
        Matcher m2 = p2.matcher("à 1");
        while (m2.find()){
            System.out.println(m2.start() +" "+ m2.group()+" ");
        }

        // Если символы похоже, то он их найдёт (a и  ̀ = à )
        Pattern p3 = Pattern.compile("\u0061\u0300", Pattern.CANON_EQ);
        Matcher m3 = p3.matcher("\u00E0");
        while (m3.find()){
            System.out.println(m3.start() +" "+ m3.group()+" ");
        }
    }
}
