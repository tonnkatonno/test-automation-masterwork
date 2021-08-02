import com.codeborne.selenide.SelenideElement;
import java.util.List;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class ListingDataTest {
  @Test
  public void printTheDataOfAllDesktops() {
    HomePage homePage = new HomePage();
    homePage.navigateToTheAllDesktopsPage();
    List<SelenideElement> list =Utility.listOfProducts();
    Utility.printListOfSelenideElements(list);
  }


}

