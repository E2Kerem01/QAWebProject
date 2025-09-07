package com.insider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class QualityAssurancePage extends BasePage {

    // Locators
    private By qualityAssuranceTitle = By.cssSelector(".big-title.big-title-media.mt-4.mt-lg-0");
    private By qualityAssuranceJobsButton = By.cssSelector(".btn.btn-outline-secondary.mt-2.px-lg-5.py-3.rounded.text-medium.w-100.w-md-50");

    //Expected Result
    private String expectedTitleOfQualityAssurance = "Quality Assurance";

    public QualityAssurancePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void checkQualityAssuranceUrl(){
        waitUrlContains("https://useinsider.com/careers/");
    }

    public void checkQualityAssurancePage() {
        assertVisibleAndEnabledNow(qualityAssuranceTitle);
        assertTextEquals(qualityAssuranceTitle,expectedTitleOfQualityAssurance);
    }

    public void clickQualityAssuranceJobs() {
        click(qualityAssuranceJobsButton);
    }
}
