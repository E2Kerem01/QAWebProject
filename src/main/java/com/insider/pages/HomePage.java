package com.insider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class HomePage extends BasePage {

    // --- Locators ---
    private By homePageIconPath = By.cssSelector("#navigation [data-animate] [loading]");
    private By homePageTitlePath = By.cssSelector (".slide-text > span");
    private By companyButton = By.cssSelector("li:nth-of-type(6) > a#navbarDropdownMenuLink > .dropdown-icon");
    private By careerButton =  By.cssSelector(".new-menu-dropdown-layout-6-mid-container > a:nth-of-type(2)");


    private static final String EXPECTED_HOME_TITLE =
            "Insider named a Leader in the IDC MarketScape Report 2025";

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void checkHomePageTitleEquals() {
        assertTextEquals(homePageTitlePath, EXPECTED_HOME_TITLE);

    }

    public void checkHomePageLink() {
        waitUrlContains("useinsider.com");
    }

    public void homePageIconIsVisible(){
        checkVisible(homePageIconPath);
    }

    public void clickCompanyButton() {
        click(companyButton);
    }

    public void clickCareersPage() {
        click(careerButton);

    }
}
