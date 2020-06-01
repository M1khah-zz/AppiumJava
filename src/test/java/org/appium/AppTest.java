package org.appium;


import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
        String correctMessageText = "Lorem ipsum dolor sit aie consectetur adipiscingnn";

        assertThat(alertMessageText, containsString(correctMessageText));

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
    public void inflateFromXml() throws MalformedURLException, InterruptedException {

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

        String clickedText = menuElements.get(1).getText();
        menuElements.get(1).click();
        MobileElement textAfter = (MobileElement) driver.findElement(MobileBy.id("android:id/text1"));
        assertThat(textAfter.getText(), equalTo(clickedText));

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

        MobileElement fragmentlement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Fragment"));
        fragmentlement.click();

        MobileElement hideAndShowElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Hide and Show"));
        hideAndShowElement.click();

        MobileElement fragment1 = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/fragment1"));
        MobileElement fragment2 = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/fragment2"));
        MobileElement hideFrag1Button = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/frag1hide"));
        MobileElement hideFrag2Button = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/frag2hide"));

        hideFrag1Button.click();
        assertThat(fragment1, is(null));
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


        List<MobileElement> themesList = (List<MobileElement>) driver.findElements(MobileBy.className("android.widget.TextView"));

        themesList.get(5).click();
//        MobileElement firstCheckbox = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/check1"));
//        MobileElement secondCheckbox = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/check2"));
//        MobileElement radioButton1 = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/radio1"));
//        MobileElement radioButton2 = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/radio2"));
//        MobileElement starButton = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/star"));
//        MobileElement toggleButton1 = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/toggle1"));
//        MobileElement toggleButton2 = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/toggle2"));
        MobileElement themeTitle = (MobileElement) driver.findElement(MobileBy.id("android:id/action_bar_title"));
        assertThat(themeTitle.getText(), containsString("Holo"));
//        firstCheckbox.click();
//        secondCheckbox.click();
//        radioButton1.click();
//        radioButton2.click();
//        starButton.click();
//        toggleButton1.click();
//        toggleButton2.click();
//
//        assertThat(firstCheckbox.getCssValue("checked"), equalTo("true"));
//        assertThat(secondCheckbox.getCssValue("checked"), equalTo("true"));
//        assertThat(radioButton1.getCssValue("checked"), equalTo("false"));
//        assertThat(radioButton2.getCssValue("checked"), equalTo("true"));
//        assertThat(starButton.getCssValue("checked"), equalTo("true"));
//        assertThat(toggleButton1.getCssValue("checked"), equalTo("true"));
//        assertThat(toggleButton2.getCssValue("checked"), equalTo("true"));

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

    @Test
    @Description("Content by Intent test")
    public void contentByIntentTest() throws MalformedURLException {

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


        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();
        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();
        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();

        MobileElement tabsElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Tabs"));
        tabsElement.click();

        MobileElement contentByIntent = (MobileElement) driver.findElement(MobileBy.AccessibilityId("3. Content By Intent"));
        contentByIntent.click();

        List<MobileElement> listElements = (List<MobileElement>) driver.findElements(MobileBy.className("android.widget.LinearLayout"));

        List<MobileElement> screenTabs = (List<MobileElement>) driver.findElements(MobileBy.className("android.widget.TextView"));
        screenTabs.get(2).click();
        assertThat(listElements.get(0), is(notNullValue()));
        screenTabs.get(3).click();
        MobileElement newPhotoButton = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/add"));
        MobileElement clearPhotoButton = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/clear"));
        MobileElement noPhotosElement = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/empty"));
        MobileElement addedPhotoElement = (MobileElement) driver.findElement(MobileBy.className("android.widget.ImageView"));
        newPhotoButton.click();
        assertThat(addedPhotoElement, is(notNullValue()));
        clearPhotoButton.click();
        assertThat(noPhotosElement, is(notNullValue()));

        driver.quit();
    }

    @Test
    @Description("Picker test")
    public void pickerTest() throws MalformedURLException {

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


        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();
        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();

        MobileElement pickerElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Picker"));
        pickerElement.click();

        new TouchAction(driver).press(PointOption.point(550, 500)).waitAction()
                .moveTo(PointOption.point(550, 800)).release().perform();

        MobileElement selectedValue = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/textView1"));
        String selectedValueText = selectedValue.getText();

        assertThat(selectedValueText, equalTo("Value: kupima"));

        driver.quit();
    }

    @Test
    @Description("PopupMenu test")
    public void popupMenu() throws MalformedURLException {

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

        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();
        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();

        MobileElement popupMenuElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Popup Menu"));
        popupMenuElement.click();

        MobileElement makePopupButton = (MobileElement) driver.findElement(MobileBy.className("android.widget.Button"));
        MobileElement toastMessage = (MobileElement) driver.findElement(MobileBy.className("android.widget.Toast"));
        List<MobileElement> widgetOptions = (List<MobileElement>) driver.findElements(MobileBy.className("android.widget.TextView"));
        String toastText = toastMessage.getText();

        makePopupButton.click();
        widgetOptions.get(0).click();
        assertThat(toastText, containsString("Search"));

        driver.quit();
    }

    @Test
    @Description("Radio button test")
    public void radioButtonTest() throws MalformedURLException {

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

        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();
        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();
        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();


        MobileElement radioGroupElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Radio Group"));
        radioGroupElement.click();

        MobileElement allButton = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/all"));
        MobileElement selectedResult = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/choice"));
        MobileElement clearAllButton = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/clear"));

        allButton.click();
        MobileElement selectedResultNew = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/choice"));
        String resultTextBefore = selectedResultNew.getText();
        clearAllButton.click();
        String resultTextAfter = selectedResult.getText();
        assertThat(resultTextBefore, is(not(resultTextAfter)));

        driver.quit();
    }

    @Test
    @Description("Rotating button test")
    public void rotatingButtonTest() throws MalformedURLException {

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

        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();
        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();
        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();


        MobileElement radioGroupElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Rotating Button"));
        radioGroupElement.click();

        MobileElement rotatingButton = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/rotatingButton"));
        MobileElement translationXBar = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/translationX"));
        MobileElement scaleYBar = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/scaleY"));
        MobileElement rotationZBar = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/rotationZ"));

        Point locationBefore = rotatingButton.getLocation();
        Dimension sizeBefore = rotatingButton.getSize();
        Rectangle rectBefore = rotatingButton.getRect();
        translationXBar.sendKeys("200");
        scaleYBar.sendKeys("200");
        rotationZBar.sendKeys("200");
        Point locationAfter = rotatingButton.getLocation();
        Dimension sizeAfter = rotatingButton.getSize();
        Rectangle rectAfter = rotatingButton.getRect();

        assertThat(locationAfter, is(not(equalTo(locationBefore))));
        assertThat(sizeAfter, is(not(equalTo(sizeBefore))));
        assertThat(rectAfter, is(not(equalTo(rectBefore))));

        driver.quit();
    }

    @Test
    @Description("Text clock test")
    public void textClockTest() throws MalformedURLException {

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

        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();
        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();
        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();
        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
                .moveTo(PointOption.point(550, 60)).release().perform();


        MobileElement textClockElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("TextClock"));
        textClockElement.click();

        List<MobileElement> timeStrings = (List<MobileElement>) driver.findElements(MobileBy.className("android.widget.TextView"));
        String HHMMFormat = timeStrings.get(2).getText();
        String mmDDYYFormat = timeStrings.get(3).getText();
        String mmDDYYHHMMFormat = timeStrings.get(4).getText();
        String hhMMSSFormat = timeStrings.get(5).getText();

        SimpleDateFormat HHMM = new SimpleDateFormat("h:mm a");
        SimpleDateFormat mmDDYY = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        SimpleDateFormat mmDDYYHHMM = new SimpleDateFormat("MM/dd/yy hmma");
        SimpleDateFormat hhMMSS = new SimpleDateFormat("hh:mm:ss a");

        assertThat(HHMMFormat, equalTo(HHMM.format(new Date())));
        assertThat(mmDDYYFormat, equalTo(mmDDYY.format(new Date())));
        assertThat(mmDDYYHHMMFormat, equalTo(mmDDYYHHMM.format(new Date())));
        assertThat(hhMMSSFormat,equalTo(hhMMSS.format(new Date())));

        driver.quit();
    }

    @Test
    @Description("Date widget test")
    public void dateWidgets() throws MalformedURLException {

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

        MobileElement dateWidgetsElement = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Date Widgets"));
        dateWidgetsElement.click();

        MobileElement dialogOption = (MobileElement) driver.findElement(MobileBy.AccessibilityId("1. Dialog"));
        dialogOption.click();

        MobileElement displayedDateTime = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/dateDisplay"));
        String displayedDateTimeTextText = displayedDateTime.getText();

        MobileElement changeDateButton = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/pickDate"));
        changeDateButton.click();
        MobileElement yearPickerButton = (MobileElement) driver.findElement(MobileBy.id("android:id/date_picker_header_year"));
        yearPickerButton.click();
//        new TouchAction(driver).press(PointOption.point(550, 800)).waitAction()
//                .moveTo(PointOption.point(550, 60)).release().perform();
        List<MobileElement> textViews = (List<MobileElement>) driver. findElements(MobileBy.className("android.widget.TextView"));
        textViews.get(5).click();
        MobileElement nextMonthButton = (MobileElement) driver.findElement(MobileBy.id("android:id/next"));
        nextMonthButton.click();
        List<MobileElement> daysOfMonth = (List<MobileElement>) driver.findElements(MobileBy.className("android.view.View"));
        daysOfMonth.get(15).click();
        MobileElement okButtonInPicker = (MobileElement) driver.findElement(MobileBy.id("android:id/button1"));
        okButtonInPicker.click();

//        MobileElement selectDayButton = (MobileElement) driver.findElement(MobileBy.className("android.view.View"));


        MobileElement changeTimeButton = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/pickTime"));
        List<MobileElement> radialPicker = (List<MobileElement>) driver
                .findElements(MobileBy.className("android.widget.RadialTimePickerView$RadialPickerTouchHelper"));
        MobileElement changeTimeButtonSpinner = (MobileElement) driver.findElement(MobileBy.id("io.appium.android.apis:id/pickTimeSpinner"));
        
        driver.quit();
    }
}
