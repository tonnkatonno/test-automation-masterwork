package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class MyAccountPage {
  private final SelenideElement firstNameField;
  private final SelenideElement lastNameField;
  private final SelenideElement continueButton;
  private String oldFirstName;
  private String oldLastName;
  private String newFirstName;
  private String newLastName;

  public MyAccountPage() {
    this.firstNameField = $(By.id("input-firstname"));
    this.lastNameField = $(By.id("input-lastname"));
    this.continueButton = $(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input"));
  }

  public void changeName(String firstName, String lastName) {
    oldFirstName = this.firstNameField.getAttribute("value");
    oldLastName = this.lastNameField.getAttribute("value");

    this.firstNameField.clear();
    this.lastNameField.clear();

    this.firstNameField.sendKeys(firstName);
    this.lastNameField.sendKeys(lastName);

    this.continueButton.click();
  }

  public String getAccountUpdatedMessage() {
    $(By.xpath("//*[@id=\"account-account\"]/div[1]")).has(
        Condition.matchText("Success: Your account has been successfully updated."));
    return $(By.xpath("//*[@id=\"account-account\"]/div[1]")).getText();
  }

  public void updateInfo() {
    newFirstName = this.firstNameField.getAttribute("value");
    newLastName = this.lastNameField.getAttribute("value");
  }

  public String getNewFirstName() {
    return newFirstName;
  }

  public String getNewLastName() {
    return newLastName;
  }
}
