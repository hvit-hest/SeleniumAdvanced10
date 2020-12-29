package org.courses.pages.duckdetailspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DuckDetailsPage {
    private WebDriver driverHere;

    @FindBy(css = "h1.title")
    private WebElement pageHeader;

    @FindBy(css = "#box-product.box .regular-price, #box-product.box .price")
    private WebElement regularPriceWE;

    @FindBy(css = "#box-product.box .campaign-price")
    private List<WebElement> campaignPriceWEs;

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
    

}
