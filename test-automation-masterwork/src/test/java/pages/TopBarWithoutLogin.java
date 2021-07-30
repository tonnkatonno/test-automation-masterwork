package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


public class TopBarWithoutLogin extends HomePage {
  private SelenideElement registerButton = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
  private SelenideElement loginButton = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));

  private SelenideElement cartButton = $(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/span"));
  private SelenideElement checkoutButton = $(By.xpath("//*[@id=\"top-links\"]/ul/li[5]/a/span"));

  private SelenideElement myAccount = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));

  public TopBarWithoutLogin() {
    super();
    open("");
  }

  public SelenideElement getRegisterButton() {
    return registerButton;
  }

  public SelenideElement getLoginButton() {
    return loginButton;
  }

  public SelenideElement getCartButton() {
    return cartButton;
  }

  public SelenideElement getCheckoutButton() {
    return checkoutButton;
  }
  public SelenideElement getMyAccountButton() {
    return myAccount;
  }
}
