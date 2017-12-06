package ru.staq.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;
import ru.staq.pft.addressbook.model.AddNews;
import ru.staq.pft.addressbook.model.GroupDate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddNewCreationTests extends TestBase{

  @DataProvider
  public Iterator<Object[]> validAddNews() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/addnews.csv")));
    String line = reader.readLine();
    while(line != null){
      String[] split = line.split(";");
      list.add(new Object[] {new AddNewData().withFirstname(split[0]).withMiddlename(split[1])
              .withLastname(split[2]).withNickname(split[3]).withCompany(split[4]).withAddress(split[5])
              .withMobilePhone(split[6]).withEmail(split[7]).withByear(split[8])
              .withGroup(split[9])});
      line = reader.readLine();
    }
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
