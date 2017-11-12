package ru.staq.pft.addressbook;

import org.testng.annotations.Test;

public class AddNewTests extends TestBase{


  @Test
  public void testAddNew() {

    app.gotoAddNewPage();
    app.fillAddNewPage(new AddNewData("Evgeniy", "Aleksandrovich", "Egorov", "egorzhekov", "DPD", "Mosqow", "8-968-982-38-07", "egorzhekov@gmail.com", "1989"));
    app.submitAddNew();
    app.returnToHomePage();
  }


}
