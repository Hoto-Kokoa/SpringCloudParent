package com.test.controller.factory;

import com.test.controller.dataSource.C3p0DataSourceImpl;
import com.test.controller.dataSource.IDataSource;
import com.test.controller.propertyFile.IPropertyFile;
import com.test.controller.propertyFile.MysqlPropertyFileImpl;

public class MysqlAndC3p0DataSourceImpl implements IDataSourceAndPropertiesFactory {
    public IDataSource createDataSource () {
        return new C3p0DataSourceImpl();
    }

    public IPropertyFile readPropertyFile () {
        return new MysqlPropertyFileImpl();
    }
}
