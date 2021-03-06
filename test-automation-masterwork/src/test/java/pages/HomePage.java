package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
  private final SelenideElement registerButton;
  private final SelenideElement loginButton;
  private final SelenideElement cartButton;
  private final SelenideElement checkOutButton;
  private final SelenideElement myAccountButton;
  private final SelenideElement allDesktops;
  private final SelenideElement macBook;


  public HomePage() {
    open("");
    $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
    this.registerButton = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
    this.loginButton = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
    this.cartButton = $(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/span"));
    this.checkOutButton = $(By.xpath("//*[@id=\"top-links\"]/ul/li[5]/a"));
    this.myAccountButton = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i"));
    this.allDesktops = $(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a"));
    this.macBook = $(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/a/img"));
  }

  public void navigateToRegisterPage() {
    registerButton.click();
  }

  public void navigateToTheLoginPage() {
    loginButton.click();
  }

  public void navigateToMacBookPage() {
    macBook.click();
  }

  public void navigateToTheAllDesktopsPage() {
    open(allDesktops.getAttribute("href"));
  }

  public void navigateToEditAccountInfoPage() {
    myAccountButton.click();
    SelenideElement myAccount = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
    myAccount.click();
    SelenideElement editAccountInfo = $(By.xpath("//*[@id=\"content\"]/ul[1]/li[1]/a"));
    editAccountInfo.click();
  }

  public void navigateToHomePage() {
    open("");
  }

}
