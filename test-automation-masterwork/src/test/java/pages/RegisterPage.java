package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class RegisterPage {

  private SelenideElement firstNameField;
  private SelenideElement lastNameField;
  private SelenideElement emailField;
  private SelenideElement phoneField;
  private SelenideElement passwordField;
  private SelenideElement confirmPasswordField;
  private SelenideElement privacyPolicyCheckbox;
  private SelenideElement continueButton;
  private SelenideElement privacyPolicy;
  private SelenideElement closeButtonPrivacyPolicy;


  public RegisterPage() {
    this.firstNameField = $(By.id("input-firstname"));
    this.lastNameField = $(By.id("input-lastname"));
    this.emailField = $(By.id("input-email"));
    this.phoneField = $(By.id("input-telephone"));
    this.passwordField = $(By.id("input-password"));
    this.confirmPasswordField = $(By.id("input-confirm"));
    this.privacyPolicyCheckbox =
        $(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
    this.continueButton =
        $(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
    this.privacyPolicy = $(By.xpath("//*[@id=\"content\"]/form/div/div/a/b"));

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

    if ($(By.xpath("//*[@id=\"account-register\"]/div[1]")).isDisplayed()) {
      throw new Exception(
          "Error: " + $(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText());
    }
  }

  public void logout() {
    $(By.xpath("//*[@id=\"column-right\"]/div/a[13]")).click();
  }

  public boolean isLogOutSuccessful() {
    if ($(By.xpath("//*[@id=\"content\"]/h1")).getText().contains("Logout")) {
      return true;
    }
    return false;
  }

  public boolean isAccountSuccessfullyRegistered() {
    if ($(By.xpath("//*[@id=\"content\"]/h1")).getText().contains("Has Been Created")) {
      return true;
    }
    return false;
  }

  public void clickThePrivacyPolicy() {
    this.privacyPolicy.click();
    this.closeButtonPrivacyPolicy =
        $(By.xpath("//*[@id=\"modal-agree\"]/div/div/div[1]/button"));
  }

  public void closeThePrivacyPolicy() {
    this.closeButtonPrivacyPolicy.click();
  }
  public SelenideElement getCloseButtonPrivacyPolicy(){
    return this.closeButtonPrivacyPolicy;
  }
}