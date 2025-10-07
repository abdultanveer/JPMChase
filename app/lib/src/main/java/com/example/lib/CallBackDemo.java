package com.example.lib;

public class CallBackDemo {
    public static void main(String[] args) {
        System.out.println("hello");
        Addition addition = new Addition();
        int c = addition.jeevanAdd(10,20);
        System.out.println("jeevans result = "+c);
        System.out.println("aritra to add 30,40");

        MySelf myphno = new MySelf();
        new Thread(){
            @Override
            public void run() {
                super.run();
                addition.aritraAdd(30,40,myphno);
            }
        }.start();
        System.out.println("abdul can continue with the class while aritra is adding");
    }
}