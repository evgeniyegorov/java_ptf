package ru.staq.pft.addressbook.tests;

import org.testng.annotations.Test;

public class AddNewDeletionTests extends TestBase {

  @Test

  public void testAddNewDeletion()
  {
    app.getAddNewHelper().selectAddNew();
    app.getAddNewHelper().deleteAddNew();
    app.getAddNewHelper().deleteOkAddNew();

  }
}
