import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class ExistingDataModification extends LoginTest {
  private HomePage homePage;
  private LoginPage loginPage;

  @BeforeEach
  public void setup() {
    simpleLogin();
    this.homePage = getHomePage();
    this.loginPage = getLoginPage();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "change_names.csv", numLinesToSkip = 1)
  public void commentsShouldSubmittedProperly(String firstName, String lastName) {
    homePage.navigateToEditAccountInfoPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    myAccountPage.changeName(firstName, lastName);
    assertThat(myAccountPage.getAccountUpdatedMessage()).isEqualTo(
        "Success: Your account has been successfully updated.");
    homePage.navigateToEditAccountInfoPage();
    myAccountPage.updateInfo();
    assertThat(myAccountPage.getNewFirstName()).isEqualTo(firstName);
    assertThat(myAccountPage.getNewLastName()).isEqualTo(lastName);
    loginPage.logOut();
  }

}