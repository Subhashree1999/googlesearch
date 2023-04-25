package com.qa.oauthtest.util

import org.openqa.selenium.{Capabilities, MutableCapabilities}
import org.openqa.selenium.chrome.ChromeOptions
object BrowserUtils {

  def getChromeOptions: MutableCapabilities = {
    val capabilities = new ChromeOptions().addArguments("--remote-allow-origins=*")
    capabilities.setCapability("enableVNC", true)
    capabilities.setCapability("enableVideo", true)
    capabilities
  }

}
