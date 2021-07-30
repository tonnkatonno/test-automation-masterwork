import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.HomePage;

public class RegistrationTest {
   static HomePage homePage;

  @BeforeAll
  public static void homePageSetUp() {
    homePage = new HomePage();
  }
// ha statikus akkor nem jó :(
  @ParameterizedTest
  @CsvFileSource(resources = "data_for_registration.csv", numLinesToSkip = 1)
  public void registration(String firstName, String lastName, String email, String phoneNumber,
                           String password) throws Exception {

    homePage.getRegisterPage().fillTheForm(firstName, lastName, email, phoneNumber, password);
    assertThat(homePage.getRegisterPage().isSuccessfulRegistration()).isTrue();

    homePage.setTopBarLoggedIn(true);
    homePage.getTopBarLoggedIn().logout();

  }
}
