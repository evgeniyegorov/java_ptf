package ru.staq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;

import java.util.List;

public class AddNewDeletionTests extends TestBase {

  @Test

  public void testAddNewDeletion()
  {


    if(! app.getAddNewHelper().isThereAAddNew()){
      app.getNavigationHelper().gotoAddNewPage();
      app.getAddNewHelper().createAddNew(new AddNewData("Evgeniy", "Aleksandrovich", "Egorov", "egorzhekov", "DPD", "Mosqow", "8-968-982-38-07", "egorzhekov@gmail.com", "1989", "test1"), true);

    }
    List<AddNewData> before = app.getAddNewHelper().getAddNewList();
    app.getAddNewHelper().selectAddNew(before.size() -1);
    app.getAddNewHelper().deleteAddNew();
    app.getAddNewHelper().deleteOkAddNew();

    List<AddNewData> after = app.getAddNewHelper().getAddNewList();
    Assert.assertEquals(after, before.size() - 1);

  }
}
