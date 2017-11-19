package com.superwind.test2shorturl.service;

/**
 * Created by jiangxj on 2017/6/15.
 */
public class ShortURL {
    public static final String ALPHABET = "23456789bcdfghjkmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ-_";
    public static final int BASE = ALPHABET.length();

    public static String encode(long num) {
        StringBuilder str = new StringBuilder();
        while (num > 0) {
            str.insert(0, ALPHABET.charAt((int)(num % BASE)));
            num = num / BASE;
        }
        return str.toString();
    }

    public static Long decode(String str) {
        Long num = 0L;
        for (int i = 0; i < str.length(); i++) {
            num = num * BASE + ALPHABET.indexOf(str.charAt(i));
        }
        return num;
    }
}
