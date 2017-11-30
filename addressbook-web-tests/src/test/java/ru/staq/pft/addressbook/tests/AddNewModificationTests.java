package ru.staq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;

import java.util.Comparator;
import java.util.List;

public class AddNewModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsAN()  {
    if(app.addNew().list().size() == 0){
      app.goTo().addNewPage();
      app.addNew().create(new AddNewData("Evgeniy", "Aleksandrovich", "Egorov", "egorzhekov", "DPD", "Mosqow", "8-968-982-38-07", "egorzhekov@gmail.com", "1989", "test1"), true);
    }
  }

  @Test

  public void testAddNewModification()
  {
    List<AddNewData> before = app.addNew().list();
    int index = before.size() - 1;
    AddNewData addnew = new AddNewData(before.get(index).getId(),"Evgeniy", "Aleksandrovich", "Egorov", "egorzhekov", "DPD", "Mosqow", "8-968-982-38-07", "egorzhekov@gmail.com", "1989", null);
    app.addNew().modify(index, addnew);
    List<AddNewData> after = app.addNew().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(addnew);
    Comparator<? super AddNewData> byId = (g1 ,g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }


}
