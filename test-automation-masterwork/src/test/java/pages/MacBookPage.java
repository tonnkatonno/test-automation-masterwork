package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class MacBookPage {
  private SelenideElement writeACommentButton;
  private SelenideElement nameField;
  private SelenideElement commentField;
  private SelenideElement ratingRadio;
  private SelenideElement continueSubmit;

  public MacBookPage() {
    this.writeACommentButton = $(By.xpath("//*[@id=\"content\"]/div/div[2]/div[3]/p/a[2]"));
    writeACommentButton.click();
    this.nameField = $(By.id("input-name"));
    this.commentField = $(By.id("input-review"));
    this.continueSubmit = $(By.id("button-review"));
  }

  public void fillTheReview(String name, String comment, int rating) {
    this.ratingRadio = $(By.xpath("//*[@id=\"form-review\"]/div[4]/div/input[" + rating + "]"));
    this.nameField.clear();
    this.nameField.sendKeys(name);
    this.commentField.sendKeys(comment);
    this.ratingRadio.click();
    this.continueSubmit.click();
  }

  public String getReview() {
    $(By.xpath("//*[@id=\"form-review\"]/div[2]")).shouldHave(Condition.matchText(
        "Thank you for your review. It has been submitted to the webmaster for approval."));
    return $(By.xpath("//*[@id=\"form-review\"]/div[2]")).getText();
  }
}
