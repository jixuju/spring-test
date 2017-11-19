package com.superwind.test2shorturl.service;

/**
 * Created by jiangxj on 2017/6/15.
 */
public class ShortURL2 {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_";
    public static final int BASE = ALPHABET.length();

    public static String encode(long num) {
        StringBuilder str = new StringBuilder();
        while (num > 0) {
            str.insert(0, ALPHABET.charAt((int)(num % BASE)));
            num = num / BASE;
        }

        int len = str.length();
        for (int i = 1; i <= 6 - len; i++) {
            str.insert(0, ALPHABET.charAt(0));
        }
        return str.toString();
    }

    public static Long decode(String str) {
        Long id = 0L;
        int size = str.length();
        for (int i = 0; i < size; i++) {
            int value = ALPHABET.indexOf(str.charAt(i));
            id += (long) (value * Math.pow(BASE, size - i - 1));
        }

        return id;
    }
}
