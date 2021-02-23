package com.cybertek.library.utilities;

public class BrowserUtils {
    //create method name: wait
    //converting milliseconds to seconds
    //handle checked exception

    // why we handle exception by Try and catch? because it will for permanent and do not need to handle it again when we use it

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            System.out.println("something happened in sleep method");

        }
    }
}
