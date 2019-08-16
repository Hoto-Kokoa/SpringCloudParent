package com.test.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Getter
@Setter
@ToString
public class InjectionTest {
    private String id;
    private String[] name;
    private List[] list;
    private Set[] set;
    private Map<String, String> map;
    private Properties properties;

}
