import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.RegisterPage;
import pages.TopBarWithLogin;

public class RegistrationTest {

  @ParameterizedTest
  @CsvFileSource(resources = "./list_of_registrations.csv", numLinesToSkip = 1)
  public void registration(String firstName,String lastName,String email,String phoneNumber,String password){
    RegisterPage regPage = new RegisterPage();
    regPage.fillTheForm(firstName,lastName,email,phoneNumber,password);
    assertThat(regPage.isSuccessfulRegistration()).isTrue();

    TopBarWithLogin topBar = new TopBarWithLogin();
    topBar.logout();
  }

}
