package pages;

import com.codeborne.selenide.Configuration;
public class BasePage {

  public BasePage() {
    Configuration.baseUrl = "https://demo.opencart.com/";
    Configuration.browser = "chrome";
  }

}
