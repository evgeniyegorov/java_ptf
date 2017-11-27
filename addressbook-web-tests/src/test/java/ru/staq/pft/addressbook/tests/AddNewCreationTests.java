package ru.staq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;

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

    addnew.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(addnew);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }


}
