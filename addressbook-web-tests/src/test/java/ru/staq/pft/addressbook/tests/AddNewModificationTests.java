package ru.staq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;

public class AddNewModificationTests extends TestBase {

  @Test

  public void testAddNewModification()
  {
    app.getAddNewHelper().initAddNewModification();
    app.getAddNewHelper().fillAddNewPage(new AddNewData("Evgeniy", "Aleksandrovich", "Egorov", "egorzhekov", "DPD", "Mosqow", "8-968-982-38-07", "egorzhekov@gmail.com", "1989", null), false);
    app.getAddNewHelper().updateAddNew();

  }
}
