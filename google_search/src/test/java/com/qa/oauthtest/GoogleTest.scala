package com.qa.oauthtest

import com.codeborne.selenide.Selenide.{$, closeWebDriver, closeWindow, open}
import com.codeborne.selenide.logevents.SelenideLogger
import com.codeborne.selenide.testng.{ScreenShooter, TextReport}
import com.codeborne.selenide.{Condition, Configuration, WebDriverRunner}
import OauthPage.{loginBtn, passInput, usernameInput}
import com.qa.oauthtest.util.BrowserUtils.getChromeOptions
import io.qameta.allure.selenide.{AllureSelenide, LogType}
import net.thucydides.core.pages.components.Dropdown
import org.codehaus.groovy.runtime.metaclass.MetaMethodIndex.Header
import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.RemoteWebDriver
import org.testng.Assert
import org.testng.annotations._

import java.net.URL
import java.util.logging.Level

@Listeners(Array(classOf[TextReport], classOf[ScreenShooter]))
class GoogleTest {


  @BeforeClass def setUpAll(): Unit = {
    //    Configuration.browserSize = "1280x800"
    Configuration.browser = "chrome"
    Configuration.browserVersion = "latest"
//    Configuration.remote = "http://43.205.69.220:4444/wd/hub"
    val capabilities = getChromeOptions
    Configuration.browserCapabilities = capabilities
//    val driver = new RemoteWebDriver(new URL(Configuration.remote), capabilities)
//    WebDriverRunner.setWebDriver(driver)
    SelenideLogger.addListener("allure", new AllureSelenide()
      .screenshots(true)
      .savePageSource(false)
      .enableLogs(LogType.BROWSER, Level.ALL))
  }

  @BeforeMethod def setUp(): Unit = {

  }


  @Test(testName = "googleSearchTest") def googleSearchTest(): Unit = {
    open("https://www.google.com/")
    $(By.name("q")).setValue("Think Talent")
    $(By.name("btnK")).click()
    $(By.id("logo")).shouldHave(Condition.appear)
   val header =  $(By.xpath("//<h3[text()='Think Talent Services: Home']")).getText()
  //  Assert.assertEquals(header,"Think Talent Services: Home")
  }


  @AfterClass def verifyOKAndLogout(): Unit = {
    closeWindow()
    closeWebDriver()
  }

}
