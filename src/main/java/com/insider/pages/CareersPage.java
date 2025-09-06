package com.insider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class CareersPage extends BasePage {
    // Locators
    private By titleOfOurStory = By.cssSelector(".elementor-element.elementor-element-0c06ebc.elementor-widget.elementor-widget-heading  .elementor-heading-title.elementor-size-default");
    private By titleOfTeams = By.cssSelector("[class='col-12 mb-xl-5 py-xl-4 py-2 text-center'] .category-title-media");
    private By titleOfOurLocation = By.cssSelector(".category-title-media.ml-0");
    private By titleOfLifeAtInsider = By.cssSelector(".elementor-element.elementor-element-21cea83.elementor-widget.elementor-widget-heading  .elementor-heading-title.elementor-size-default");

    private By sectionOfOurStory = By.xpath("//body/div[@class='elementor elementor-22610']/section[1]");
    private By sectionOfTeams = By.id("career-find-our-calling");
    private By sectionOfOurLocation= By.id("career-our-location");
    private By sectionOfLifeAtInsider = By.xpath("//body/div[@class='elementor elementor-22610']/section[4]");

    private By seeAllTeamsButton = By.cssSelector(".btn.btn-outline-secondary.loadmore.mt-5.mx-auto.py-3.rounded.text-medium");
    private By textOfOurLocation = By.cssSelector("[class='mt-5 mb-0 mt-lg-0 mx-auto pl-0']");
    private By textOfLifeAtInsider = By.cssSelector("[data-id='fe38935'] p");
    private By ourLocationItems = By.cssSelector("#location-slider ul.glide__slides > li.glide__slide");

    // Expected Name
    private String expectedTitleOfStory = "Our story";
    private String expectedTitleOfLocation = "Our Locations";
    private String expectedTitleOfTeams = "Find your calling";
    private String expectedTitleOfLifeAtInsider = "Life at Insider";
    private String expectedTextOfOurLocation = "28 offices across 6 continents, home to 1100+ Insiders";
    private String expectedTextLifeAtInsider= "We’re here to grow and drive growth—as none of us did before. " +
            "Together, we’re building a culture that inspires us to create our life’s work—and creates a bold(er) impact. " +
            "We know that we’re smarter as a group than we are alone. " +
            "Become one of us if you dare to play bigger.";


    public CareersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void checkCareersPageUrl(){
        waitUrlContains("https://useinsider.com/careers/");
    }

    public void checkOurStory(){
        assertTextEquals(titleOfOurStory,expectedTitleOfStory);
        assertVisibleAndEnabledNow(sectionOfOurStory);
    }

    public void checkTeamSection(){
        assertTextEquals(titleOfTeams,expectedTitleOfTeams);
        assertVisibleAndEnabledNow(sectionOfTeams);
        checkVisible(seeAllTeamsButton);
    }

    public void checkLocationSection(){
        assertTextEquals(titleOfOurLocation,expectedTitleOfLocation);
        assertVisibleAndEnabledNow(sectionOfOurLocation);
        assertTextEquals(textOfOurLocation,expectedTextOfOurLocation);
    }

    public void verifyLocationsCountEquals() {
        int actual = count(ourLocationItems);
        assertEquals(actual, 25);
    }

    public void checkLifeAtInsiderSection(){
        assertTextEquals(titleOfLifeAtInsider,expectedTitleOfLifeAtInsider);
        assertVisibleAndEnabledNow(sectionOfLifeAtInsider);
        assertTextEquals(textOfLifeAtInsider,expectedTextLifeAtInsider);
    }

    public void navitageToQualityAssurancePage(){
        navigateTo("https://useinsider.com/careers/quality-assurance/");
    }

}
