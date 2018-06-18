package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EnterandReg {

    private static WebElement element = null;
    private final WebDriver driver;

    @FindBy(how = How.CSS, using = "#ember510 > div > header.m-page-header.home-header > div.wrapper.relative > ul > li.top-bar-item.my-account > a > span")
    public static WebElement regbutton;

    @FindBy(how = How.CSS, using = "#auth-modal > div > span > strong")
    public static WebElement wanttoreg;

    @FindBy(how = How.ID, using = "ember858")
    public static WebElement firstname;

    @FindBy(how = How.ID, using = "ember859")
    public static WebElement email;

    @FindBy(how = How.ID, using = "valPass")
    public static WebElement password;

    @FindBy(how = How.ID, using = "ember861")
    public static WebElement passwordagain;

    @FindBy(how = How.CSS, using = "#ember857 > div:nth-child(5) > div > label")
    public static WebElement checkbox1;

    @FindBy(how = How.CSS, using = "#ember857 > div:nth-child(6) > div > label > span")
    public static WebElement checkbox2;

    @FindBy(how = How.CSS, using = "#ember857 > button")
    public static WebElement submit;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ember851\"]/button")
    public static WebElement submitnocred;

    @FindBy(how = How.ID, using = "parsley-id-12")
    public static WebElement errormessege1;

    @FindBy(how = How.ID, using = "parsley-id-14")
    public static WebElement errormessege2;


    public EnterandReg(WebDriver driver) {
        this.driver = driver;
    }
}

