package com.itheima.test;

import java.util.Random;

public class test2 {
    public static void main(String[] args) {
        code();
    }

    public static void code() {
        String rs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String s = "";
        char[] c = rs.toCharArray();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int a = r.nextInt(c.length);
            s += c[a];
        }
        System.out.println(s);
    }
}
