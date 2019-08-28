package com.test.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ToString
@Getter
@Setter
public class Student {
    private String name = "保登心爱";
    private String sex = "女";
    private int age = 15;
    private String[] friends = {"香风智乃", "理世", "千夜"};
    private List<String> friendsList = Arrays.asList(friends);
}
