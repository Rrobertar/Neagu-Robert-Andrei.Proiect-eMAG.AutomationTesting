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
import org.testng.asserts.SoftAssert;

import java.time.Duration;


import static org.junit.Assert.*;

public class eMAG {
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


// 1. Butonul "Contul meu".

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


// 2. Log in.

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

        try {

            WebElement confirma = driver.findElement(By.cssSelector("body > div.auth-box.text-center"));
            assertTrue("pagina de confirmare nu apare", confirma.isDisplayed());
            asteapta(20);

            WebElement ContinuaConfirma = driver.findElement(By.cssSelector("#validate_mfa_continue"));
            ContinuaConfirma.click();
        }
        catch(Exception e){
            System.out.println("Pagina de confirmare cod nu a aparut !");
        }

        WebElement LogInRealizat = driver.findElement(By.cssSelector("#main-container > section"));  // Folosește ID-ul elementului care apare pe pagina după login

        assertTrue("Login-ul nu a fost realizat cu succes!", LogInRealizat.isDisplayed());

        if (LogInRealizat.isDisplayed()) {
            System.out.println("Logarea a fost realizata cu succes!");
        }


// 3.Bara de cautare.


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

        if (rezultat.isDisplayed()) {
            System.out.println("Rezultatul cautarii este afisat!");
        }


// 4.Adauga in cos.

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

        WebDriverWait waitbutonvezicos = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement butonulVeziCos = waitbutonvezicos.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.ph-modal.modal.fade.ph-modal-fullscreen.product-purchased-modal.modal-version-Rec.in > div > div > div.modal-body.modal-content-extra-padding.py-2.d-none.d-sm-block > div > div.table-cell.col-xs-12.col-sm-2.col-md-2.d-none.d-md-table-cell > a")));
        assertTrue("Butonul 'Vezi cos' nu este vizibil!", butonulVeziCos.isDisplayed());
        butonulVeziCos.click();

        WebElement PaginaCos = driver.findElement(By.cssSelector("#cart-products > h1"));
        assertTrue("Pagina cosului nu s a deschis!", PaginaCos.isDisplayed());

        WebElement ProdusulEsteinCos = driver.findElement(By.cssSelector("#cart-products > div > div.col-md-8.col-lg-9.main-cart-container-left > div.placeholder.vendors-container > div > div.cart-widget.cart-line > div.line-item-details > div.line-item.main-product"));
        assertTrue("Produsul nu este in cos !", ProdusulEsteinCos.isDisplayed());

        if (ProdusulEsteinCos.isDisplayed()) {
            System.out.println("Produsul este in cos");
        }


// 5.Adauga la favorite..

