package ru.staq.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.AddNewData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddNewAddressTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsAN()  {
    if(app.addNew().all().size() == 0){
      app.goTo().addNewPage();
      app.addNew().create(new AddNewData().withFirstname("Evgeniy").withMiddlename("Aleksandrovich")
              .withLastname("Egorov").withNickname("egorzhekov").withCompany("DPD").withAddress("Mosqow")
              .withMobilePhone("8-968-982-38-07").withEmail("egorzhekov@gmail.com").withByear("1989"), true);
    }
  }

  @Test
  public void testAddNewAddress() {
    AddNewData addnew = app.addNew().all().iterator().next();
    AddNewData addnewtInfoFromEditForm = app.addNew().infoFromEditForm(addnew);

    assertThat(addnew.getAddress(), equalTo(mergeAddress(addnewtInfoFromEditForm)));
  }

  private String mergeAddress(AddNewData addnew) {
    return Arrays.asList(addnew.getAddress())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }
}
