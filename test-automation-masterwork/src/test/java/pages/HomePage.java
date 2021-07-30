package pages;

public class HomePage {
  private LoginPage loginPage;
  private RegisterPage registerPage;
  private TopBarWithoutLogin topBarWithoutLogin;
  private TopBarLoggedIn topBarLoggedIn;

  public HomePage() {
    this.topBarWithoutLogin = new TopBarWithoutLogin();
    this.loginPage = new LoginPage();
    this.registerPage = new RegisterPage();
  }

  public LoginPage getLoginPage() {
    return loginPage;
  }

  public RegisterPage getRegisterPage() {
    return registerPage;
  }

  public TopBarWithoutLogin getTopBarWithoutLogin() {
    return topBarWithoutLogin;
  }

  public TopBarLoggedIn getTopBarLoggedIn() {
    return topBarLoggedIn;
  }

  public void setTopBarLoggedIn(boolean isTrue) {
    if (isTrue) {
      this.topBarLoggedIn = new TopBarLoggedIn();
    }
  }
}
