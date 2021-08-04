package pages;

import com.codeborne.selenide.Configuration;

public class BasePage {

  public BasePage() {
    Configuration.baseUrl = "http://test-automation-shop2.greenfox.academy/";
    Configuration.browser = "chrome";
    Configuration.startMaximized = true;
  }
}
