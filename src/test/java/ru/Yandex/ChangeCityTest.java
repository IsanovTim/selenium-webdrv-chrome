package ru.Yandex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChangeCityTest {

    public WebDriver driver;

    @BeforeTest
    public void DwnlDrv() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void ChangeCityTest() {

        driver.get("https://www.yandex.ru/");
        WebElement coutry = driver.findElement(By.className("geolink__reg"));
        coutry.click();
        // WebElement cntr1 = driver.findElement(By.id("city__front-input"));
        WebElement cntr1 = driver.findElement(By.xpath("//input[@id='city__front-input']"));
        cntr1.clear();
        cntr1.sendKeys("Кузнецк" + Keys.ENTER);
        cntr1.sendKeys(Keys.ENTER);
        cntr1.click();
        //System.out.println(cntr1);

    }

    @Test
    public void CheckStartPage (){

        driver.get("https://www.yandex.ru/");

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Яндекс"));

        driver.quit();
    }

}
