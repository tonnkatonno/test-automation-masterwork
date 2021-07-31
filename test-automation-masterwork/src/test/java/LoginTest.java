import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest {
  @ParameterizedTest
  @CsvFileSource(resources = "registered_users.csv", numLinesToSkip = 1)
  public void loginTestShouldPass(String email, String password) {
    HomePage homePage = new HomePage();
    homePage.navigateToTheLoginPage();

    LoginPage loginPage = new LoginPage();
    loginPage.login(email,password);

    assertThat(loginPage.isLoggedIn()).isTrue().withFailMessage("Login process failed!");
    loginPage.logOut();
  }
  @Test
  public void loginTestShouldFail(){
    HomePage homePage = new HomePage();
    homePage.navigateToTheLoginPage();

    LoginPage loginPage = new LoginPage();
    loginPage.login("kutzafarka.oooop@javascript.pytonmenoam","ezegynagyonerosjelszo123");

    assertThat(loginPage.isLoggedIn()).isFalse().withFailMessage("Login process not failed! It should fail...");
  }
}
