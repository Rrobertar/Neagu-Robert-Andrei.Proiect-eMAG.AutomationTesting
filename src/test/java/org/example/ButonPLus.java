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

public class ButonPLus {
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

        WebElement acceptCookie8 = driver.findElement(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.show > div > div.col-xs-12.col-sm-5.col-md-4.col-lg-3.cookie-banner-buttons > button.btn.btn-primary.btn-block.js-accept.gtm_h76e8zjgoo"));
        assertTrue("Butonul de acceptare cookie nu este vizibil", acceptCookie8.isDisplayed());
        assertTrue("Butonul de acceptare cookie nu este activ", acceptCookie8.isEnabled());
        acceptCookie8.click();

        WebDriverWait waitpopup3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement InchidePopup3 = waitpopup3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.login-view.login-view-ro.show > div > button > i")));
        InchidePopup3.click();

        WebElement butonulAdaugaInCos2= driver.findElement(By.cssSelector("#main-container > div > section.flash-deals-section > div > div > div.ph-scroller > div > div:nth-child(2) > div > div > div.card-v2-content.card-v2-atc-updated > div.card-v2-atc.mt-1 > form > button > i"));
        assertTrue("Butonul 'butonulAdaugaInCos2' nu este vizibil!", butonulAdaugaInCos2.isDisplayed());
        assertTrue("Butonul 'butonulAdaugaInCos2' nu este activ!", butonulAdaugaInCos2.isEnabled());
        butonulAdaugaInCos2.click();

        WebDriverWait waitdetaliicos = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement vezidetaliiCos=waitdetaliicos.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.ph-modal.modal.fade.ph-modal-fullscreen.product-purchased-modal.modal-version-Rec.in > div > div > div.modal-body.modal-content-extra-padding.py-2.d-none.d-sm-block > div > div.table-cell.col-xs-12.col-sm-2.col-md-2.d-none.d-md-table-cell > a")));
        assertTrue("Butonul 'Vezi detalii cos' nu este vizibil!", vezidetaliiCos.isDisplayed());
        vezidetaliiCos.click();

        WebDriverWait waitcrestecantitatea= new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement cresteCantitatea = waitcrestecantitatea.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart-products > div > div.col-md-8.col-lg-9.main-cart-container-left > div.placeholder.vendors-container > div:nth-child(1) > div.cart-widget.cart-line > div.line-item.line-item-footer.d-none.d-md-block > div.d-flex.justify-content-between.line-item-pricing-details > div.line-qty-container > div > button:nth-child(4) > i")));
        cresteCantitatea.click();
        assertTrue("Butonul '+' nu este vizibil", cresteCantitatea.isDisplayed());
        assertTrue("Butonul '+' nu este activ", cresteCantitatea.isEnabled());

        WebElement Cantiatatecrescuta= driver.findElement(By.cssSelector("#cart-products > div > div.col-md-8.col-lg-9.main-cart-container-left > div.placeholder.vendors-container > div > div.cart-widget.cart-line > div.line-item-details > div.line-item.line-item-footer.d-md-none > div.d-flex.justify-content-between.line-item-pricing-details > div.line-qty-container > div > span"));
        assertTrue("cantitatea nu a fost crescuta", cresteCantitatea.isDisplayed());

        if(Cantiatatecrescuta.isDisplayed()) {
            System.out.println("Cantitatea produsului din cos a fost crescuta!");
        }
    }

    @After
    public void teardown() {

        driver.quit();
    }
}



