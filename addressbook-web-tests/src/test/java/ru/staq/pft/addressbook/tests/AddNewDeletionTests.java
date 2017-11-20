package ru.staq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;

public class AddNewDeletionTests extends TestBase {

  @Test

  public void testAddNewDeletion()
  {
    if(! app.getAddNewHelper().isThereAAddNew()){
      app.getNavigationHelper().gotoAddNewPage();
      app.getAddNewHelper().createAddNew(new AddNewData("Evgeniy", "Aleksandrovich", "Egorov", "egorzhekov", "DPD", "Mosqow", "8-968-982-38-07", "egorzhekov@gmail.com", "1989", "test1"), true);

    }
    app.getAddNewHelper().selectAddNew();
    app.getAddNewHelper().deleteAddNew();
    app.getAddNewHelper().deleteOkAddNew();

  }
}
