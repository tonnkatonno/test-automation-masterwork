package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class LoginPage {

  private SelenideElement emailField = $(By.id("input-email"));
  private SelenideElement passwordField = $(By.id("input-password"));

  private SelenideElement loginButton =
      $(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

  private SelenideElement myAccountButton =
      $(By.linkText("My Account"));

  public void login(String email, String password) {
    this.emailField.sendKeys(email);
    this.passwordField.sendKeys(password);
    loginButton.click();
  }

  public boolean isLoggedIn() {
    if ($(By.xpath("//*[@id=\"column-right\"]/div/a[13]")).getText().contains("out")) {
      return true;
    }
    return false;
  }

  public void logOut() {
    actions().moveToElement(myAccountButton).perform();
    myAccountButton.click();
    $(By.linkText("Logout")).isDisplayed();
    $(By.linkText("Logout")).click();
  }
}
