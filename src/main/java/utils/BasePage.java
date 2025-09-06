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

    protected String switchToNewTab() {
        String original = driver.getWindowHandle();
        for (String h : driver.getWindowHandles()) {
            if (!h.equals(original)) {
                driver.switchTo().window(h);
                return original; // geri döneceğimiz handle
            }
        }
        throw new AssertionError("Yeni sekme açılmadı");
    }

    protected void closeAndBack(String original) {
        driver.close();
        driver.switchTo().window(original);

    }
}
