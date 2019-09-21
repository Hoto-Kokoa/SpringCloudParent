package com.test;

public class MainActivity extends InterfaceAdapter {

    public static void main(String[] args) {
        InterfaceAdapter interfaceAdapter = new InterfaceAdapter() {
            @Override
            public void test1() {
                System.out.println("test1");
            }
        };

        interfaceAdapter.test1();
    }


}
