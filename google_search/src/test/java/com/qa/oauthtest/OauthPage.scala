package com.qa.oauthtest

import com.codeborne.selenide.Selenide.$
import com.codeborne.selenide.SelenideElement

object OauthPage {
  val usernameInput: SelenideElement = $("#username")
  val passInput: SelenideElement = $("#password")
  val loginBtn: SelenideElement = $("#loginbtn")
}
