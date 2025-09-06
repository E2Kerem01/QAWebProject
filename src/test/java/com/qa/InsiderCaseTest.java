package com.qa;


import com.insider.pages.CareersPage;
import com.insider.pages.HomePage;
import com.insider.pages.OpenPositionsPage;
import com.insider.pages.QualityAssurancePage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.qa.listeners.TestLogger.class)
public class InsiderCaseTest extends BaseTest {

    @Test(priority = 0)
    public void homePageTest(){
        HomePage homePage = new HomePage(driver);
        homePage.checkHomePageLink();
        homePage.homePageIconIsVisible();
        homePage.checkHomePageTitleEquals();
        homePage.clickCompanyButton();
        homePage.clickCareersPage();
    }

    @Test(priority = 1)
    public void careerPageTest(){
        CareersPage careersPage = new CareersPage(driver);
        careersPage.checkCareersPageUrl();
        careersPage.checkOurStory();
        careersPage.checkTeamSection();
        careersPage.checkLocationSection();
        careersPage.verifyLocationsCountEquals();
        careersPage.checkLifeAtInsiderSection();
        careersPage.navitageToQualityAssurancePage();
    }

    @Test(priority = 2)
    public void qualityAssurancePageTest(){
        QualityAssurancePage qualityAssurancePage = new QualityAssurancePage(driver);
        qualityAssurancePage.checkQualityAssuranceUrl();
        qualityAssurancePage.checkQualityAssurancePage();
        qualityAssurancePage.clickQualityAssuranceJobs();
    }

    @Test(priority = 3)
    public void openPositionPageTest(){
        OpenPositionsPage openPositionsPage = new OpenPositionsPage(driver);
        openPositionsPage.checkOpenPositionsUrl();

    }

}
