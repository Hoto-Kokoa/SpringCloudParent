package com.test;

public abstract class SoyaMilk {

    final void make(){
        select();
        addCondiments();
        soak();
        beat();
    }


    void select() {
        System.out.println("第一步:选黄豆");
    }

    abstract void addCondiments();

    void soak() {
        System.out.println("第三步;浸泡");
    }

    void beat() {
        System.out.println("第四步:捣碎");
    }

}
