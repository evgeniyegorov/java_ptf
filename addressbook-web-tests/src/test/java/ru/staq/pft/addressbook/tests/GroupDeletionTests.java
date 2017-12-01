package ru.staq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.staq.pft.addressbook.model.GroupDate;

import java.util.List;
import java.util.Set;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditionsG(){
        app.goTo().groupPage();
        if (app.group().list().size() == 0){
            app.group().create(new GroupDate().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletion() {

        Set<GroupDate> before = app.group().all();
        GroupDate deleteGroup = before.iterator().next();
        app.group().delete(deleteGroup);
        Set<GroupDate> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deleteGroup);
        Assert.assertEquals(before, after);


    }



}
