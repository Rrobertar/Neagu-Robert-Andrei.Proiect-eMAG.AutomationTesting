package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


import static org.junit.Assert.*;

public class Logo {
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

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            WebElement acceptCookie7 = driver.findElement(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.show > div > div.col-xs-12.col-sm-5.col-md-4.col-lg-3.cookie-banner-buttons > button.btn.btn-primary.btn-block.js-accept.gtm_h76e8zjgoo"));
            assertTrue("Butonul de acceptare cookie nu este vizibil", acceptCookie7.isDisplayed());
            assertTrue("Butonul de acceptare cookie nu este activ", acceptCookie7.isEnabled());
            acceptCookie7.click();
        } catch (Exception e) {
            System.out.println("No cookie here");
        }

        WebElement cosulMeu = driver.findElement(By.cssSelector("#my_cart > i"));
        assertTrue("Butonul 'cosulMeu' nu este vizibil!", cosulMeu.isDisplayed());
        assertTrue("Butonul 'cosulMeu' nu este activ!", cosulMeu.isEnabled());
        cosulMeu.click();

        WebElement logo = driver.findElement(By.cssSelector("#masthead > div > div > div.navbar-branding > a > img"));
        assertTrue("Butonul 'eMag' nu este vizibil!", logo.isDisplayed());
        assertTrue("Butonul 'eMag' nu este activ!", logo.isEnabled());
        logo.click();

        WebElement paginadeStart = driver.findElement(By.cssSelector("body > div.main-container-outer > div.main-container-inner"));
        assertTrue("Nu se deschide homepage", paginadeStart.isDisplayed());

        if(paginadeStart.isDisplayed()) {
            System.out.println("Pagina de start a fost deschisa folosind logo-ul site ului!");
        }
    }


    @After
    public void teardown() {

        driver.quit();
    }
}

