package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class TopBarLoggedIn extends TopBarWithoutLogin {
  private SelenideElement cartButton;
  private SelenideElement checkoutButton;

  private SelenideElement myAccount = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"));

  private SelenideElement orderHistory = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
  private SelenideElement transactions = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[3]/a"));
  private SelenideElement download = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[4]/a"));
  private SelenideElement logout = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a"));

  public TopBarLoggedIn() {
    super();
    this.cartButton = super.getCartButton();
    this.checkoutButton = super.getCheckoutButton();
    getMyAccountButton().click();
  }

  public void logout() {
    this.logout.click();
  }
}