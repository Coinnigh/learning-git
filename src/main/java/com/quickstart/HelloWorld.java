package com.quickstart;

import java.util.Random;

public class HelloWorld {

    public static void main(String[] args) {
        final Random rand = new Random();

        char[] arr = {'a','a', 'c', 'z'};

        int alphaNumIdx = rand.nextInt(HelloWorld.ALPHA_NUMS.length);
        char e = HelloWorld.ALPHA_NUMS[alphaNumIdx];
        char[] newArr = insertElement(arr, e);
        System.out.println(String.valueOf(newArr));
    }

    private static char[] insertElement(char[] original, char element) {
        int length = original.length;
        char[] destination = new char[length + 1];
        System.arraycopy(original, 0, destination, 1, length);
        destination[0] = element;
        return destination;
    }

    static final char[] ALPHA_NUMS = new char[]{'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
}
