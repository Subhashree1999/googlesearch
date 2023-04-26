package com.qa.oauthtest.util

import com.codeborne.selenide.Selenide.open
import org.testng.annotations.Test
import com.codeborne.selenide.Selenide.{$, $$, closeWebDriver, closeWindow, open}
import com.codeborne.selenide.logevents.SelenideLogger
import com.codeborne.selenide.testng.{ScreenShooter, TextReport}
import com.codeborne.selenide.{CollectionCondition, Condition, Configuration, WebDriverRunner}
//import OauthPage.{loginBtn, passInput, usernameInput}
import com.qa.oauthtest.util.BrowserUtils.getChromeOptions
import io.qameta.allure.selenide.{AllureSelenide, LogType}
//import net.thucydides.core.pages.components.Dropdown
//import org.codehaus.groovy.runtime.metaclass.MetaMethodIndex.Header
import org.openqa.selenium.{By, WebElement}
//import org.openqa.selenium.chrome.ChromeOptions
//import org.openqa.selenium.remote.RemoteWebDriver
import org.testng.Assert
import org.testng.annotations._



class Launch_chrome {
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
      .savePageSource(false))
    //.enableLogs(LogType.BROWSER, Level.ALL))
  }

  @BeforeMethod def setUp(): Unit = {

  }



    Configuration.browser = "chrome"
  Configuration.headless = true
  Configuration.baseUrl="https://www.google.com/"
    open("/search?q=think+talent&oq=think+talent&aqs")

    @Test(testName = "launch_chrome") def launch_chrome(): Unit = {
      open("https://www.google.com/")
      $(By.name("q")).setValue("Think Talent")
      $(By.name("btnK")).click()
      $(By.id("logo")).shouldHave(Condition.appear)
      val Header = $(By.xpath("//h3[text()='Think Talent Services: Home']")).getText()
      println(Header)
      Assert.assertEquals(Header, "Think Talent Services: Home")
    }

}
