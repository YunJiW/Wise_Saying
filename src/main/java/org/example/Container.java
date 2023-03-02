package org.example;

import java.util.Scanner;

public class Container {
    private static Scanner sc;

    /* static 전용
    static{
        init();
    }
     */
    public static void init(){
        sc = new Scanner(System.in);
    }
    public static void close(){
        sc.close();
    }
    public static Scanner getScanner(){
        return sc;
    }

}
