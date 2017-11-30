package ru.staq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;

import java.util.List;

public class AddNewDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsAN()  {
    if(app.addNew().list().size() == 0){
      app.goTo().addNewPage();
      app.addNew().create(new AddNewData("Evgeniy", "Aleksandrovich", "Egorov", "egorzhekov", "DPD", "Mosqow", "8-968-982-38-07", "egorzhekov@gmail.com", "1989", "test1"), true);
    }
  }

  @Test

  public void testAddNewDeletion()
  {
    List<AddNewData> before = app.addNew().list();
    int index = before.size() -1;
    app.addNew().delete(index);
    List<AddNewData> after = app.addNew().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }

}
