package com.test.controller.dataSource;

public class DruidDataSourceImpl implements IDataSource {
    public String getConnection () {
        return "druid";
    }
}
