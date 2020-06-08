package org.appium;

import framework.PlatformFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {

        PlatformFactory.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {

        PlatformFactory.closeDriver();

    }
}
