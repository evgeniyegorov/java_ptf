package ru.staq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Applicationmanager {

  private final HelperBase helperBase = new HelperBase();

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void init() {
    helperBase.wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    helperBase.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    helperBase.wd.get("http://localhost/addressbook/");

    login("admin", "secret");
  }

  private void login(String username, String password) {
    helperBase.wd.findElement(By.name("user")).click();
    helperBase.wd.findElement(By.name("user")).clear();
    helperBase.wd.findElement(By.name("user")).sendKeys(username);
    helperBase.wd.findElement(By.name("pass")).click();
    helperBase.wd.findElement(By.name("pass")).clear();
    helperBase.wd.findElement(By.name("pass")).sendKeys(password);
    helperBase.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();

  }

  public void gotoGroupPage() {
    helperBase.wd.findElement(By.linkText("groups")).click();
  }

  public void stop() {
    helperBase.wd.quit();
  }

  public void gotoAddNewPage() {
    helperBase.wd.findElement(By.linkText("add new")).click();
  }

  public HelperBase getHelperBase() {
    return helperBase;
  }
}
