import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.HomePage;
import pages.LoginPage;
import pages.MacBookPage;

public class InputOfNewDataTest {
  @AfterEach
  public void tearDown() {
    Selenide.closeWindow();
  }

  @Description("Navigates to the home page, then logs in, navigate to the MacBook page, fills the comment fields up from the comment_data.csv, and then sends the comment")
  @Story("Input of new data : At least one new data input, validate the input was successful")
  @ParameterizedTest
  @CsvFileSource(resources = "comment_data.csv", numLinesToSkip = 1)
  public void commentsShouldSubmittedProperly(String name, String comment, int rating) {
    HomePage homePage = new HomePage();
    homePage.navigateToTheLoginPage();

    LoginPage loginPage = new LoginPage();
    loginPage.login("apalay3d@sciencedaily.com", "rj8nDsn");

    assertThat(loginPage.isLoggedIn()).isTrue().withFailMessage("Login process failed!");
    homePage.navigateToHomePage();

    homePage.navigateToMacBookPage();
    MacBookPage macBookPage = new MacBookPage();
    macBookPage.fillTheReview(name, comment, rating);
    assertThat(macBookPage.getReview().equals(
        "Thank you for your review. It has been submitted to the webmaster for approval.")).withFailMessage(
        "Review not submitted");
    loginPage.logOut();
  }

}

