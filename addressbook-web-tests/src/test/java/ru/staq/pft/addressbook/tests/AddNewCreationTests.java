package ru.staq.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;
import ru.staq.pft.addressbook.model.AddNews;
import ru.staq.pft.addressbook.model.GroupDate;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddNewCreationTests extends TestBase{

  @DataProvider
  public Iterator<Object[]> validAddNews() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new AddNewData().withFirstname("Evgeniy").withMiddlename("Aleksandrovich")
            .withLastname("Egorov").withNickname("egorzhekov").withCompany("DPD").withAddress("Mosqow")
            .withMobilePhone("8-968-982-38-07").withEmail("egorzhekov@gmail.com").withByear("1989")
            .withGroup("test1")});
    list.add(new Object[] {new AddNewData().withFirstname("Evgeniy").withMiddlename("Aleksandrovich")
            .withLastname("Egorov").withNickname("egorzhekov").withCompany("DPD").withAddress("Mosqow")
            .withMobilePhone("8-968-982-38-07").withEmail("egorzhekov@gmail.com").withByear("1989")
            .withGroup("test1")});
    list.add(new Object[] {new AddNewData().withFirstname("Evgeniy").withMiddlename("Aleksandrovich")
            .withLastname("Egorov").withNickname("egorzhekov").withCompany("DPD").withAddress("Mosqow")
            .withMobilePhone("8-968-982-38-07").withEmail("egorzhekov@gmail.com").withByear("1989")
            .withGroup("test1")});
    return list.iterator();
  }


  @Test(dataProvider = "validAddNews")
  public void testAddNew(AddNewData addnew) {
    AddNews before = app.addNew().all();
    app.goTo().addNewPage();
    File photo = new File("src/test/resources/stru.png");
    app.addNew().create(addnew, true);
    assertThat(app.addNew().count(), equalTo(before.size() + 1));
    AddNews after = app.addNew().all();
    assertThat(after, equalTo(
            before.withAdded(addnew.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadAddNew() {
    AddNews before = app.addNew().all();
    app.goTo().addNewPage();
    AddNewData addnew = new AddNewData().withFirstname("Evgeniy'").withMiddlename("Aleksandrovich")
            .withLastname("Egorov").withNickname("egorzhekov").withCompany("DPD").withAddress("Mosqow")
            .withMobilePhone("8-968-982-38-07").withEmail("egorzhekov@gmail.com").withByear("1989");
    app.addNew().create(addnew, true);
    assertThat(app.addNew().count(), equalTo(before.size()));
    AddNews after = app.addNew().all();
    assertThat(after, equalTo(before));
  }
  
}
