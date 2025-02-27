package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


import static org.junit.Assert.*;

public class AdaugalaFavorite {
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

        WebElement acceptCookie4 = driver.findElement(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.show > div > div.col-xs-12.col-sm-5.col-md-4.col-lg-3.cookie-banner-buttons > button.btn.btn-primary.btn-block.js-accept.gtm_h76e8zjgoo"));
        assertTrue("Butonul de acceptare cookie nu este vizibil", acceptCookie4.isDisplayed());
        assertTrue("Butonul de acceptare cookie nu este activ", acceptCookie4.isEnabled());
        acceptCookie4.click();

        WebElement BaraDeCautare3 = driver.findElement(By.id("searchboxTrigger"));
        assertTrue("no searchbar", BaraDeCautare3.isDisplayed());
        BaraDeCautare3.click();
        BaraDeCautare3.sendKeys("canapea");
        BaraDeCautare3.sendKeys(Keys.ENTER);

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement rezultat3 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#card_grid > div:nth-child(1) > div > div > div.card-v2-content > div.card-v2-atc.mt-1 > form > button")));
        assertTrue("Rezultatul cautarii nu este afisat!", rezultat3.isDisplayed());

        WebElement IconulFavorit = driver.findElement(By.cssSelector("#card_grid > div:nth-child(1) > div > div > div.card-v2-toolbox > button.add-to-favorites.btn"));
        assertTrue("Iconul 'Favorit' nu este vizibil!", IconulFavorit.isDisplayed());
        assertTrue("Iconul 'Favorit' nu este activ!", IconulFavorit.isEnabled());
        IconulFavorit.click();

        WebElement butonlistafavorite = driver.findElement(By.cssSelector("#my_wishlist > i"));
        butonlistafavorite.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement produsinlistaFavorite = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#list-of-favorites > div > div")));

        assertTrue("Produsul nu este in listaFavorite", produsinlistaFavorite.isDisplayed());

        if (produsinlistaFavorite.isDisplayed()) {
            System.out.println("Pordusul este in lista Favorite");
        }
    }


    @After
    public void teardown() {

        driver.quit();
    }
}



