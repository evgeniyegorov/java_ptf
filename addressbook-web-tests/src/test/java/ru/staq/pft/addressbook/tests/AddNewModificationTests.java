package ru.staq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class AddNewModificationTests extends TestBase {

  @Test

  public void testAddNewModification()
  {


    if(! app.getAddNewHelper().isThereAAddNew()){
      app.getNavigationHelper().gotoAddNewPage();
      app.getAddNewHelper().createAddNew(new AddNewData("Evgeniy", "Aleksandrovich", "Egorov", "egorzhekov", "DPD", "Mosqow", "8-968-982-38-07", "egorzhekov@gmail.com", "1989", "test1"), true);
    }
    List<AddNewData> before = app.getAddNewHelper().getAddNewList();
    app.getAddNewHelper().initAddNewModification(before.size() - 1);
    AddNewData addnew = new AddNewData(before.get(before.size() - 1).getId(),"Evgeniy", "Aleksandrovich", "Egorov", "egorzhekov", "DPD", "Mosqow", "8-968-982-38-07", "egorzhekov@gmail.com", "1989", null);
    app.getAddNewHelper().fillAddNewPage(addnew, false);
    app.getAddNewHelper().updateAddNew();

    List<AddNewData> after = app.getAddNewHelper().getAddNewList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(addnew);
    Comparator<? super AddNewData> byId = (g1 ,g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }
}
