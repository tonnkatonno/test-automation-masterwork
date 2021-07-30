package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class LoginPage extends TopBarWithoutLogin {

  private SelenideElement emailField = $(By.id("input-email"));
  private SelenideElement passwordField = $(By.id("input-password"));

  private SelenideElement loginButton = $(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

  public LoginPage() {
    super();
    open(super.getLoginButton().getAttribute("href"));
  }

  public void login(String email, String password) {
    this.emailField.sendKeys(email);
    this.passwordField.sendKeys(password);
    loginButton.click();
  }

}