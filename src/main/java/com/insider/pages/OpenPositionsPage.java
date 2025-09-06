package com.insider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class OpenPositionsPage extends BasePage {
    // Locators
    public By titleOfOpenPositionsPage = By.cssSelector("[class='col-12 text-center'] h3");
    public By sectionOfFilter = By.id("career-position-filter");
    public By filterOfDepartman = By.cssSelector("span#select2-filter-by-department-container");
    public By SelectedQualityAssurance = By.cssSelector("span#select2-filter-by-department-container>span");
    public By filterOfLocation = By.cssSelector("span#select2-filter-by-location-container");
    public By qualityAssuranceselected = By.cssSelector("ul#select2-filter-by-department-results > li:nth-of-type(17)");
    public By locationSelected = By.cssSelector("ul#select2-filter-by-location-results > li:nth-of-type(11)");
    //Expected
    public String expectedOpenPositionsPageTitle = "All open positions";

    public OpenPositionsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void checkOpenPositionsUrlandTitle(){
        waitUrlContains("https://useinsider.com/careers/open-positions/?department=qualityassurance");
        assertTextEquals(titleOfOpenPositionsPage, expectedOpenPositionsPageTitle);
    }

    public void checkSectionOfFilter(){
        assertVisibleAndEnabledNow(sectionOfFilter);
    }

    public OpenPositionsPage ensureDepartmentQA(){
        if (driver.findElements(SelectedQualityAssurance).isEmpty()){
            click(filterOfDepartman);
            click(qualityAssuranceselected);
        }
        return this;
    }

    public OpenPositionsPage selectLocationIstanbul(){
        click(filterOfLocation);
        click(locationSelected);
        return this;
    }

    public OpenPositionsPage tinyScroll(){
        scrollBy(300); return this; }
}
