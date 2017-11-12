package ru.staq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.staq.pft.addressbook.model.AddNewData;

public class AddNewHelper extends HelperBase{


  public AddNewHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitAddNew() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillAddNewPage(AddNewData addNewData) {
    type(By.name("firstname"),addNewData.getFirstname());
    type(By.name("middlename"),addNewData.getMiddlename());
    type(By.name("lastname"),addNewData.getLastname());
    type(By.name("nickname"),addNewData.getNickname());
    type(By.name("company"),addNewData.getCompany());
    type(By.name("address"),addNewData.getAddress());
    type(By.name("mobile"),addNewData.getMobile());
    
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(addNewData.getEmail());
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[16]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[16]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[3]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[3]")).click();
    }
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys(addNewData.getByear());
  }
}
