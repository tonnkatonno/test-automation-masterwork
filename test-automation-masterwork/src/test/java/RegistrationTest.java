import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import pages.registerPage;

public class RegistrationTest {

  @ParameterizedTest
  @CsvFileSource(resources = "./list_of_registrations.csv", numLinesToSkip = 1)
  public void registration(String firstName,String lastName,String email,String phoneNumber,String password){
    registerPage regPage = new registerPage();
    regPage.fillTheForm(firstName,lastName,email,phoneNumber,password);
    assertThat(regPage.isSuccessfulRegistration()).isTrue();
  }

}
