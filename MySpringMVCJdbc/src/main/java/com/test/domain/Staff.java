package com.test.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Staff {
    private Integer staff_id;
    private String name;
    private Integer age;
    private Integer height;
    private String house;
}
