import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest {
  private HomePage homePage;
  private LoginPage loginPage;

  @AfterEach
  public void tearDown() {
    Selenide.closeWindow();
  }

  @Description("Cover various successful logins, navigates from the home page to the login page, and fills the fields from the .csv, and logs in")
  @Story("Login : Cover various successful login")
  @ParameterizedTest
  @CsvFileSource(resources = "registered_users.csv", numLinesToSkip = 1)
  public void loginTestShouldPass(String email, String password) {
    this.homePage = new HomePage();
    this.homePage.navigateToTheLoginPage();

    this.loginPage = new LoginPage();
    this.loginPage.login(email, password);

    assertThat(loginPage.isLoggedIn()).isTrue().withFailMessage("Login process failed!");
    this.loginPage.logOut();
  }

  @Description("Cover a unsuccessful login, navigates from the home page to the login page, and fills the fields with invalid data, and attempt to log in")
  @Story("Login : Cover a unsuccessful login")
  @Test
  public void loginTestShouldFail() {
    this.homePage = new HomePage();
    this.homePage.navigateToTheLoginPage();

    this.loginPage = new LoginPage();
    this.loginPage.login("kutzafarka.oooop@javascript.pytonmenoam", "ezegynagyonerosjelszo123");

    assertThat(this.loginPage.isLoggedIn()).isFalse()
        .withFailMessage("Login process not failed! It should fail...");
  }

  @Description("Cover a successful login, navigates from the home page to the login page, and fills the fields , and logs in")
  @Story("Login : Cover a successful login")
  @Test
  public void simpleLogin() {
    this.homePage = new HomePage();
    this.homePage.navigateToTheLoginPage();

    this.loginPage = new LoginPage();
    this.loginPage.login("apalay3d@sciencedaily.com", "rj8nDsn");

    assertThat(this.loginPage.isLoggedIn()).isTrue().withFailMessage("Login process failed!");
    this.homePage.navigateToHomePage();
  }
}
