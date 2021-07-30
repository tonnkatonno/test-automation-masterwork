package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class RegisterPage extends TopBarWithoutLogin {

  private SelenideElement firstNameField = $(By.id("input-firstname"));
  private SelenideElement lastNameField = $(By.id("input-lastname"));
  private SelenideElement emailField = $(By.id("input-email"));
  private SelenideElement phoneField = $(By.id("input-telephone"));
  private SelenideElement passwordField = $(By.id("input-password"));
  private SelenideElement confirmPasswordField = $(By.id("input-confirm"));
  private SelenideElement privacyPolicyCheckbox =
      $(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
  private SelenideElement continueButton =
      $(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));


  public RegisterPage() {
    super();
    open(super.getRegisterButton().getAttribute("href"));
  }

  public void fillTheForm(String first, String last, String email, String phone, String password)
      throws Exception {
    this.firstNameField.sendKeys(first);
    this.lastNameField.sendKeys(last);
    this.emailField.sendKeys(email);
    this.phoneField.sendKeys(phone);

    this.passwordField.sendKeys(password);
    this.confirmPasswordField.sendKeys(password);

    this.privacyPolicyCheckbox.click();

    this.continueButton.click();

    if($(By.xpath("//*[@id=\"account-register\"]/div[1]")).isDisplayed()){
      throw new Exception ("Account already registered or other error when filling the form");
    }
  }

  public boolean isSuccessfulRegistration() {
    if ($(By.xpath("//*[@id=\"content\"]/h1")).getText()
        .equals("Your Account Has Been Created!")) {
      return true;
    }
    return false;
  }

  public boolean isLoggedIn() {
    if ($(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).isDisplayed()) {
      return true;
    }
    return false;
  }
}