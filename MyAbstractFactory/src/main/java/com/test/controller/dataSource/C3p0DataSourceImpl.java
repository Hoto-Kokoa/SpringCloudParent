package com.test.controller.dataSource;

public class C3p0DataSourceImpl implements IDataSource {
    public String getConnection () {
        return "c3p0";
    }
}