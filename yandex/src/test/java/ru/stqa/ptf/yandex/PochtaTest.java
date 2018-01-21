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

public class PochtaTest {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void PochtaTest() {
        wd.get("https://www.pochta.ru/");
        wd.findElement(By.xpath("//div[@class='main-page__menu']/span/span[1]")).click();
        wd.findElement(By.xpath("//div[@class='balloon--menu__group']//div[.='Индекс']")).click();
        wd.findElement(By.xpath("//div[@class='offices-page__inputs']/div/input")).click();
        wd.findElement(By.xpath("//div[@class='offices-page__inputs']/div/input")).clear();
        wd.findElement(By.xpath("//div[@class='offices-page__inputs']/div/input")).sendKeys("Москва, Гурьянова 23");
        wd.findElement(By.cssSelector("div.input__btn-search")).click();
        wd.findElement(By.cssSelector("div.text-button.index-card__btn-show-office")).click();
        wd.findElement(By.cssSelector("a.header__logo")).click();
        wd.findElement(By.xpath("//div[@class='main-page__menu']/span/span[1]")).click();
        wd.findElement(By.xpath("//div[@class='balloon--menu__group']//div[.='Почта Банк']")).click();
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
