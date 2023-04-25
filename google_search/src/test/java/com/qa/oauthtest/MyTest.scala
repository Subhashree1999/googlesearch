package com.qa.oauthtest

import com.codeborne.selenide.{Configuration, WebDriverRunner}
import com.codeborne.selenide.Selenide.{$, closeWebDriver, open}
import OauthPage.{loginBtn, passInput, usernameInput}
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.{DesiredCapabilities, RemoteWebDriver}

import java.net.URL;


object MyTest extends App {

  val urlToRemoteWD = "http://localhost:4444/wd/hub"
  val driver = new RemoteWebDriver(new URL(urlToRemoteWD), new ChromeOptions())
  WebDriverRunner.setWebDriver(driver)

  // Set the URL of the remote hub
  Configuration.remote = "http://localhost:4444/wd/hub";
  Configuration.browser = "chrome";
  Configuration.browserVersion = "latest";

  // Set the desired capabilities for the browser
  val capabilities = new DesiredCapabilities();
  //        capabilities.setBrowserName("chrome");
  //        capabilities.setVersion("latest");
  capabilities.setCapability("enableVNC", true);
  capabilities.setCapability("enableVideo", true);


  open("https://nextv3.thinktalent.info/")
  $("#username1").sendKeys("ranjanpatelbbsr@gmail.com")
  passInput.sendKeys("13972684")
  loginBtn.click()

  // Close the browser
  closeWebDriver();

}
