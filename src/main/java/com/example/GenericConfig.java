package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class GenericConfig {


    GenericPool genericPool;

    public GenericConfig(@Autowired config configs) throws Exception {
        genericPool= configs.generate();
        System.out.println(genericPool.getMinIdle());
        genericPool.preparePool();
    }


    public void setUp() throws Exception {
        System.out.println("-----This is the beginning of our test !!!-----");
//        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        System.setProperty("webdriver.firefox.whitelistedIps", "175.100.163.64");


        WebDriver driver = genericPool.borrowObject(10000);


        driver.findElement(By.cssSelector("#missing_19126 > div > div > div > input")).clear();
        driver.findElement(By.cssSelector("#missing_19126 > div > div > div > input")).sendKeys("Vistas");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        List<WebElement> suggestions = driver.findElements(By.xpath("//div[@class='Select-menu']//div//div"));

        System.out.println(suggestions.size());
        for(WebElement ele: suggestions){
            if(ele.getText().equals("Vistas Technolabs Pvt Ltd")){
                ele.click();
                break;
            }

        }

        WebElement custMob = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/input"));
//        custMob.clear();
        custMob.sendKeys("8602740050");

        WebElement DSE = driver.findElement(By.xpath("//*[@id=\"txtmissing_28234\"]"));
        DSE.clear();
        DSE.click();
        DSE.sendKeys("VTL001");

        WebElement SMcode = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[2]/div/div/input"));
        SMcode.clear();
        SMcode.click();
        SMcode.sendKeys("S54725");

        WebElement newEl = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/input"));
        newEl.click();

        WebElement sgnUp = driver.findElement(By.xpath("//*[@id=\"missing_26\"]"));
        TimeUnit.SECONDS.sleep(1);
        sgnUp.click();

//        Thread thread = new Thread();
//        thread.sleep(2000);

        WebElement refer = driver.findElement(By.cssSelector("#missing_345688234"));

        String referText;
        if(refer.getText().equals(null)||refer.getText().equalsIgnoreCase("")){
            referText =null;
        }
        else {
            referText = refer.getText();
        }
        WebElement ErrorNotify = driver.findElement(By.xpath("//*[@id=\"missing_101\"]/div[1]"));

//        System.out.println(driver.getPageSource());
        System.out.println(referText);

        driver.navigate().refresh();
        genericPool.returnObject(driver);
//        genericPool.clear();
    }


}
