package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomescreenPick {


    public static String getUrlassertion = "https://buyme.co.il/search?budget=6&category=74&region=2835";
    private static WebElement element = null;
    private final WebDriver driver;

    @FindBy(how = How.CSS, using = "#ember605_chosen")
    public static WebElement entersumlist;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ember605_chosen\"]/div/ul/li[7]")
    public static WebElement choosesum;

    @FindBy(how = How.CSS, using = "#ember620_chosen > a")
    public static WebElement enterregionlist;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ember620_chosen\"]/div/ul/li[8]")
    public static WebElement chooseregion;

    @FindBy(how = How.CSS, using = "#ember629_chosen > a")
    public static WebElement entercategor;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ember629_chosen\"]/div/ul/li[12]")
    public static WebElement choosecategor;

    @FindBy(how = How.CSS, using = "#ember664 > button")
    public static WebElement submit;

    public HomescreenPick(WebDriver driver) {
        this.driver = driver;
    }

}