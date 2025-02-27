package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


import static org.junit.Assert.*;

public class ContulmeuLogin {
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

        SoftAssert softAssert = new SoftAssert();
        String title = driver.getTitle();
        assertEquals("eMAG.ro - Căutarea nu se oprește niciodată", title);

        if (title.contains("eMAG.ro - Căutarea nu se oprește niciodată")) {
            System.out.println("Suntem pe pagina Emag");
        } else {
            System.out.println("Nu suntem pe pagina eMAG");
        }


// 1. Butonul Contul meu.


        WebElement acceptCookie = driver.findElement(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.show > div > div.col-xs-12.col-sm-5.col-md-4.col-lg-3.cookie-banner-buttons > button.btn.btn-primary.btn-block.js-accept.gtm_h76e8zjgoo"));
        assertTrue("Butonul de acceptare cookie nu este vizibil", acceptCookie.isDisplayed());
        assertTrue("Butonul de acceptare cookie nu este activ", acceptCookie.isEnabled());
        acceptCookie.click();

        WebElement ContulMeu = driver.findElement(By.cssSelector("#my_account > i"));
        assertTrue("Iconul 'Contul meu' nu este vizibil! ", ContulMeu.isDisplayed());
        ContulMeu.click();

        WebElement paginadeLogare = driver.findElement(By.cssSelector("body > div.auth-box.text-center"));
        assertTrue("Pagina de logare nu este deschisa", paginadeLogare.isDisplayed());

        if (paginadeLogare.isDisplayed()) {
            System.out.println("Pagina de logare este deschisa !");
        }


// 2. log in.


        WebElement Email = driver.findElement(By.cssSelector("#user_login_email"));
        Email.click();
        Email.sendKeys("Robertandrei.neagu@yahoo.com");
        assertEquals("Email-ul introdus nu este corect!", "Robertandrei.neagu@yahoo.com", Email.getAttribute("value"));

        WebElement continua = driver.findElement(By.cssSelector("#user_login_continue"));
        continua.click();

        asteapta(10);

        WebElement Parola = driver.findElement(By.id("user_login_password"));
        Parola.click();
        Parola.sendKeys("Emag-24689");

        WebElement continua2 = driver.findElement(By.cssSelector("#user_login_continue"));
        continua2.click();

        asteapta(10);

//        WebElement confirma = driver.findElement(By.cssSelector("body > div.auth-box.text-center"));
//        assertTrue("pagina de confirmare nu apare", confirma.isDisplayed());
//        asteapta(20);

//        WebElement ContinuaConfirma = driver.findElement(By.cssSelector("#validate_mfa_continue"));
//        ContinuaConfirma.click();

        WebElement LogInRealizat = driver.findElement(By.cssSelector("#main-container > section"));  // Folosește ID-ul elementului care apare pe pagina după login

        assertTrue("Login-ul nu a fost realizat cu succes!", LogInRealizat.isDisplayed());

        if (LogInRealizat.isDisplayed()) {
            System.out.println("Logarea a fost realizata cu succes!");

        }
    }


        @After
        public void teardown () {

            driver.quit();
        }
    }
