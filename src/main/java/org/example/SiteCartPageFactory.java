package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SiteCartPageFactory
{
    WebDriver driver;
    public SiteCartPageFactory(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    WebElement womanButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[6]/div/div[1]/div/a[1]/img")
    WebElement good;

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
    WebElement addButton;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/span")
    WebElement closeWidowCart;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    WebElement cartButton;

    void AddGoodToCart()
    {
        womanButton.click();
        good.click();
        addButton.click();
        closeWidowCart.click();
        cartButton.click();
    }
}
