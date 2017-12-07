package ru.staq.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
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
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddNewCreationTests extends TestBase{

  @DataProvider
  public Iterator<Object[]> validAddNewsFromXml() throws IOException {
    try(BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/addnews.xml")))){
      String xml = "";
      String line = reader.readLine();
      while(line != null){
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(AddNewData.class);
      List<AddNewData> addnews  = (List<AddNewData>) xstream.fromXML(xml);
      return addnews.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validAddNewsFromJson() throws IOException {
    try(BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/addnews.json")))){
      String json = "";
      String line = reader.readLine();
      while(line != null){
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<AddNewData> addnews  = gson.fromJson(json, new TypeToken<List<AddNewData>>(){}.getType());  // List<AddNewData>.class
      return addnews.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }


  @Test(dataProvider = "validAddNewsFromJson")
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
