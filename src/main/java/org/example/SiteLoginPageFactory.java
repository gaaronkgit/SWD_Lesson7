package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SiteLoginPageFactory
{
    private WebDriver driver;

    @FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
    private WebElement singIn;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]")
    private WebElement loginButton;

    public SiteLoginPageFactory(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Login(String login, String password)
    {
        singIn.click();
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
