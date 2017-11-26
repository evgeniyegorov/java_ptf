package ru.staq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.staq.pft.addressbook.model.AddNewData;

public class AddNewHelper extends  HelperBase{


  public AddNewHelper(WebDriver wd) {
   super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitAddNew() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillAddNewPage(AddNewData addNewData, boolean creation) {
    type(By.name("firstname"),addNewData.getFirstname());
    type(By.name("middlename"),addNewData.getMiddlename());
    type(By.name("lastname"),addNewData.getLastname());
    type(By.name("nickname"),addNewData.getNickname());
    type(By.name("company"),addNewData.getCompany());
    type(By.name("address"),addNewData.getAddress());
    type(By.name("mobile"),addNewData.getMobile());
    type(By.name("email"),addNewData.getEmail());

    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[16]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[1]//option[16]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[3]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[3]"));
    }
    type(By.name("byear"),addNewData.getByear());

    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(addNewData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void selectAddNew() {
    click(By.name("selected[]"));
  }

  public void deleteAddNew() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void deleteOkAddNew() {
    wd.switchTo().alert().accept();
  }

  public void initAddNewModification()
  {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void updateAddNew() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void createAddNew(AddNewData addnew, boolean b) {
    fillAddNewPage(addnew, true);
    submitAddNew();
    returnToHomePage();
  }

  public boolean isThereAAddNew() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getAddNewCaunt() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
