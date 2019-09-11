package com.test.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
//    private List<String> list;
    private Map<String,String> map;
}
