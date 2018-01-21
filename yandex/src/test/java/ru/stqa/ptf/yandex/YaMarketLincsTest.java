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

public class YaMarketLincsTest {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void YaMarketLincsTest() {
        wd.get("https://market.yandex.ru/");
        wd.findElement(By.linkText("Электроника")).click();
        wd.findElement(By.linkText("Компьютеры")).click();
        wd.findElement(By.linkText("Бытовая техника")).click();
        wd.findElement(By.linkText("Детские товары")).click();
        wd.findElement(By.linkText("Зоотовары")).click();
        wd.findElement(By.linkText("Дом, дача, ремонт")).click();
        wd.findElement(By.linkText("Одежда и обувь")).click();
        wd.findElement(By.linkText("Красота и здоровье")).click();
        wd.findElement(By.linkText("Авто")).click();
        wd.findElement(By.linkText("Ещё")).click();
        wd.findElement(By.linkText("Маркет")).click();
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
