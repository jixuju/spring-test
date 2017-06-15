package com.superwind.test2shorturl.service;

/**
 * Created by jiangxj on 2017/6/15.
 */
public class ShortURL2 {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_";
    public static final int BASE = ALPHABET.length();

    public static String encode(int num) {
        StringBuilder str = new StringBuilder();
        while (num > 0) {
            str.insert(0, ALPHABET.charAt(num % BASE));
            num = num / BASE;
        }

        int len = str.length();
        for (int i = 1; i <= 6 - len; i++) {
            str.insert(0, ALPHABET.charAt(0));
        }
        return str.toString();
    }

    public static int decode(String str) {
        int id = 0;
        int size = str.length();
        for (int i = 0; i < size; i++) {
            int value = ALPHABET.indexOf(str.charAt(i));
            id += (int) (value * Math.pow(BASE, size - i - 1));
        }

        return id;
    }

    public static void main(String args[]) {

        String shortUrl = encode(1841349913);
        System.out.println("shortUrl : " + shortUrl);
        System.out.println("ID : " + decode(shortUrl));

    }
}
