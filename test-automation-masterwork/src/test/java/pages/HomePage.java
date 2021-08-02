package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
  private SelenideElement registerButton;
  private SelenideElement loginButton;
  private SelenideElement cartButton;
  private SelenideElement checkOutButton;
  private SelenideElement myAccountButton;
  private SelenideElement allDesktops;


  public HomePage() {
    open("");
    $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
    this.registerButton = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
    this.loginButton = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
    this.cartButton = $(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/span"));
    this.checkOutButton = $(By.xpath("//*[@id=\"top-links\"]/ul/li[5]/a"));
    this.myAccountButton = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i"));
    this.allDesktops = $(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a"));
  }

  public void navigateToRegisterPage() {
    registerButton.click();
  }

  public void navigateToTheLoginPage() {
    loginButton.click();
  }
  public void navigateToTheAllDesktopsPage(){
    open(allDesktops.getAttribute("href"));
  }

  public void navigateToTheCartPage() {
    cartButton.click();
  }

  public void navigateToTheCheckoutPage() {
    checkOutButton.click();
  }

  public void navigateToTheMyAccountPage() {
    myAccountButton.click();
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

  public SelenideElement getCheckOutButton() {
    return checkOutButton;
  }

  public SelenideElement getMyAccountButton() {
    return myAccountButton;
  }
}
