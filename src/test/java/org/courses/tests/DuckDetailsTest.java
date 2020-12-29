package org.courses.tests;

import org.courses.pages.duckdetailspage.DuckDetailsPage;
import org.courses.pages.mainpage.MainPage;
import org.courses.pages.mainpage.components.DuckDetails;
import org.courses.utils.Utils;
import org.courses.utils.WebDriverSelection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
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

        //It was said to check picture/data of first duck in Campaign
        Map<String, String> duckData = mainPage.getDuck(CAMPAIGNS, 0).getDuckData();
        String duckOnMainPageName = duckData.get("duckName");
        String duckOnMainPageOrdinaryPrice = duckData.get("regularPrice");
        String duckOnMainPageOrdinaryColor = duckData.get("regularPriceColor");
        String duckOnMainPageOrdinaryPriceDecoration = duckData.get("regularPriceDecoration");
        String duckOnMainPageCampaignPrice = duckData.get("campaignPrice");
        String duckOnMainPageCampaignPriceColor = duckData.get("campaignPriceColor");

        //Asserts for MainPage data
        //....

        //It was said to check first duck in Campaign
        mainPage.openParticularDuckDetailsPage(CAMPAIGNS, 0);
        DuckDetailsPage duckDetailsPage = new DuckDetailsPage(myPersonalDriver);

        String duckDetailsPageName = duckDetailsPage.getDuckName();
        String duckDetailsPagePrice = duckDetailsPage.getRegularPrice();
        String duckOnMainPageSailPrice = duckDetailsPage.getCampaignPrice();
        String duckOnMainPageOrdinaryPriceColor = duckOnMainPage.getOrdinaryPriceColor();
        String duckOnMainPageSailPriceColor = duckOnMainPage.getSailPriceColor();

        //Asserts for DuckDetailsPage data
        //....

        //Asserts to compare data on both pages
        //...
                //mainPage.getCampaignDucks().get(0);

    }

    @AfterClass
    public void afterClass() {
        myPersonalDriver.quit();
    }
}

