package org.courses.tests;

import org.courses.pages.duckdetailspage.DuckDetailsPage;
import org.courses.pages.duckdetailspage.components.DuckDetailsSection;
import org.courses.pages.mainpage.MainPage;
import org.courses.utils.Utils;
import org.courses.utils.WebDriverSelection;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static org.courses.pages.mainpage.components.DucksBlock.CAMPAIGNS;

public class DuckDetailsTest {
    private WebDriver myPersonalDriver;
    private String userEmail;
    private String userPassword;
    private MainPage mainPage;

    @BeforeClass
    public void beforeClass() {
        userPassword = new Utils().getTestProperties().getProperty("userPassword");
        userEmail = new Utils().getTestProperties().getProperty("userEmail");
        myPersonalDriver = new WebDriverSelection().getDriverFromProperties();
        myPersonalDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void duckDetailsTest() {
        MainPage mainPage = new MainPage(myPersonalDriver);
        mainPage.open();
        mainPage.login(userEmail, userPassword);

        //It was said to check picture/data of first duck in Campaign on Main Page
        Map<String, String> duckData = mainPage.getDuck(CAMPAIGNS, 0).getDuckData();
        String duckOnMainPageName = duckData.get("duckName");
        String duckOnMainPageOrdinaryPrice = duckData.get("regularPrice");
        String duckOnMainPageOrdinaryColor = duckData.get("regularPriceColor");
        String duckOnMainPageOrdinaryPriceDecoration = duckData.get("regularPriceDecoration");
        String duckOnMainPageCampaignPrice = duckData.get("campaignPrice");
        String duckOnMainPageCampaignPriceColor = duckData.get("campaignPriceColor");

        //Asserts for MainPage data
        //....

        //It was said to check first duck in Campaign so click it
        mainPage.openParticularDuckDetailsPage(CAMPAIGNS, 0);

        //Get data from DuckDetailsPage
        DuckDetailsPage duckDetailsPage = new DuckDetailsPage(myPersonalDriver);
        DuckDetailsSection duckDetailsSection = duckDetailsPage.getDuckDetailsSection();
        Map<String, String> duckDataOnDuckDetailsPage =  duckDetailsSection.getDuckData();

        String duckOnDetailsPageName = duckDetailsPage.getDuckName();
        String duckOnDetailsPageOrdinaryPrice = duckDataOnDuckDetailsPage.get("regularPrice");
        String duckOnDetailsPageOrdinaryPriceColor = duckDataOnDuckDetailsPage.get("regularPriceColor");
        String duckOnDetailsPageOrdinaryPriceDecoration = duckDataOnDuckDetailsPage.get("regularPriceDecoration");
        String duckOnDetailsPageCampaignPrice = duckDataOnDuckDetailsPage.get("campaignPrice");
        String duckOnDetailsPageCampaignPriceColor = duckDataOnDuckDetailsPage.get("campaignPriceColor");


        //Asserts for DuckDetailsPage data
        //....

        //Asserts to compare data on both pages
        //...


    }

    @AfterClass
    public void afterClass() {
        myPersonalDriver.quit();
    }
}

