package ru.staq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

<<<<<<< HEAD
public class NavigationHelper extends HelperBase{


=======
public class NavigationHelper {
 private FirefoxDriver wd;
>>>>>>> parent of 8412d75... Перенес gotoAddNewPage в NavigationHelper. В предыдущем коммите не gotoHomePage a gotoAddNewpage

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }
<<<<<<< HEAD

  public void gotoAddNewPage() {
    click(By.linkText("add new"));
  }
=======
>>>>>>> parent of 8412d75... Перенес gotoAddNewPage в NavigationHelper. В предыдущем коммите не gotoHomePage a gotoAddNewpage
}
