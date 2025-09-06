package com.qa;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.nio.file.Paths;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected static final String BASE_URL =
            System.getProperty("baseUrl", "https://useinsider.com/");

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        String browser = System.getProperty("browser","chrome").toLowerCase();
        boolean headless = Boolean.parseBoolean(System.getProperty("headless","false"));

        switch (browser) {
            case "firefox" -> {
                FirefoxOptions fo = new FirefoxOptions();
                if (headless) fo.addArguments("-headless");
                fo.addPreference("dom.webnotifications.enabled", false);
                driver = new FirefoxDriver(fo);
            }
            case "edge" -> {
                EdgeOptions eo = new EdgeOptions();
                if (headless) eo.addArguments("--headless=new");
                eo.addArguments("--disable-notifications");
                driver = new EdgeDriver(eo);
            }
            default -> {
                ChromeOptions co = new ChromeOptions();
                if (headless) co.addArguments("--headless=new");
                co.addArguments("--start-maximized","--disable-notifications");
                String profileDir = Paths.get("chrome-profile").toAbsolutePath().toString();
                co.addArguments("--user-data-dir=" + profileDir);
                driver = new ChromeDriver(co);
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        try { driver.manage().window().maximize(); } catch (Exception ignore) {}

        driver.get(BASE_URL);
        try {
            By cookieBtn = By.cssSelector("#wt-cli-accept-all-btn, [id*='wt-cli-accept-all-btn']");
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(cookieBtn)).click();
        } catch (Exception ignore) {}
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (driver != null) {
            // GUI'de görmek için: -DholdOnExitSec=10 ver
            long hold = Long.parseLong(System.getProperty("holdOnExitSec", "10"));
            // headless ise beklemenin pek anlamı yok, istersen atla
            if (hold > 0 && !Boolean.parseBoolean(System.getProperty("headless","false"))) {
                try { Thread.sleep(hold * 1000L); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
            driver.quit();
        }
    }
//    @AfterClass(alwaysRun = true)
//    public void tearDownClass() {
//        if (driver != null) driver.quit();
//    }
}
