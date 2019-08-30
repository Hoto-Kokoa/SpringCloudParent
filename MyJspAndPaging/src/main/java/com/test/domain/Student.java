package com.test.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private String address;
    private String department;
}
