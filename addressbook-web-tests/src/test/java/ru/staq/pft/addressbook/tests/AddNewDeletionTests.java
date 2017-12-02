package ru.staq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;

import java.util.List;
import java.util.Set;

public class AddNewDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsAN()  {
    if(app.addNew().list().size() == 0){
      app.goTo().addNewPage();
      app.addNew().create(new AddNewData().withFirstname("Evgeniy").withMiddlename("Aleksandrovich")
              .withLastname("Egorov").withNickname("egorzhekov").withCompany("DPD").withAddress("Mosqow")
              .withMobile("8-968-982-38-07").withEmail("egorzhekov@gmail.com").withByear("1989"), true);
    }
  }

  @Test

  public void testAddNewDeletion()
  {
    Set<AddNewData> before = app.addNew().all();
    AddNewData deletedAddnew = before.iterator().next();
    app.addNew().delete(deletedAddnew);
    Set<AddNewData> after = app.addNew().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedAddnew);
    Assert.assertEquals(before, after);
  }

}
