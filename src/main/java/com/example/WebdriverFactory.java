package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebdriverFactory implements PooledObjectFactory<WebDriver> {

    private FirefoxOptions firefoxOptions = new FirefoxOptions();

    private WebDriverManager wdm;

    public WebdriverFactory() {
        firefoxOptions.setHeadless(false )
                .setLogLevel(FirefoxDriverLogLevel.ERROR);
        this.wdm = WebDriverManager.firefoxdriver().avoidBrowserDetection().capabilities(firefoxOptions);
    }

    @Override
    public void activateObject(PooledObject<WebDriver> pooledObject) throws Exception {

    }

    @Override
    public void destroyObject(PooledObject<WebDriver> pooledObject) throws Exception {
        WebDriver driver = pooledObject.getObject();
        driver.close();
        System.out.println("release the connection");
    }

    @Override
    public PooledObject<WebDriver> makeObject() throws Exception {
        WebDriver webDriver = wdm.create();
        webDriver.get("https://apply.hdfcbank.com/digital/dsa_journey#dsalogin");
        return new DefaultPooledObject<>(webDriver);
    }

    @Override
    public void passivateObject(PooledObject<WebDriver> pooledObject) throws Exception {

    }

    @Override
    public boolean validateObject(PooledObject<WebDriver> pooledObject) {
        return false;
    }
}