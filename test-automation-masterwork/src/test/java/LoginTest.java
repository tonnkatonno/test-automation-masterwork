import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest {
  private HomePage homePage;
  private LoginPage loginPage;

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

  @Test
  public void loginTestShouldFail() {
    this.homePage = new HomePage();
    this.homePage.navigateToTheLoginPage();

    this.loginPage = new LoginPage();
    this.loginPage.login("kutzafarka.oooop@javascript.pytonmenoam", "ezegynagyonerosjelszo123");

    assertThat(this.loginPage.isLoggedIn()).isFalse()
        .withFailMessage("Login process not failed! It should fail...");
  }

  @Test
  public void simpleLogin() {
    this.homePage = new HomePage();
    this.homePage.navigateToTheLoginPage();

    this.loginPage = new LoginPage();
    this.loginPage.login("apalay3d@sciencedaily.com", "rj8nDsn");

    assertThat(this.loginPage.isLoggedIn()).isTrue().withFailMessage("Login process failed!");
    this.homePage.navigateToHomePage();
  }

  public HomePage getHomePage() {
    return homePage;
  }

  public LoginPage getLoginPage() {
    return loginPage;
  }
}
