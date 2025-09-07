package com.insider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public By viewRoleInCard = By.cssSelector("#jobs-list [data-location='istanbul-turkiye'] [target]");
    public By textOfTheJob = By.cssSelector("#jobs-list [data-team] p");
    public By departmentOfTheJob = By.cssSelector("#jobs-list [data-location='istanbul-turkiye'] [class='position-department text-large font-weight-600 text-primary']");
    public By locationOfTheJob = By.cssSelector("#jobs-list [data-location='istanbul-turkiye'] .position-location");
    public By viewRoleForSeniorQa = By.xpath("//body/div[@class='content-wrapper posting-page']/div[@class='content']//h2");
    public By applyForThisJob = By.cssSelector(".postings-btn-wrapper > .postings-btn.shamrock.template-btn-submit");

    //Expected
    private String expectedOpenPositionsPageTitle = "All open positions";
    private String expectedTextOfTheJobAndDepartment = "Quality Assurance";
    private String expectedLocationOfTheJob = "Istanbul, Turkiye";

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
        waitSec(5);
        click(filterOfLocation);
        click(locationSelected);
        return this;
    }

    public OpenPositionsPage tinyScroll(){
        scrollBy(350); return this; }

    public void assertAllCardsOnJobs(){
        waitSec(5);
        assertAllTexts(textOfTheJob, expectedTextOfTheJobAndDepartment,false);
        assertAllTexts(departmentOfTheJob,expectedTextOfTheJobAndDepartment,true);
        assertAllTexts(locationOfTheJob,expectedLocationOfTheJob, true);
    }


    public OpenPositionsPage verifyAllRoles_QA_and_URL() {
        int total = driver.findElements(viewRoleInCard).size();
        for (int i = 0; i < total; i++) {
            var links = driver.findElements(viewRoleInCard);     // her turda taze al
            String back = clickAndSwitch(links.get(i));
            waitUrlContains("lever.co");
            assertAllTexts(viewRoleForSeniorQa, expectedTextOfTheJobAndDepartment, false);
            clickable(applyForThisJob);
            closeTabAndBack(back);
        }
        return this;
    }



}
