package ru.staq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.GroupDate;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupDate("test1", "test2", "test3"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
