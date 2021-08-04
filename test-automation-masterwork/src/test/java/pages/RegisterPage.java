package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class RegisterPage {

  private final SelenideElement firstNameField;
  private final SelenideElement lastNameField;
  private final SelenideElement emailField;
  private final SelenideElement phoneField;
  private final SelenideElement passwordField;
  private final SelenideElement confirmPasswordField;
  private final SelenideElement privacyPolicyCheckbox;
  private final SelenideElement continueButton;
  private final SelenideElement privacyPolicy;
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
    return $(By.xpath("//*[@id=\"content\"]/h1")).getText().contains("Logout");
  }

  public boolean isAccountSuccessfullyRegistered() {
    return $(By.xpath("//*[@id=\"content\"]/h1")).getText().contains("Has Been Created");
  }

  public void clickThePrivacyPolicy() {
    this.privacyPolicy.click();
    this.closeButtonPrivacyPolicy =
        $(By.xpath("//*[@id=\"modal-agree\"]/div/div/div[1]/button"));
  }

  public void closeThePrivacyPolicy() {
    this.closeButtonPrivacyPolicy.click();
  }

  public SelenideElement getCloseButtonPrivacyPolicy() {
    return this.closeButtonPrivacyPolicy;
  }
}