import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.RegisterPage;


public class UsingPrivacyStatementTest {
  @Test
  public void usingPrivacyShouldPass() {
    HomePage homePage = new HomePage();
    homePage.navigateToRegisterPage();
    RegisterPage registerPage = new RegisterPage();
    registerPage.clickThePrivacyPolicy();
    registerPage.closeThePrivacyPolicy();
    assertThat(registerPage.getCloseButtonPrivacyPolicy().isDisplayed()).isFalse()
        .withFailMessage("Privacy Policy close button is displayed but it shouldn't");
  }

  @Test
  public void usingPrivacyShouldFail() {
    HomePage homePage = new HomePage();
    homePage.navigateToRegisterPage();
    RegisterPage registerPage = new RegisterPage();
    registerPage.clickThePrivacyPolicy();
    registerPage.closeThePrivacyPolicy();
    assertThat(registerPage.getCloseButtonPrivacyPolicy().isDisplayed()).withFailMessage(
        "Privacy Policy close button should displayed but isn't shown");
  }
}

