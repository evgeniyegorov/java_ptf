package ru.staq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class AddNewCreationTests extends TestBase{


  @Test
  public void testAddNew() {

    List<AddNewData> before = app.getAddNewHelper().getAddNewList();
    app.getNavigationHelper().gotoAddNewPage();
    AddNewData addnew = new AddNewData("Evgeniy", "Aleksandrovich", "Egorov", "egorzhekov", "DPD", "Mosqow", "8-968-982-38-07", "egorzhekov@gmail.com", "1989", null);
    app.getAddNewHelper().createAddNew(addnew, true);
    List<AddNewData> after = app.getAddNewHelper().getAddNewList();
    Assert.assertEquals(after.size(), before.size() + 1);


    before.add(addnew);
    Comparator<? super AddNewData> byId = (g1 , g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}
