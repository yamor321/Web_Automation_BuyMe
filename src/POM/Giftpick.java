package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Giftpick {

    private static WebElement element = null;
    private final WebDriver driver;

    public static void choosepresandclick(WebDriver driver){

        List<WebElement> giftsList = driver.findElements(By.className("promo-item"));
        giftsList.get(3).click();
    }
    public static void choosepresinandclick2(WebDriver driver){

        List<WebElement> giftsList = driver.findElements(By.className("card-img"));
        giftsList.get(0).click();
    }

    public Giftpick(WebDriver driver) {
        this.driver = driver;
    }
}
