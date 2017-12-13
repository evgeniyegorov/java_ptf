package ru.staq.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;
import ru.staq.pft.addressbook.model.AddNews;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddNewModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditionsAN()  {
    if(app.db().addnews().size() == 0){
      app.goTo().addNewPage();
      app.addNew().create(new AddNewData().withFirstname("Evgeniy").withMiddlename("Aleksandrovich")
              .withLastname("Egorov").withNickname("egorzhekov").withCompany("DPD").withAddress("Mosqow")
              .withMobilePhone("8-968-982-38-07").withEmail("egorzhekov@gmail.com").withByear("1989"), true);
    }
  }
  @Test
  public void testAddNewModification()
  {
    AddNews before = app.db().addnews();
    AddNewData modifiedAddnew = before.iterator().next();
    AddNewData addnew = new AddNewData().withId(modifiedAddnew.getId()).withFirstname("Evgeniy").withMiddlename("Aleksandrovich")
          .withLastname("Egorov").withNickname("egorzhekov").withCompany("DPD").withAddress("Mosqow")
          .withMobilePhone("8-968-982-38-07").withEmail("egorzhekov@gmail.com").withByear("1989");
    app.addNew().modify(addnew);
    assertThat(app.addNew().count(), equalTo(before.size()));
    AddNews after = app.db().addnews();
    assertThat(after, equalTo(before.without(modifiedAddnew).withAdded(addnew)));
  }
}
