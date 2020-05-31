package org.appium;


import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class AppTest 
{

    @Test
    @Description("Test modal dialogue")
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
    @Description("Test context menu")
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

    @Test
    @Description("Inflate from XML test")
    public void inflateFromXml() throws MalformedURLException {

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

        MobileElement menulement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Menu"));
        menulement.click();

        MobileElement inflateElement = (MobileElement) driver.findElement(MobileBy.id("android:id/text1"));
        inflateElement.click();

        MobileElement spinnerElement = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/spinner"));
        spinnerElement.click();

        List<MobileElement> menuElements = (List<MobileElement>) driver.findElementsByClassName("android.widget.CheckedTextView");
        menuElements.get(1).click();
        String selectedMenuText =  menuElements.get(1).getText();;
        String validMenuText = "Title and Icon";
        assertThat(selectedMenuText, equalTo(validMenuText));

        driver.quit();
    }

    @Test
    @Description("Hide and show test")
    public void hideShowTest() throws MalformedURLException {

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

        MobileElement menulement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Menu"));
        menulement.click();

        MobileElement fragmentlement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Fragment"));
        fragmentlement.click();

        MobileElement hideAndShowElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Hide and Show"));
        hideAndShowElement.click();

        MobileElement fragment1 = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/fragment1"));
        MobileElement fragment2 = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/fragment2"));
        MobileElement hideFrag1Button = (MobileElement) driver.findElement(MobileBy.id("\tio.appium.android.apis:id/frag1hide"));
        MobileElement hideFrag2Button = (MobileElement) driver.findElement(MobileBy.id("\tio.appium.android.apis:id/frag2hide"));

        hideFrag1Button.click();
        assertThat(fragment1, is(nullValue()));
        hideFrag2Button.click();
        assertThat(fragment2, is(nullValue()));
        hideFrag1Button.click();
        assertThat(fragment1, is(notNullValue()));
        hideFrag2Button.click();
        assertThat(fragment2, is(notNullValue()));

        driver.quit();
    }

    @Test
    @Description("Chronometer test")
    public void chronometerTest() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("settings[enableMultiWindows]", true);
        capabilities.setCapability("app", "/Users/kirill/Downloads/ApiDemos-debug.apk");
        capabilities.setCapability("autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        MobileElement viewsElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Views"));
        viewsElement.click();

        MobileElement chronometerElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Chronometer"));
        chronometerElement.click();

        MobileElement startButton = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/start"));
        MobileElement stopButton = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/stop"));
        MobileElement resetButton = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/reset"));
        MobileElement setFormatButton = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/set_format"));
        MobileElement clearFormatButton = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/clear_format"));
        MobileElement chronometer = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/chronometer"));

        assertThat(chronometer.getText(), equalTo("Initial format: 00:00"));
        setFormatButton.click();
        startButton.click();
        stopButton.click();
        assertThat(chronometer.getText(), containsString("Formatted time"));
        clearFormatButton.click();
        startButton.click();
        stopButton.click();
        assertThat(chronometer.getText(), not(containsString("Formatted time")));
        resetButton.click();
        assertThat(chronometer.getText(),is("00:00"));

        driver.quit();
    }

    @Test
    @Description("Holo theme test")
    public void holoThemeTest() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("settings[enableMultiWindows]", true);
        capabilities.setCapability("app", "/Users/kirill/Downloads/ApiDemos-debug.apk");
        capabilities.setCapability("autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        MobileElement viewsElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Views"));
        viewsElement.click();

        MobileElement controlsElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Controls"));
        controlsElement.click();

        MobileElement firstCheckbox = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/check1"));
        MobileElement secondCheckbox = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/check2"));
        MobileElement radioButton1 = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/radio1"));
        MobileElement radioButton2 = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/radio2"));
        MobileElement starButton = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/star"));
        MobileElement toggleButton1 = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/toggle1"));
        MobileElement toggleButton2 = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/toggle2"));
        MobileElement themeTitle = (MobileElement) driver.findElement(MobileBy.id("android:id/title"));
        List<MobileElement> themesList = (List<MobileElement>) driver.findElements(MobileBy.className("android.widget.TextView"));

        themesList.get(4).click();
        assertThat(themeTitle.getText(), containsString("Custom"));
        firstCheckbox.click();
        secondCheckbox.click();
        radioButton1.click();
        radioButton2.click();
        starButton.click();
        toggleButton1.click();
        toggleButton2.click();

        assertThat(firstCheckbox.getCssValue("checked"), is(true));
        assertThat(secondCheckbox.getCssValue("checked"), is(true));
        assertThat(radioButton1.getCssValue("checked"), is(false));
        assertThat(radioButton2.getCssValue("checked"), is(true));
        assertThat(starButton.getCssValue("checked"), is(true));
        assertThat(toggleButton1.getCssValue("checked"), is(true));
        assertThat(toggleButton2.getCssValue("checked"), is(true));

        driver.quit();
    }

    @Test
    @Description("Drag and drop test")
    public void dndTest() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("settings[enableMultiWindows]", true);
        capabilities.setCapability("app", "/Users/kirill/Downloads/ApiDemos-debug.apk");
        capabilities.setCapability("autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        MobileElement viewsElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Views"));
        viewsElement.click();

        MobileElement dndElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Drag and Drop"));
        dndElement.click();

        MobileElement dragDot1 = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
        MobileElement dragDot2 = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));
        MobileElement dragResult = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_result_text"));
        String dragResultText = dragResult.getText();

        TouchAction drag = new TouchAction(driver);
        drag.longPress(PointOption.point(dragDot1.getLocation()))
                .moveTo(PointOption.point(dragDot2.getLocation()))
                .perform()
                .release();
        assertThat(dragResultText, is("Dropped!"));

        driver.quit();
    }

    @Test
    @Description("Animation test")
    public void animationTest() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("settings[enableMultiWindows]", true);
        capabilities.setCapability("app", "/Users/kirill/Downloads/ApiDemos-debug.apk");
        capabilities.setCapability("autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        MobileElement viewsElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Views"));
        viewsElement.click();

        new TouchAction(driver).press(PointOption.point(550, 640)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();

        MobileElement layoutAnimationElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Layout Animation"));
        layoutAnimationElement.click();

        MobileElement gridFade = (MobileElement) driver.findElement(MobileBy.AccessibilityId("1. Grid Fade"));
        gridFade.click();

        List<MobileElement> gridElements = (List<MobileElement>) driver.findElements(MobileBy.className("android.widget.ImageView"));

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.className("android.widget.ImageView")));

        assertThat(gridElements, is(notNullValue()));

        driver.quit();
    }

    

}
