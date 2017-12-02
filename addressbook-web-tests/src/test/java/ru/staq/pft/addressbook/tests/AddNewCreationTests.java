package ru.staq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class AddNewCreationTests extends TestBase{


  @Test
  public void testAddNew() {

    Set<AddNewData> before = app.addNew().all();
    app.goTo().addNewPage();
    AddNewData addnew = new AddNewData().withFirstname("Evgeniy").withMiddlename("Aleksandrovich")
            .withLastname("Egorov").withNickname("egorzhekov").withCompany("DPD").withAddress("Mosqow")
            .withMobile("8-968-982-38-07").withEmail("egorzhekov@gmail.com").withByear("1989");
    app.addNew().create(addnew, true);
    Set<AddNewData> after = app.addNew().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    addnew.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(addnew);
    Assert.assertEquals(before, after);
  }


}
