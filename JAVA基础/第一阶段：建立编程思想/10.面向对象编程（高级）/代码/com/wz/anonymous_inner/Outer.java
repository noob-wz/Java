package com.wz.anonymous_inner;

public class Outer {
    public void test() {
        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };
    }
}
