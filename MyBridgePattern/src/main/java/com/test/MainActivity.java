package com.test;

public class MainActivity {
    public static void main(String[] args) {
        FoldedPhone foldedPhone = new FoldedPhone(new XiaoMi());
        foldedPhone.open();
        foldedPhone.close();
        foldedPhone.call();


        UpRightPhone upRightPhone = new UpRightPhone(new Vivo());
        upRightPhone.open();
        upRightPhone.close();
        upRightPhone.call();
    }
}
