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

public class OfertaZilei {
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

        WebElement acceptCookie5 = driver.findElement(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.show > div > div.col-xs-12.col-sm-5.col-md-4.col-lg-3.cookie-banner-buttons > button.btn.btn-primary.btn-block.js-accept.gtm_h76e8zjgoo"));
        assertTrue("Butonul de acceptare cookie nu este vizibil", acceptCookie5.isDisplayed());
        assertTrue("Butonul de acceptare cookie nu este activ", acceptCookie5.isEnabled());
        acceptCookie5.click();

        WebElement ofertaZilei= driver.findElement(By.linkText("Oferta Zilei"));
        assertTrue("Butonul 'OfertaZilei' nu este vizibil!", ofertaZilei.isDisplayed());
        assertTrue("Butonul 'OfertaZilei' nu este activ!", ofertaZilei.isEnabled());
        ofertaZilei.click();

        try{
            WebDriverWait waitpopup2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement InchidePopup2 = waitpopup2.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.login-view.login-view-ro.show > div > button > i")));
        InchidePopup2.click();
        }
        catch(Exception e){ System.out.println("Pop-up-ul nu a aparut!");
        }
        

        try {
            WebElement cookiepaginaOferta = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/button[1]"));
            cookiepaginaOferta.click();
        }
        catch(Exception e){
            System.out.println("Al doilea cookie de pe pagina OfertaZilei nu apare");
        }


        WebElement paginaDeschisa = driver.findElement(By.cssSelector("body > div.main-container-outer > div.main-container-inner"));
        assertTrue("Pagina nu se deschide", paginaDeschisa.isDisplayed());

        if(paginaDeschisa.isDisplayed()) {
            System.out.println("Pagina 'Oferta Zilei' a fost deschisa!");
        }

    }


    @After
    public void teardown() {

        driver.quit();
    }
}