        WebElement acceptCookie4 = driver.findElement(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.show > div > div.col-xs-12.col-sm-5.col-md-4.col-lg-3.cookie-banner-buttons > button.btn.btn-primary.btn-block.js-accept.gtm_h76e8zjgoo"));
        assertTrue("Butonul de acceptare cookie nu este vizibil", acceptCookie4.isDisplayed());
        assertTrue("Butonul de acceptare cookie nu este activ", acceptCookie4.isEnabled());
        acceptCookie4.click();

        WebElement BaraDeCautare3 = driver.findElement(By.id("searchboxTrigger"));
        assertTrue("no searchbar", BaraDeCautare3.isDisplayed());
        BaraDeCautare3.click();
        BaraDeCautare3.sendKeys("canapea");
        BaraDeCautare3.sendKeys(Keys.ENTER);

        WebDriverWait waitrezultat = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement rezultat3 = waitrezultat.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#card_grid > div:nth-child(1) > div > div > div.card-v2-content > div.card-v2-atc.mt-1 > form > button")));
        assertTrue("Rezultatul cautarii nu este afisat!", rezultat3.isDisplayed());

        WebElement IconulFavorit = driver.findElement(By.cssSelector("#card_grid > div:nth-child(1) > div > div > div.card-v2-toolbox > button.add-to-favorites.btn"));
        assertTrue("Iconul 'Favorit' nu este vizibil!", IconulFavorit.isDisplayed());
        assertTrue("Iconul 'Favorit' nu este activ!", IconulFavorit.isEnabled());
        IconulFavorit.click();

        WebElement butonlistafavorite = driver.findElement(By.cssSelector("#my_wishlist > i"));
        butonlistafavorite.click();

        WebDriverWait waitlista = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement produsinlistaFavorite = waitlista.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#list-of-favorites > div > div")));

        assertTrue("Produsul nu este in listaFavorite", produsinlistaFavorite.isDisplayed());

        if (produsinlistaFavorite.isDisplayed()) {
            System.out.println("Pordusul este in lista Favorite");
        }


// 6. Butonul "Oferta Zilei".

        WebElement acceptCookie5 = driver.findElement(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.show > div > div.col-xs-12.col-sm-5.col-md-4.col-lg-3.cookie-banner-buttons > button.btn.btn-primary.btn-block.js-accept.gtm_h76e8zjgoo"));
        assertTrue("Butonul de acceptare cookie nu este vizibil", acceptCookie5.isDisplayed());
        assertTrue("Butonul de acceptare cookie nu este activ", acceptCookie5.isEnabled());
        acceptCookie5.click();

        WebElement ofertaZilei = driver.findElement(By.linkText("Oferta Zilei"));
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

        if (paginaDeschisa.isDisplayed()) {
            System.out.println("Pagina 'Oferta Zilei' a fost deschisa!");
        }


// 7. Butonul "Resigilate".

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

        if (paginaDeschisa2.isDisplayed()) {
            System.out.println("Pagina 'Resigilate' a fost deschisa!");
        }


// 8. Utilizam logo-ul site-ului pentru a reveni pe pagina de start.

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

        if (paginadeStart.isDisplayed()) {
            System.out.println("Pagina de start a fost deschisa folosind logo-ul site ului!");
        }


// 9. Cresc cantitatea produsului din cos.

        WebElement acceptCookie8 = driver.findElement(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.show > div > div.col-xs-12.col-sm-5.col-md-4.col-lg-3.cookie-banner-buttons > button.btn.btn-primary.btn-block.js-accept.gtm_h76e8zjgoo"));
        assertTrue("Butonul de acceptare cookie nu este vizibil", acceptCookie8.isDisplayed());
        assertTrue("Butonul de acceptare cookie nu este activ", acceptCookie8.isEnabled());
        acceptCookie8.click();

        WebDriverWait waitpopup3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement InchidePopup3 = waitpopup3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.py-2.px-0.login-view.login-view-ro.show > div > button > i")));
        InchidePopup3.click();

        WebElement butonulAdaugaInCos2 = driver.findElement(By.cssSelector("#main-container > div > section.flash-deals-section > div > div > div.ph-scroller > div > div:nth-child(2) > div > div > div.card-v2-content.card-v2-atc-updated > div.card-v2-atc.mt-1 > form > button > i"));
        assertTrue("Butonul 'butonulAdaugaInCos2' nu este vizibil!", butonulAdaugaInCos2.isDisplayed());
        assertTrue("Butonul 'butonulAdaugaInCos2' nu este activ!", butonulAdaugaInCos2.isEnabled());
        butonulAdaugaInCos2.click();

        WebDriverWait waitdetaliicos = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement vezidetaliiCos = waitdetaliicos.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.ph-modal.modal.fade.ph-modal-fullscreen.product-purchased-modal.modal-version-Rec.in > div > div > div.modal-body.modal-content-extra-padding.py-2.d-none.d-sm-block > div > div.table-cell.col-xs-12.col-sm-2.col-md-2.d-none.d-md-table-cell > a")));
        assertTrue("Butonul 'Vezi detalii cos' nu este vizibil!", vezidetaliiCos.isDisplayed());
        vezidetaliiCos.click();

        WebDriverWait waitcrestecantitatea = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cresteCantitatea = waitcrestecantitatea.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart-products > div > div.col-md-8.col-lg-9.main-cart-container-left > div.placeholder.vendors-container > div:nth-child(1) > div.cart-widget.cart-line > div.line-item.line-item-footer.d-none.d-md-block > div.d-flex.justify-content-between.line-item-pricing-details > div.line-qty-container > div > button:nth-child(4) > i")));
        cresteCantitatea.click();
        assertTrue("Butonul '+' nu este vizibil", cresteCantitatea.isDisplayed());
        assertTrue("Butonul '+' nu este activ", cresteCantitatea.isEnabled());

        WebElement Cantiatatecrescuta = driver.findElement(By.cssSelector("#cart-products > div > div.col-md-8.col-lg-9.main-cart-container-left > div.placeholder.vendors-container > div > div.cart-widget.cart-line > div.line-item-details > div.line-item.line-item-footer.d-md-none > div.d-flex.justify-content-between.line-item-pricing-details > div.line-qty-container > div > span"));
        assertTrue("cantitatea nu a fost crescuta", cresteCantitatea.isDisplayed());

        if (Cantiatatecrescuta.isDisplayed()) {
            System.out.println("Cantitatea produsului din cos a fost crescuta!");
        }


//10. Stergem produsul din cos.

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

        WebDriverWait waitbutonvezicos2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement vezidetaliiCos2 = waitbutonvezicos2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.ph-modal.modal.fade.ph-modal-fullscreen.product-purchased-modal.modal-version-Rec.in > div > div > div.modal-body.modal-content-extra-padding.py-2.d-none.d-sm-block > div > div.table-cell.col-xs-12.col-sm-2.col-md-2.d-none.d-md-table-cell > a")));
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

