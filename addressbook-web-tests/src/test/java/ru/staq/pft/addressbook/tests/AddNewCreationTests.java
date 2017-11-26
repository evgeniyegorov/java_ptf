package ru.staq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;

public class AddNewCreationTests extends TestBase{


  @Test
  public void testAddNew() {

    int before = app.getAddNewHelper().getAddNewCaunt();
    app.getNavigationHelper().gotoAddNewPage();
    app.getAddNewHelper().createAddNew(new AddNewData("Evgeniy", "Aleksandrovich", "Egorov", "egorzhekov", "DPD", "Mosqow", "8-968-982-38-07", "egorzhekov@gmail.com", "1989", "test1"), true);
    int after = app.getAddNewHelper().getAddNewCaunt();
    Assert.assertEquals(after, before + 1);
  }


}
