import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.RegisterPage;


public class UsingPrivacyStatementTest {
  @AfterEach
  public void tearDown() {
    Selenide.closeWindow();
  }

  @Description("Cover a successful privacy statement open, navigates from the home page to the register page, open up the Privacy Policy, and then when it appears closes it.")
  @Story("Using Privacy Statement : Cover a successful Privacy Policy open and close")
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

  @Description("Cover a unsuccessful privacy statement open, navigates from the home page to the register page, open up the Privacy Policy")
  @Story("Using Privacy Statement : Cover a unsuccessful Privacy Policy open")
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

