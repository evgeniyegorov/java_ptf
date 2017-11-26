package ru.staq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;

import java.util.List;

public class AddNewCreationTests extends TestBase{


  @Test
  public void testAddNew() {

    List<AddNewData> before = app.getAddNewHelper().getAddNewList();
    app.getNavigationHelper().gotoAddNewPage();
    app.getAddNewHelper().createAddNew(new AddNewData("Evgeniy", "Aleksandrovich", "Egorov", "egorzhekov", "DPD", "Mosqow", "8-968-982-38-07", "egorzhekov@gmail.com", "1989", "test1"), true);
    List<AddNewData> after = app.getAddNewHelper().getAddNewList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }


}
