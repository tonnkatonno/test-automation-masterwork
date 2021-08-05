import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class ListingDataTest {
  @AfterEach
  public void tearDown() {
    Selenide.closeWindow();
  }

  @Description("Navigates to the home page, then the all desktops page, and counts the number of elements in the page it should 15")
  @Story("Listing data : Execute a data listing from any data available on the page")
  @Test
  public void printTheDataOfAllDesktops() {
    HomePage homePage = new HomePage();
    homePage.navigateToTheAllDesktopsPage();
    List<SelenideElement> list = Utility.listOfProducts();
    assertThat(list.size()).isEqualTo(15)
        .withFailMessage("Page should have 15 elements but it has:" + list.size() + " element/s");
  }
}

