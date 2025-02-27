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

public class AdaugainCos {
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

        WebElement acceptCookie3 = driver.findElement(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.show > div > div.col-xs-12.col-sm-5.col-md-4.col-lg-3.cookie-banner-buttons > button.btn.btn-primary.btn-block.js-accept.gtm_h76e8zjgoo"));
        assertTrue("Butonul de acceptare cookie nu este vizibil", acceptCookie3.isDisplayed());
        assertTrue("Butonul de acceptare cookie nu este activ", acceptCookie3.isEnabled());
        acceptCookie3.click();

        WebElement BaraDeCautare2 = driver.findElement(By.id("searchboxTrigger"));
        assertTrue("no searchbar", BaraDeCautare2.isDisplayed());
        BaraDeCautare2.click();
        BaraDeCautare2.sendKeys("canapea");
        BaraDeCautare2.sendKeys(Keys.ENTER);
        WebElement rezultat2 = driver.findElement(By.cssSelector("#card_grid > div:nth-child(1) > div > div > div.card-v2-content > div.card-v2-atc.mt-1 > form > button"));
        assertTrue("Rezultatul cautarii nu este afisat!", rezultat2.isDisplayed());

        WebElement InchidePopup = driver.findElement(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.login-view.login-view-ro.show > div > button > i"));
        InchidePopup.click();

        WebElement butonulAdaugaincos = driver.findElement(By.cssSelector("#card_grid > div:nth-child(1) > div > div > div.card-v2-content > div.card-v2-atc.mt-1 > form > button"));
        assertTrue("Butonul 'Adauga in cos' nu este activ!", butonulAdaugaincos.isEnabled());
        butonulAdaugaincos.click();

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement butonulVeziCos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.ph-modal.modal.fade.ph-modal-fullscreen.product-purchased-modal.modal-version-Rec.in > div > div > div.modal-body.modal-content-extra-padding.py-2.d-none.d-sm-block > div > div.table-cell.col-xs-12.col-sm-2.col-md-2.d-none.d-md-table-cell > a")));
        assertTrue("Butonul 'Vezi cos' nu este vizibil!", butonulVeziCos.isDisplayed());
        butonulVeziCos.click();

        WebElement PaginaCos = driver.findElement(By.cssSelector("#cart-products > h1"));
        assertTrue("Pagina cosului nu s a deschis!", PaginaCos.isDisplayed());

        WebElement ProdusulEsteinCos = driver.findElement(By.cssSelector("#cart-products > div > div.col-md-8.col-lg-9.main-cart-container-left > div.placeholder.vendors-container > div > div.cart-widget.cart-line > div.line-item-details > div.line-item.main-product"));
        assertTrue("Produsul nu este in cos !", ProdusulEsteinCos.isDisplayed());

        if (ProdusulEsteinCos.isDisplayed()) {
            System.out.println("Produsul este in cos");
        }
    }


    @After
    public void teardown() {

        driver.quit();
    }
}
