package ru.staq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;
import ru.staq.pft.addressbook.model.AddNews;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddNewCreationTests extends TestBase{


  @Test
  public void testAddNew() {

    AddNews before = app.addNew().all();
    app.goTo().addNewPage();
    AddNewData addnew = new AddNewData().withFirstname("Evgeniy").withMiddlename("Aleksandrovich")
            .withLastname("Egorov").withNickname("egorzhekov").withCompany("DPD").withAddress("Mosqow")
            .withMobile("8-968-982-38-07").withEmail("egorzhekov@gmail.com").withByear("1989");
    app.addNew().create(addnew, true);
    AddNews after = app.addNew().all();
    assertThat(after.size(), equalTo(before.size() + 1));


    assertThat(after, equalTo(
            before.withAdded(addnew.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
