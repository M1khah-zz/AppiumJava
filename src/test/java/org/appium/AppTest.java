package org.appium;


import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class AppTest 
{

    public void dialogueModalTest() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("settings[enableMultiWindows]", true);
        capabilities.setCapability("app", "/Users/kirill/Downloads/ApiDemos-debug.apk");
        capabilities.setCapability("autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        MobileElement appElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("App"));
        appElement.click();

        MobileElement alertDialogsElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Alert Dialogs"));
        alertDialogsElement.click();

        MobileElement firstAlertElement = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/two_buttons"));
        firstAlertElement.click();

        MobileElement alertMessageElement = (MobileElement) driver.findElement(MobileBy.id("android:id/alertTitle"));
        String alertMessageText = alertMessageElement.getText();
        String correctMessageText = "Lorem ipsum dolor sit aie consectetur adipiscing Plloaso mako nuto siwuf cakso dodtos anr koop.";

        assertThat(alertMessageText, is(correctMessageText));

        driver.quit();

    }

    @Test
    public void contextMenuTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("settings[enableMultiWindows]", true);
        capabilities.setCapability("app", "/Users/kirill/Downloads/ApiDemos-debug.apk");
        capabilities.setCapability("autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        MobileElement appElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("App"));
        appElement.click();

        MobileElement fragmentlement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Fragment"));
        fragmentlement.click();

        MobileElement contextMenuElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Context Menu"));
        contextMenuElement.click();


        MobileElement longPressButton = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/long_press"));
        TouchActions action = new TouchActions(driver);
        action.longPress(longPressButton);
        action.perform();

        List<MobileElement> contextMenus = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
        contextMenus.get(0).click();
        String successToastText = driver.findElementByAccessibilityId("\tandroid.widget.Toast").getText();
        String validSuccessToastText = "Item 1a was chosen";
        assertThat(successToastText, equalTo(validSuccessToastText));

        driver.quit();
    }

}
