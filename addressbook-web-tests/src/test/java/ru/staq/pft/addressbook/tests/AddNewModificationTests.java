package ru.staq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;

public class AddNewModificationTests extends TestBase {

  @Test

  public void testAddNewModification()
  {
    int before = app.getAddNewHelper().getAddNewCaunt();

    if(! app.getAddNewHelper().isThereAAddNew()){
      app.getNavigationHelper().gotoAddNewPage();
      app.getAddNewHelper().createAddNew(new AddNewData("Evgeniy", "Aleksandrovich", "Egorov", "egorzhekov", "DPD", "Mosqow", "8-968-982-38-07", "egorzhekov@gmail.com", "1989", "test1"), true);
    }
    app.getAddNewHelper().initAddNewModification(before -1);
    app.getAddNewHelper().fillAddNewPage(new AddNewData("Evgeniy", "Aleksandrovich", "Egorov", "egorzhekov", "DPD", "Mosqow", "8-968-982-38-07", "egorzhekov@gmail.com", "1989", null), false);
    app.getAddNewHelper().updateAddNew();

    int after = app.getAddNewHelper().getAddNewCaunt();
    Assert.assertEquals(after, before );

  }
}
