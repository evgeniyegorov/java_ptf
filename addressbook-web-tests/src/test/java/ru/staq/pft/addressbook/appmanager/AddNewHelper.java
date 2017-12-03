package ru.staq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.staq.pft.addressbook.model.AddNewData;
import ru.staq.pft.addressbook.model.AddNews;
import java.util.List;


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
    type(By.name("mobile"),addNewData.getMobilePhone());
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


  public void selectAddNewById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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
    addnewCache = null;
    returnToHomePage();
  }

  public void modify(AddNewData addnew) {
    initAddNewModificationById(addnew.getId());
    fillAddNewPage(addnew, false);
    updateAddNew();
    addnewCache = null;
  }

  public void delete(AddNewData addnew) {
    selectAddNewById(addnew.getId());
    deleteAddNew();
    addnewCache = null;
    deleteOkAddNew();
  }

  public boolean isThereAAddNew() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private AddNews addnewCache = null;

  public AddNews all() {
    if (addnewCache != null) {
      return new AddNews(addnewCache);
    }
    addnewCache = new AddNews();
    List<WebElement> rows = wd.findElements(By.xpath("//tr[@name='entry']"));  // маожно так еще считать число строк: wd.findElements(By.name("entry"))    By.xpath("//tr[@name='entry']")
    for(WebElement row : rows){
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String AllMails = cells.get(4).getText();
      String AllPhones = cells.get(5).getText();

      addnewCache.add(new AddNewData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAllMails(AllMails)
              .withAllPhones(AllPhones));
    }
    return new AddNews(addnewCache);
  }
  public void initAddNewModificationById(int id)
  {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

//    wd.findElement(By.xpath(String.format("//table[@id='maintable']/tbody/tr/td[8]/a", id))).click();
  }

  public AddNewData infoFromEditForm(AddNewData addnew) {
    initAddNewModificationById(addnew.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname  = wd.findElement(By.name("lastname")).getAttribute("value");
    String home      = wd.findElement(By.name("home")).getAttribute("value");
    String mobile    = wd.findElement(By.name("mobile")).getAttribute("value");
    String work      = wd.findElement(By.name("work")).getAttribute("value");
    String email     = wd.findElement(By.name("email")).getAttribute("value");
    String email2    = wd.findElement(By.name("email2")).getAttribute("value");
    String email3    = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new AddNewData().withId(addnew.getId()).withFirstname(firstname)
            .withLastname(lastname).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
            .withEmail(email).withEmail2(email2).withEmail3(email3);
  }


}
