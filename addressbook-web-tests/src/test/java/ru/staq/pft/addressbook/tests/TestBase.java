package ru.staq.pft.addressbook.tests;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.staq.pft.addressbook.appmanager.ApplicationManager;
import ru.staq.pft.addressbook.model.AddNewData;
import ru.staq.pft.addressbook.model.AddNews;
import ru.staq.pft.addressbook.model.GroupDate;
import ru.staq.pft.addressbook.model.Groups;
import sun.plugin2.util.BrowserType;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", org.openqa.selenium.remote.BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown()
  {
    app.stop();
  }

  public ApplicationManager getApp() {
    return app;
  }

  @BeforeMethod (alwaysRun = true)
  public void logTestStart(Method m, Object[] p){
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
  }

  @AfterMethod (alwaysRun = true)
  public void logTestStop(Method m){
    logger.info("Stop test " + m.getName());
  }


  public void verifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupDate().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }
  }

  public void verifyAddNewListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      AddNews dbAddnews = app.db().addnews();
      AddNews uiAddnews = app.addNew().all();
      assertThat(uiAddnews, equalTo(dbAddnews.stream()
              .map((g) -> new AddNewData().withId(g.getId()).withFirstname(g.getFirstname()).withLastname(g.getLastname()))
              .collect(Collectors.toSet())));

    }
  }
}
