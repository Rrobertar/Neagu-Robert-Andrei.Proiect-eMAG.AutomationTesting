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

public class Sterge {
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

        WebElement acceptCookie9 = driver.findElement(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.show > div > div.col-xs-12.col-sm-5.col-md-4.col-lg-3.cookie-banner-buttons > button.btn.btn-primary.btn-block.js-accept.gtm_h76e8zjgoo"));
        assertTrue("Butonul de acceptare cookie nu este vizibil", acceptCookie9.isDisplayed());
        assertTrue("Butonul de acceptare cookie nu este activ", acceptCookie9.isEnabled());
        acceptCookie9.click();

        WebDriverWait waitpopup4 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement InchidePopup4 = waitpopup4.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.login-view.login-view-ro.show > div > button > i")));
        InchidePopup4.click();

        WebElement butonulAdaugaInCos3 = driver.findElement(By.cssSelector("#main-container > div > section.flash-deals-section > div > div > div.ph-scroller > div > div:nth-child(2) > div > div > div.card-v2-content.card-v2-atc-updated > div.card-v2-atc.mt-1 > form > button > i"));
        assertTrue("Butonul 'butonulAdaugaInCos3' nu este vizibil!", butonulAdaugaInCos3.isDisplayed());
        assertTrue("Butonul 'butonulAdaugaInCos3' nu este activ!", butonulAdaugaInCos3.isEnabled());
        butonulAdaugaInCos3.click();

        WebDriverWait waitbutonvezicos = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement vezidetaliiCos2 = waitbutonvezicos.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.ph-modal.modal.fade.ph-modal-fullscreen.product-purchased-modal.modal-version-Rec.in > div > div > div.modal-body.modal-content-extra-padding.py-2.d-none.d-sm-block > div > div.table-cell.col-xs-12.col-sm-2.col-md-2.d-none.d-md-table-cell > a")));
        assertTrue("Butonul 'Vezi cos' nu este vizibil!", vezidetaliiCos2.isDisplayed());
        vezidetaliiCos2.click();

        WebElement stergeProdus = driver.findElement(By.cssSelector("#cart-products > div > div.col-md-8.col-lg-9.main-cart-container-left > div.placeholder.vendors-container > div:nth-child(1) > div.cart-widget.cart-line > div.line-item.line-item-footer.d-none.d-md-block > div.mb-1 > button"));
        assertTrue("Butonul 'stergeProdus' nu este vizibil!", stergeProdus.isDisplayed());
        stergeProdus.click();

        WebElement CosulEsteGol = driver.findElement(By.cssSelector("#cart-products > div > div.col-md-8.col-lg-9.main-cart-container-left > div.placeholder.notifications-container > div > div > p"));
        assertTrue("Pordusul nu a fost sters", CosulEsteGol.isDisplayed());

        if (CosulEsteGol.isDisplayed()) {
            System.out.println("Produsul a fost sters din cos!");
        }
    }


    @After
    public void teardown() {

        driver.quit();
    }
}
