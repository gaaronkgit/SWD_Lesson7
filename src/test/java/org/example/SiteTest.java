package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SiteTest
{
    static WebDriver driver;

    @BeforeEach
    public void PrepareDriver()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    @Epic("Тестирование сайта http://automationpractice.com/index.php")
    @DisplayName("Тестирование входа на сайт")
    @Feature("Вход на сайт")
    @Step("Вход на саайт с логином: gaaronk8325@gmail.com и паролем: qwerty123456")
    void LoginTest()
    {
        SiteLoginPageFactory siteLoginPageFactory = new SiteLoginPageFactory(driver);

        siteLoginPageFactory.Login("gaaronk8325@gmail.com","qwerty123456");

        List<WebElement> lstElm = driver.findElements(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));

        Assertions.assertEquals("Stepan Ivanov", lstElm.get(0).getText(), "Вход на сайт не удался! Тест провален!");

    }

    @Test
    @Epic("Тестирование сайта http://automationpractice.com/index.php")
    @Feature("Поииск товара Blouse")
    @DisplayName("Тестирование поиска")
    void SearchBlouseTest()
    {
        SiteSearchPageFactory siteSearchPageFactory = new SiteSearchPageFactory(driver);
        siteSearchPageFactory.Search("Blouse");
        Assertions.assertEquals("Blouse",
                driver.findElement(By.cssSelector("#center_column > ul > li > div > div.right-block > h5 > a")).getText()
                ,"Тест не пройден!");
    }

    @Test
    @Epic("Тестирование сайта http://automationpractice.com/index.php")
    @Feature("Навигация по сайту")
    @DisplayName("Тестирование перехода к футболкам")
    void NavigateToTShirtTest()
    {
        SiteTShirtPageFactory siteTShirtPageFactory = new SiteTShirtPageFactory(driver);
        siteTShirtPageFactory.NavigateToTShirt();

        Assertions.assertEquals("T-SHIRTS "
                , driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getText()
                ,"Футболка не найдена! Тест не пройден!");
    }

    @Test
    @Epic("Тестирование сайта http://automationpractice.com/index.php")
    @Feature("Добавление товара в корзину")
    @DisplayName("Тестирование добавления товара в корзину")
    void AddToCartTest()
    {
        SiteLoginPageFactory siteLoginPageFactory = new SiteLoginPageFactory(driver);
        siteLoginPageFactory.Login("gaaronk8325@gmail.com","qwerty123456");

        SiteCartPageFactory siteCartPageFactory = new SiteCartPageFactory(driver);
        siteCartPageFactory.AddGoodToCart();

        Assertions.assertEquals("Printed Summer Dress",
                driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[2]/p/a")).getText(),
                "Товар не найден в корзине! Тест AddToCartTest провален");
    }

    @AfterEach
    public void CleanUp()
    {
        driver.quit();
    }
}
