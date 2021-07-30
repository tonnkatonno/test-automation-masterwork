import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.LoginPage;

public class LoginTest {
  @ParameterizedTest
  @CsvFileSource(resources = "registered_users.csv", numLinesToSkip = 1)
  public void loginTest(String email,String password){
   // LoginPage loginPage = new LoginPage();
    //loginPage.login(email,password);

  }
}
