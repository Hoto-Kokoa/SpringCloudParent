package com.test;

public class UpRightPhone extends Phone {

    public UpRightPhone(Brand brand) {
        super(brand);
    }

    @Override
    protected void open() {
        System.out.println("翻盖手机");
        super.open();
    }

    @Override
    protected void close() {
        System.out.println("翻盖手机");
        super.close();
    }

    @Override
    protected void call() {
        System.out.println("翻盖手机");
        super.call();
    }
}
