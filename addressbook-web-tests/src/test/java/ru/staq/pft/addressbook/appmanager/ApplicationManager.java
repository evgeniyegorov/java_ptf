package ru.staq.pft.addressbook.appmanager;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  FirefoxDriver wd;


  private  SessionHelper sessionHelper;
  private  NavigationHelper navigationHelper;
  private  AddNewHelper addNewHelper;
  private  GroupHelper groupHelper;



  public void init() {
    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(wd);
    addNewHelper = new AddNewHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }



  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public AddNewHelper getAddNewHelper() {
    return addNewHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
