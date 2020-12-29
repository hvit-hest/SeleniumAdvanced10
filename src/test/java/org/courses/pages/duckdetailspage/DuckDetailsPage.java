package org.courses.pages.duckdetailspage;

import org.courses.pages.duckdetailspage.components.DuckDetailsSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DuckDetailsPage {
    private WebDriver driverHere;

    @FindBy(css = "h1.title")
    private WebElement pageHeader;


    public DuckDetailsPage(WebDriver mePersonalDriver) {
        this.driverHere = mePersonalDriver;
        PageFactory.initElements(driverHere, this);
    }

    public String getPageName() {
        return pageHeader.getText();
    }

    public String getDuckName() {
        return getPageName();
    }

    public DuckDetailsSection getDuckDetailsSection() {
        return new DuckDetailsSection(driverHere.findElement(By.cssSelector("#box-product")));
    }

    /*@FindBy(css = "#box-product.box .regular-price, #box-product.box .price")
    private WebElement regularPriceWE;

    *//*It could be absent so we are using the list to escape exception and only first element will be taken
    to get data*//*
    @FindBy(css = "#box-product.box .campaign-price")
    private List<WebElement> campaignPriceWEs;


    public String getRegularPrice() {
        return regularPriceWE.getText();
    }

    public String getRegularPriceColor() {
        return regularPriceWE.getCssValue("color");
    }

    public String getRegularPriceDecoration() {
        return regularPriceWE.getCssValue("text-decoration");
    }

    public String getCampaignPriceWE() {

    }*/
}
