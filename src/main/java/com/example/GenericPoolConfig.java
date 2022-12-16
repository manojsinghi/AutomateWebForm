package com.example;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.openqa.selenium.WebDriver;

public class GenericPoolConfig extends GenericObjectPoolConfig<WebDriver> {
    public GenericPoolConfig() {
        super();
        super.setMinIdle(2);
    }

    @Override
    public void setMinIdle(int minIdle) {
        super.setMinIdle(minIdle);
    }
}


