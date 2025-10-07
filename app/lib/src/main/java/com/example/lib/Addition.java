package com.example.lib;

public class Addition {
    public int jeevanAdd(int a, int b){
        return  a+b;
    }

    public void aritraAdd(int a, int b,MobilePhone phno){
        try {
            Thread.sleep(10000);
          phno.onAddition(a+b);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
