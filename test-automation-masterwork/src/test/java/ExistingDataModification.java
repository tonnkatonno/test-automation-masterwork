import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class ExistingDataModification {

  @AfterEach
  public void tearDown() {
    Selenide.closeWindow();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "change_names.csv", numLinesToSkip = 1)
  public void commentsShouldSubmittedProperly(String firstName, String lastName) {
    HomePage homePage = new HomePage();
    homePage.navigateToTheLoginPage();

    LoginPage loginPage = new LoginPage();
    loginPage.login("apalay3d@sciencedaily.com", "rj8nDsn");

    assertThat(loginPage.isLoggedIn()).isTrue().withFailMessage("Login process failed!");
    homePage.navigateToHomePage();

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