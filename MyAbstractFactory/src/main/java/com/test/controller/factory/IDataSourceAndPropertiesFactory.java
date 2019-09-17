package com.test.controller.factory;

import com.test.controller.dataSource.IDataSource;
import com.test.controller.propertyFile.IPropertyFile;

public interface IDataSourceAndPropertiesFactory {
    public IDataSource createDataSource();

    public IPropertyFile readPropertyFile();
}
