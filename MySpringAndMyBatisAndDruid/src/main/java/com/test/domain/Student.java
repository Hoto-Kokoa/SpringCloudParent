package com.test.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {
    private String ID;
    private String name;

    public void getString()
    {
        System.out.println("StudentGetString");
    }
}
