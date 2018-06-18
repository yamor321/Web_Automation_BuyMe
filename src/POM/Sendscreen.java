package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;


public class Sendscreen {
    private static WebElement element = null;
    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ember1034\"]/label[1]")
    public static WebElement buttoncheck1;

    @FindBy(how = How.ID, using = "ember1067")
    public static WebElement towhomthegift;

    @FindBy(how = How.ID, using = "ember1069")
    public static WebElement fromwhothegift;

    @FindBy(how = How.ID, using = "ember1077_chosen")
    public static WebElement forwhateventopenlist;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ember1077_chosen\"]/div/ul/li[7]")
    public static WebElement chosenfromlist;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ember1092\"]/textarea")
    public static WebElement comments;


    public static void uploadapickeys(WebDriver driver){

        element = driver.findElement(By.id("ember1101"));
        element.sendKeys("C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Web Automation BuyMe\\1.jpg");
    }

    @FindBy(how = How.CLASS_NAME, using = "send-now")
    public static WebElement afterpaymentcheckbox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ember1027\"]/div[4]/div/div[1]/div[2]/div/button")
    public static WebElement chooseemail;

    public static void setEnteremail(WebDriver driver){
        element = driver.findElement(By.xpath("//input[@data-parsley-type='email']"));
        element.sendKeys("dgotlieb8@gmail.com");
    }

    @FindBy(how = How.ID_OR_NAME, using = "ember1543")
    public static WebElement enteremail;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ember1027\"]/div[4]/div/div[3]/div/div[2]/button[2]")
    public static WebElement submitmail;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ember1027\"]/div[5]/button")
    public static WebElement submit;


//Extras

    @FindBy(how = How.ID, using = "ember715")
    public static WebElement towhoext;

    @FindBy(how = How.ID, using = "sender-name")
    public static WebElement fromwhoext;

    @FindBy(how = How.ID, using = "msg")
    public static WebElement blessext;

    @FindBy(how = How.CSS, using = "#ember1177 > div > div.card-info > div.receiver > span.name")
    public static WebElement cardtowhoext;

    @FindBy(how = How.CSS, using = "#ember1177 > div > div.card-info > div.sender > span.name")
    public static WebElement cardfromwhoext;

    @FindBy(how = How.CSS, using = "#ember1177 > div > div.card-info > div.row.text-and-img-row > div.col.col-2-3 > p")
    public static WebElement cardblessext;







    public Sendscreen (WebDriver driver)
    {
        this.driver = driver;
    }
}

