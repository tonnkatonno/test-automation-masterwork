import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.HomePage;
import pages.RegisterPage;

public class RegistrationTest {
  @Description("Cover various successful registration, navigates from the home page to the registration page, and fills the form from the .csv with valid data")
  @Story("Registration : Cover various successful registration")
  @ParameterizedTest
  @CsvFileSource(resources = "data_for_registration.csv", numLinesToSkip = 1)
  public void registrationShouldBeSuccessful(String firstName, String lastName, String email,
                                             String phoneNumber,
                                             String password) throws Exception {
    HomePage homePage = new HomePage();
    homePage.navigateToRegisterPage();
    RegisterPage registerPage = new RegisterPage();
    registerPage.fillTheForm(firstName, lastName, email, phoneNumber, password);
    assertThat(registerPage.isAccountSuccessfullyRegistered()).isTrue()
        .withFailMessage("Registration successful message does not appeared!");
    registerPage.logout();
    assertThat(registerPage.isLogOutSuccessful()).isTrue()
        .withFailMessage("Log out not successful!");
  }

  @Description("Cover a unsuccessful registration, navigates from the home page to the registration page, and fills the form with invalid data")
  @Story("Registration : Cover a unsuccessful registration")
  @Test
  public void registrationShouldFail() {
    Boolean isExceptionTrowed = false;
    HomePage homePage = new HomePage();
    homePage.navigateToRegisterPage();
    RegisterPage registerPage = new RegisterPage();
    try {
      registerPage.fillTheForm("Pista", "Jonapot", "asdfadsfff@dapsdff.com", "987867676",
          "kmdfertterre");
    } catch (Exception e) {
      isExceptionTrowed = e.getMessage().contains("E-Mail");
    }
    assertThat(isExceptionTrowed).isTrue().withFailMessage(
        "Registration does not failed, but it should fail, probably the test with this test data runs first time, run it again and probably it will fail (it will pass) :D");
  }

  @AfterEach
  public void tearDown() {
    Selenide.closeWindow();
  }
}
