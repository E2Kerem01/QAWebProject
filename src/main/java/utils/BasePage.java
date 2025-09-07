package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    protected WebElement checkVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement clickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected void waitUrlContains(String fragment) {
        wait.until(ExpectedConditions.urlContains(fragment));
    }

    protected WebElement present(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected String getText(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by))
                .getText()
                .trim();
    }

    protected void assertTextEquals(By by, String expected) {
        String actual = getText(by);
        if (!actual.equals(expected)) {
            throw new AssertionError("Text mismatch. Expected: '" + expected + "' but was: '" + actual + "'");
        }
    }

    protected int count(By by) {
        return driver.findElements(by).size();
    }

    protected void assertEquals(int actual, int expected) {
        if (actual != expected) {
            throw new AssertionError("Expected: %d, Actual: %d".formatted(expected, actual));
        }
    }

    protected WebElement assertVisibleAndEnabledNow(By by) {
        WebElement el = driver.findElement(by);
        if (!el.isDisplayed()) throw new AssertionError("Element not visible: " + by);
        if (!el.isEnabled())   throw new AssertionError("Element disabled: " + by);
        return el;
    }

    protected  void navigateTo(String url) {
        driver.navigate().to(url);
    }

    protected void scrollBy(int px) {
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0, arguments[0]);", px);
    }

    protected String clickAndSwitch(WebElement link) {
        String back = driver.getWindowHandle();
        int before  = driver.getWindowHandles().size();
        link.click();
        new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(5))
                .until(d -> d.getWindowHandles().size() > before);
        for (String h : driver.getWindowHandles()) if (!h.equals(back)) { driver.switchTo().window(h); break; }
        return back;
    }


    protected void closeTabAndBack(String back) {
        driver.close();
        driver.switchTo().window(back);
    }

    protected void assertAllTexts(By by, String expected, boolean exactMatch) {
        var els = driver.findElements(by);
        if (els.isEmpty()) throw new AssertionError("Hiç eleman bulunamadı: " + by);

        for (int i = 0; i < els.size(); i++) {
            String t = els.get(i).getText().trim();
            if (exactMatch) {
                if (!t.equalsIgnoreCase(expected)) {
                    throw new AssertionError("#" + (i+1) + " beklenen: '" + expected + "', bulunan: '" + t + "'");
                }
            } else {
                if (!t.toLowerCase().contains(expected.toLowerCase())) {
                    throw new AssertionError("#" + (i+1) + " '" + expected + "' içermiyor. Metin: '" + t + "'");
                }
            }
        }
    }

    protected void waitSec(int sec) {
        try { Thread.sleep(sec * 1000L); } catch (InterruptedException ignored) {}
    }


}
