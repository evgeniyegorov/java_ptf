package ru.staq.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.GroupDate;
import ru.staq.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsG(){
    if(app.db().groups().size() == 0){
      app.goTo().groupPage();
      app.group().create(new GroupDate().withName("test1"));
    }
  }

  @Test

  public void testGroupModification()
  {

    Groups before = app.db().groups();
    GroupDate modifiedGroup = before.iterator().next();
    GroupDate group = new GroupDate()
            .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.goTo().groupPage();
    app.group().modify(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    verifyGroupListInUI();
  }

}
