package ru.staq.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.gotoGroupPage();
        app.getHelperBase().selectGroup();
        app.getHelperBase().deleteSelectedGroups();
        app.getHelperBase().returnToGroupPage();
    }

}
