package ru.staq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.staq.pft.addressbook.model.AddNewData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

   /* if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(addNewData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }*/

  }

  public void selectAddNew(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteAddNew() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void deleteOkAddNew() {
    wd.switchTo().alert().accept();
  }

  public void initAddNewModification(int index)
  {
    wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr/td[8]/a")).get(index).click();
  }

  public void updateAddNew() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void create(AddNewData addnew, boolean b) {
    fillAddNewPage(addnew, true);
    submitAddNew();
    returnToHomePage();
  }

  public void modify(int index, AddNewData addnew) {
    initAddNewModification(index);
    fillAddNewPage(addnew, false);
    updateAddNew();
  }

  public void delete(int index) {
    selectAddNew(index);
    deleteAddNew();
    deleteOkAddNew();
  }

  public boolean isThereAAddNew() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getAddNewCaunt() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<AddNewData> list() {
    List<AddNewData> addnews = new ArrayList<AddNewData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));  // маожно так еще считать число строк: wd.findElements(By.name("entry"))    By.xpath("//tr[@name='entry']")
    for(WebElement element : elements){
      // List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstname = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      String middlename = element.getText();
      String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      String nickname = element.getText();
      String company = element.getText();
      String address =  element.findElement(By.cssSelector("td:nth-child(4)")).getText();
      String mobile = element.getText();
      String email = element.getText();
      String byear = element.getText();
      String group = element.getText();

      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));

      addnews.add(new AddNewData().withId(id).withFirstname(firstname)
              .withMiddlename(middlename).withLastname(lastname).withNickname(nickname)
              .withCompany(company).withAddress(address).withMobile(mobile).withEmail(email)
              .withByear(byear).withGroup(group));
    }
    return addnews;
  }

  public Set<AddNewData> all() {
    Set<AddNewData> addnews = new HashSet<AddNewData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));  // маожно так еще считать число строк: wd.findElements(By.name("entry"))    By.xpath("//tr[@name='entry']")
    for(WebElement element : elements){
      // List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstname = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      String middlename = element.getText();
      String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      String nickname = element.getText();
      String company = element.getText();
      String address =  element.findElement(By.cssSelector("td:nth-child(4)")).getText();
      String mobile = element.getText();
      String email = element.getText();
      String byear = element.getText();
      String group = element.getText();

      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));

      addnews.add(new AddNewData().withId(id).withFirstname(firstname)
              .withMiddlename(middlename).withLastname(lastname).withNickname(nickname)
              .withCompany(company).withAddress(address).withMobile(mobile).withEmail(email)
              .withByear(byear).withGroup(group));
    }
    return addnews;
  }

}
