import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.HomePage;

public class PaginationTest {
  @AfterEach
  public void tearDown() {
    Selenide.closeWindow();
  }

  @Test
  public void paginationShouldPass() {
    HomePage homePage = new HomePage();
    homePage.navigateToTheAllDesktopsPage();
    List<SelenideElement> list = Utility.listOfProducts();
    assertThat(list.size()).isEqualTo(15)
        .withFailMessage("Page should have 15 elements but it has:" + list.size() + " element/s");

    findNextPageButton().click();
    assertThat(Utility.listOfProducts().size()).isEqualTo(1).withFailMessage(
        "The page should have 1 element in it but it has : " + Utility.listOfProducts().size() +
            " element/s");
  }

  public SelenideElement findNextPageButton() {
    return $(By.xpath("//*[@id=\"content\"]/div[5]/div[1]/ul/li[3]/a"));
  }
}
