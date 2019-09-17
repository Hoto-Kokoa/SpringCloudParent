package com.test.controller.factory;

import com.test.controller.dataSource.DruidDataSourceImpl;
import com.test.controller.dataSource.IDataSource;
import com.test.controller.propertyFile.IPropertyFile;
import com.test.controller.propertyFile.OraclePropertyFileImpl;

public class OracleAndDruidDataSourceImpl implements IDataSourceAndPropertiesFactory {
    public IDataSource createDataSource () {
        return new DruidDataSourceImpl();
    }

    public IPropertyFile readPropertyFile () {
        return new OraclePropertyFileImpl();
    }
}
