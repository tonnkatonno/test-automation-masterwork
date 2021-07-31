import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.HomePage;
import pages.RegisterPage;

public class RegistrationTest {


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
}
