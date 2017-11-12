package ru.staq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.staq.pft.addressbook.model.GroupDate;

public class GroupHelper extends HelperBase {
 private FirefoxDriver wd;

  public GroupHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  private void click(By locator) {
    wd.findElement(locator).click();
  }

  public void fillGroupForm(GroupDate groupDate) {
    type(By.name("group_name"), groupDate.getName());
    type(By.name("group_header"), groupDate.getHeader());
    type(By.name("group_footer"), groupDate.getFooter());
  }

  private void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void initGroupCreation() {
    click(By.xpath("//div[@id='content']/form/input[4]"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }
}
