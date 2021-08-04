import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.HomePage;
import pages.LoginPage;
import pages.MacBookPage;

public class InputOfNewDataTest extends LoginTest {
  private HomePage homePage;
  private LoginPage loginPage;

  @BeforeEach
  public void setup(){
    simpleLogin();
    this.homePage=getHomePage();
    this.loginPage=getLoginPage();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "comment_data.csv", numLinesToSkip = 1)
  public void commentsShouldSubmittedProperly(String name, String comment, int rating) {
    homePage.navigateToMacBookPage();
    MacBookPage macBookPage = new MacBookPage();
    macBookPage.fillTheReview(name, comment, rating);
    assertThat(macBookPage.getReview().equals(
        "Thank you for your review. It has been submitted to the webmaster for approval.")).withFailMessage(
        "Review not submitted");
    loginPage.logOut();
  }

}

