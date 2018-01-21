package ru.stqa.ptf.yandex;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class MavicTest {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void MavicTest() {
        wd.get("https://market.yandex.ru/");
        wd.findElement(By.id("header-search")).click();
        wd.findElement(By.id("header-search")).clear();
        wd.findElement(By.id("header-search")).sendKeys("квадрокоптер mavic pro");
        wd.findElement(By.xpath("//span[@class='search2__button']//button[.='Найти']")).click();
        wd.findElement(By.linkText("Квадрокоптер DJI Mavic Pro Combo")).click();
        wd.findElement(By.xpath("//div[@class='n-product-default-offer-cpa2__action']/div/a")).click();
        wd.findElement(By.xpath("//div[@class='offer-purchase__action-buttons']//a[.='Оформить заказ']")).click();
        wd.findElement(By.cssSelector("div.image.image_name_trash")).click();
        wd.findElement(By.linkText("Перейти к выбору товаров")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
