package ru.staq.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.staq.pft.addressbook.appmanager.Applicationmanager;

public class TestBase {

  protected final Applicationmanager app = new Applicationmanager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {

    app.stop();
  }

  public Applicationmanager getApp() {
    return app;
  }
}
