package com.insider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class OpenPositionsPage extends BasePage {
    // Locators
    public By titleOfOpenPositionsPage = By.cssSelector("[class='col-12 text-center'] h3");
    public By sectionOfFilter = By.id("#career-position-filter");

    //Expected

    public OpenPositionsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void checkOpenPositionsUrl(){
        waitUrlContains("https://useinsider.com/careers/open-positions/?department=qualityassurance");
    }

    public void checkSectionOfFilter(){

    }

    public OpenPositionsPage ensureDepartmentQA(){
        if (driver.findElements(QA_SELECTED).isEmpty()){
            click(FILTER_DEPARTMENT);
            click(QA_OPTION);
        }
        return this;
    }

    public OpenPositionsPage selectLocationIstanbul(){
        click(FILTER_LOCATION);
        click(ISTANBUL_OPTION);
        return this;
    }

    public OpenPositionsPage tinyScroll(){
        scrollBy(300); return this; }
}
