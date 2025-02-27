package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


import static org.junit.Assert.*;

public class Baradecautare {
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
    public void testGetPosts() {
        // Send GET request to fetch a list of posts
        Response response = RestAssured.get("https://www.emag.ro/");

        // Validate response code
        assertEquals(200, response.getStatusCode());

        System.out.println(response.getStatusCode());
    }


    public void souldbeanswerWithTrue() {

        driver.get("https://www.emag.ro/");

        WebElement acceptCookie2 = driver.findElement(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.show > div > div.col-xs-12.col-sm-5.col-md-4.col-lg-3.cookie-banner-buttons > button.btn.btn-primary.btn-block.js-accept.gtm_h76e8zjgoo"));
        assertTrue("Butonul de acceptare cookie nu este vizibil", acceptCookie2.isDisplayed());
        assertTrue("Butonul de acceptare cookie nu este activ", acceptCookie2.isEnabled());
        acceptCookie2.click();

        WebElement BaraDeCautare = driver.findElement(By.id("searchboxTrigger"));
        assertTrue("no searchbar", BaraDeCautare.isDisplayed());
        BaraDeCautare.click();
        BaraDeCautare.sendKeys("canapea");
        BaraDeCautare.sendKeys(Keys.ENTER);

        WebElement rezultat = driver.findElement(By.cssSelector("#card_grid > div:nth-child(1) > div > div > div.card-v2-info > div > h2 > a"));
        assertTrue("Rezultatul cautarii nu este afisat!", rezultat.isDisplayed());

        if(rezultat.isDisplayed()) {
            System.out.println("Rezultatul cautarii este afisat!");
        }
    }


    @After
    public void teardown() {

        driver.quit();
    }
}
