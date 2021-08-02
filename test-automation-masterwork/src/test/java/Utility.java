import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.SelenideElement;
import java.util.List;
import org.openqa.selenium.By;

public class Utility {
  public static List<SelenideElement> listOfProducts() {
    return $$(By.xpath("//div[@class='product-thumb']"));
  }

  public static void printListOfSelenideElements(List<SelenideElement> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i).getText());
    }
  }
}
