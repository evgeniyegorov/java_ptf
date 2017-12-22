package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;

public class TestBase {


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

}