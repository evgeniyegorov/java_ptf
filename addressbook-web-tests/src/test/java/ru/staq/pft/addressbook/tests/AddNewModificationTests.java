package ru.staq.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;
import ru.staq.pft.addressbook.model.AddNews;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class AddNewModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsAN()  {
    if(app.addNew().all().size() == 0){
      app.goTo().addNewPage();
      app.addNew().create(new AddNewData().withFirstname("Evgeniy").withMiddlename("Aleksandrovich")
              .withLastname("Egorov").withNickname("egorzhekov").withCompany("DPD").withAddress("Mosqow")
              .withMobile("8-968-982-38-07").withEmail("egorzhekov@gmail.com").withByear("1989"), true);
    }
  }


  @Test

  public void testAddNewModification()
  {
    AddNews before = app.addNew().all();
    AddNewData modifiedAddnew = before.iterator().next();
    AddNewData addnew = new AddNewData().withId(modifiedAddnew.getId()).withFirstname("Evgeniy").withMiddlename("Aleksandrovich")
          .withLastname("Egorov").withNickname("egorzhekov").withCompany("DPD").withAddress("Mosqow")
          .withMobile("8-968-982-38-07").withEmail("egorzhekov@gmail.com").withByear("1989");
    app.addNew().modify(addnew);
    AddNews after = app.addNew().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedAddnew).withAdded(addnew)));
  }
}
