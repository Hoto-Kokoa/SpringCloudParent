package com.test.controller;


import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;

public class TestMain {

    public void init() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("");
    }

    public void testSelectAllStudent() {

    }
}
