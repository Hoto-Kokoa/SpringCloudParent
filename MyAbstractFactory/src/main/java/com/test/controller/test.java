package com.test.controller;

import com.test.controller.dataSource.IDataSource;
import com.test.controller.factory.IDataSourceAndPropertiesFactory;
import com.test.controller.factory.MysqlAndC3p0DataSourceImpl;
import com.test.controller.factory.OracleAndDruidDataSourceImpl;
import com.test.controller.propertyFile.IPropertyFile;
import org.junit.jupiter.api.Test;

public class test {


    @Test
    public void testAbstractFactoryMethod() {
        IDataSourceAndPropertiesFactory oracleAndDruidDataSource = new OracleAndDruidDataSourceImpl();
        IDataSource dataSource = oracleAndDruidDataSource.createDataSource();
        String connection = dataSource.getConnection();
        System.out.println(connection);
        IPropertyFile iPropertyFile = oracleAndDruidDataSource.readPropertyFile();
        String s = iPropertyFile.readPropertyFile();
        System.out.println(s);

        IDataSourceAndPropertiesFactory mysqlAndC3p0DataSource = new MysqlAndC3p0DataSourceImpl();
        IDataSource dataSource1 = mysqlAndC3p0DataSource.createDataSource();
        String connection1 = dataSource1.getConnection();
        System.out.println(connection1);
        IPropertyFile iPropertyFile1 = mysqlAndC3p0DataSource.readPropertyFile();
        String s1 = iPropertyFile1.readPropertyFile();
        System.out.println(s1);
    }

}
