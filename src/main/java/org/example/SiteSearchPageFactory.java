package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SiteSearchPageFactory
{
    WebDriver driver;
    public SiteSearchPageFactory(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"search_query_top\"]")
    WebElement searchField;

    @FindBy(xpath = "//*[@id=\"searchbox\"]/button")
    WebElement searchButton;

    void Search(String text)
    {
        searchField.sendKeys(text);
        searchButton.click();
    }
}
