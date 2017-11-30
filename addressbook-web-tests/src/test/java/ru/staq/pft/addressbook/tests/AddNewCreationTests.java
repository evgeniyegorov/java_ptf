package ru.staq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;

import java.util.Comparator;
import java.util.List;

public class AddNewCreationTests extends TestBase{


  @Test
  public void testAddNew() {

    List<AddNewData> before = app.addNew().list();
    app.goTo().addNewPage();
    AddNewData addnew = new AddNewData().withFirstname("Evgeniy").withMiddlename("Aleksandrovich")
            .withLastname("Egorov").withNickname("egorzhekov").withCompany("DPD").withAddress("Mosqow")
            .withMobile("8-968-982-38-07").withEmail("egorzhekov@gmail.com").withByear("1989");
    app.addNew().create(addnew, true);
    List<AddNewData> after = app.addNew().list();
    Assert.assertEquals(after.size(), before.size() + 1);


    before.add(addnew);
    Comparator<? super AddNewData> byId = (g1 , g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}
