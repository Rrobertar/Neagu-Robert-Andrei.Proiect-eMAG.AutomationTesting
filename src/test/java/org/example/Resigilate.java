package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


import static org.junit.Assert.*;

public class Resigilate {
    private static final Logger log = LoggerFactory.getLogger(eMAG.class);
    WebDriver driver;

    //Wait

    public static void asteapta(int n) {

        try {

            Thread.sleep(n * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @Test

    public void souldbeanswerWithTrue() {

        driver.get("https://www.emag.ro/");

        WebElement acceptCookie6 = driver.findElement(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.show > div > div.col-xs-12.col-sm-5.col-md-4.col-lg-3.cookie-banner-buttons > button.btn.btn-primary.btn-block.js-accept.gtm_h76e8zjgoo"));
        assertTrue("Butonul de acceptare cookie nu este vizibil", acceptCookie6.isDisplayed());
        assertTrue("Butonul de acceptare cookie nu este activ", acceptCookie6.isEnabled());
        acceptCookie6.click();


        WebElement resigilate = driver.findElement(By.linkText("Resigilate"));
        assertTrue("Butonul 'Resigilate' nu este vizibil!", resigilate.isDisplayed());
        assertTrue("Butonul 'Resigilate' nu este activ!", resigilate.isEnabled());
        resigilate.click();

        WebElement paginaDeschisa2 = driver.findElement(By.cssSelector("body > div.main-container-outer > div.main-container-inner"));
        assertTrue("Pagina nu se deschide", paginaDeschisa2.isDisplayed());

        if(paginaDeschisa2.isDisplayed()) {
            System.out.println("Pagina 'Resigilate' a fost deschisa!");
        }
    }


    @After
    public void teardown() {

        driver.quit();
    }
}
