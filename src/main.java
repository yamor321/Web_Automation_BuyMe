import POM.EnterandReg;
import POM.Giftpick;
import POM.HomescreenPick;
import POM.Sendscreen;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class main {

    public TestName name = new TestName();
    private static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeClass
    public static void beforeclass() {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter
                ("C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Web Automation BuyMe\\Reports\\Reportbuyme.html");

        htmlReporter.setAppendExisting(true);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Yarden Morshtein Web Automation Project", "Automating “BuyMe” website");
        extent.setSystemInfo("Project goal", "'BuyMe' Website Sanity Test");
        extent.setSystemInfo("Tester", "Yarden");
        extent.setSystemInfo("Website address", "https://buyme.co.il/");
        extent.setSystemInfo("Third-Party usage", "Selenium web-driver, JUnit, ExtentReports");

        test.log(Status.INFO, "@Before class");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Web Automation BuyMe\\chromedriver.exe");
//        System.setProperty("webdriver.ie.driver",
//                "C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Web Automation BuyMe\\IEDriverServer.exe" );
//        System.setProperty("webdriver.gecko.driver",
//                "C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Web Automation BuyMe\\geckodriver.exe" );
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
//        options.addArguments("--headless");

//        driver = new InternetExplorerDriver();
//        driver = new FirefoxDriver();

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        EnterandReg POMandPF = PageFactory.initElements(driver, EnterandReg.class);
        HomescreenPick POMandPF1 = PageFactory.initElements(driver, HomescreenPick.class);
        Sendscreen POMandPF2 = PageFactory.initElements(driver, Sendscreen.class);
    }

    //    @Test
    public void enterwebandregister() throws IOException, ParserConfigurationException, SAXException, AWTException {
        //This method will open main page and register to be a member at the website.//
        boolean pageOpened = false;
        try {
            driver.navigate().to(getData("URL"));
            pageOpened = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Could not open BuyMe webpage");
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "BuyMe Webpage opened successfully");
            }
        }
        test.pass("Main Page", MediaEntityBuilder.createScreenCaptureFromPath
                (takeScreenShot("C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Web Automation BuyMe\\Reports\\screenshots\\" + "Main Page")).build());

        boolean enterandreg = false;
        try {
            EnterandReg.regbutton.click();
            EnterandReg.wanttoreg.click();
            EnterandReg.firstname.sendKeys("yarden");
            EnterandReg.email.sendKeys(getData("EMAIL"));
            EnterandReg.password.sendKeys("Yamor321");
            EnterandReg.passwordagain.sendKeys("Yamor321");
            EnterandReg.checkbox1.click();
            EnterandReg.checkbox2.click();
            EnterandReg.submit.click();
            enterandreg = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Enter Website And Register Fail" + e.getMessage());
            enterandreg = false;
        } finally {
            if (enterandreg) {
                test.log(Status.PASS, "Enter Website And Register Successfully");
            }
        }
    }

    @Test
    public void Apickpresentattributes() throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        // This method will pick the present attributes and submit.//
        boolean pageOpened = false;
        try {
            driver.navigate().to(getData("URL"));
            pageOpened = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Could not open BuyMe webpage");
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "BuyMe Webpage opened successfully");
            }
        }
        test.pass("Choose Present attributes", MediaEntityBuilder.createScreenCaptureFromPath
                (takeScreenShot("C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Web Automation BuyMe\\Reports\\screenshots\\" + "present attributes")).build());
        boolean choosepresatt = false;
        try {
            HomescreenPick.entersumlist.click();
            HomescreenPick.choosesum.click();
            HomescreenPick.enterregionlist.click();
            HomescreenPick.chooseregion.click();
            HomescreenPick.entercategor.click();
            HomescreenPick.choosecategor.click();
            HomescreenPick.submit.click();
            choosepresatt = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Choose present attributes Fail" + e.getMessage());
            choosepresatt = false;
        } finally {
            if (choosepresatt) {
                test.log(Status.PASS, "Choose present attributes Successfully");
            }
        }

        WebDriverWait expwait = new WebDriverWait(driver, 5);
        expwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ember530 > div > div.application-main > div:nth-child(2) > h1")));

        Assert.assertEquals(driver.getCurrentUrl(), HomescreenPick.getUrlassertion);
    }

    @Test
    public void Bgiftpicking() throws InterruptedException, IOException {
        //This method will pick chosen gift from the gift list and choose its inner options//
        Thread.sleep(1000);
        test.pass("Presents to Choose", MediaEntityBuilder.createScreenCaptureFromPath
                (takeScreenShot("C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Web Automation BuyMe\\Reports\\screenshots\\" + "presents to choose")).build());
        boolean giftpick = false;
        try {
            Giftpick.choosepresandclick(driver);
            Giftpick.choosepresinandclick2(driver);
            giftpick = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Present choosing Fail" + e.getMessage());
        } finally {
            if (giftpick) {
                test.log(Status.PASS, "Present chosen Successfuly");
            }
        }
        test.pass("Present Chosen", MediaEntityBuilder.createScreenCaptureFromPath
                (takeScreenShot("C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Web Automation BuyMe\\Reports\\screenshots\\" + "Present Chosen")).build());
    }

    @Test
    public void Cfillformandsend() throws IOException {
        //This method fill the sender form including uploading a picture and send the present//
        WebDriverWait expwait1 = new WebDriverWait(driver, 20);
        expwait1.until(ExpectedConditions.elementToBeClickable(Sendscreen.buttoncheck1));
        test.pass("Form Page", MediaEntityBuilder.createScreenCaptureFromPath
                (takeScreenShot("C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Web Automation BuyMe\\Reports\\screenshots\\" + "Form to fill Page")).build());

        boolean sendscreen = false;
        try {
            Sendscreen.buttoncheck1.click();
            Sendscreen.towhomthegift.sendKeys("Daniel");
            Sendscreen.fromwhothegift.sendKeys("Yarden");
            Sendscreen.forwhateventopenlist.click();
            Sendscreen.chosenfromlist.click();
            Sendscreen.comments.clear();
            Sendscreen.comments.sendKeys("Enjoy Man!");
            Sendscreen.uploadapickeys(driver);
            Sendscreen.afterpaymentcheckbox.click();
            Sendscreen.chooseemail.click();
            Sendscreen.setEnteremail(driver);
//            Sendscreen.enteremail.sendKeys("dgotlieb8@gmail.com");
            Sendscreen.submitmail.click();
            Sendscreen.submit.click();
            sendscreen = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Filling form after choosing a present Fail" + e.getMessage());
        } finally {
            if (sendscreen) {
                test.log(Status.PASS, "Form Filled Successfully and " + "Present Sent Successfully");
            }
        }

    }

    //From here down it's the extras//

    //    @Test
    public void getloadingdots() throws IOException, SAXException, ParserConfigurationException {
        //EXTRA - this method will get the loading dots at the main loading page//
        boolean pageOpened = false;
        try {
            driver.navigate().to(getData("URL"));
            pageOpened = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Could not open BuyMe webpage");
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "BuyMe Webpage opened successfully");
            }
        }
        System.out.println(driver.findElement(By.id("ember510")).getSize());
    }

//    @Test
    public void asserterrormessages() throws IOException, SAXException, ParserConfigurationException {
        //EXTRA - this method asserts both error messages when you are trying to register without username and password//
        boolean pageOpened = false;
        try {

            driver.navigate().to(getData("URL"));
            pageOpened = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Could not open BuyMe webpage");
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "BuyMe Webpage opened successfully");
            }
        EnterandReg.regbutton.click();
        EnterandReg.submitnocred.click();
        String errormessege1 = EnterandReg.errormessege1.getText();
        String errormessege2 = EnterandReg.errormessege2.getText();
        Assert.assertEquals(errormessege1,errormessege2);
        }
    }

//    @Test
    public void Aassertdetails1 () throws IOException, SAXException, ParserConfigurationException {
        //EXTRA - This method asserts details from the send form to the info card that is shown at left side//
        boolean pageOpened = false;
        try {
            driver.get("https://buyme.co.il/package/874764/1347040");
                    pageOpened = true;
                } catch (Exception e) {
                    e.printStackTrace();
                    test.log(Status.FAIL, "Could not open BuyMe webpage");
                    pageOpened = false;
                } finally {
                    if (pageOpened) {
                        test.log(Status.PASS, "BuyMe Webpage opened successfully");
                    }
                }
                Sendscreen.towhoext.sendKeys("Daniel");
                String cardto = Sendscreen.cardtowhoext.getText();
                Assert.assertEquals(cardto,"Daniel");
            }

//    @Test
    public void Bassertdetails2 () throws IOException, SAXException, ParserConfigurationException {
        //EXTRA - This method asserts details from the send form to the info card that is shown at left side//
        boolean pageOpened = false;
        try {
            driver.get("https://buyme.co.il/package/874764/1347040");
            pageOpened = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Could not open BuyMe webpage");
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "BuyMe Webpage opened successfully");
            }
        }
        Sendscreen.fromwhoext.sendKeys("Yarden");
        String cardfrom = Sendscreen.cardfromwhoext.getText();
        Assert.assertEquals(cardfrom,"Yarden");
    }

//    @Test
    public void Cassertdetails3 () throws IOException, SAXException, ParserConfigurationException {
        //EXTRA - This method asserts details from the send form to the info card that is shown at left side//
        boolean pageOpened = false;
        try {
            driver.get("https://buyme.co.il/package/874764/1347040");
            pageOpened = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Could not open BuyMe webpage");
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "BuyMe Webpage opened successfully");
            }
        }
        Sendscreen.blessext.sendKeys("Enjoy man!");
        String cardbless = Sendscreen.cardblessext.getText();
        Assert.assertEquals(cardbless,"Enjoy man!");
    }

            @AfterClass
            public static void afterClass () {
                test.log(Status.INFO, "@After test ");
//                driver.quit();
                extent.flush();
            }


            private static String getData (String keyName) throws
            ParserConfigurationException, IOException, SAXException {
                File XML1 = new File("C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Web Automation BuyMe\\XML1.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = null;
                dBuilder = dbFactory.newDocumentBuilder();
                Document doc = null;
                assert dBuilder != null;
                doc = dBuilder.parse(XML1);
                if (doc != null) {
                    doc.getDocumentElement().normalize();
                }
                assert doc != null;
                return doc.getElementsByTagName(keyName).item(0).getTextContent();

            }

            private static String takeScreenShot (String ImagesPath){
                TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
                File destinationFile = new File(ImagesPath + ".png");
                try {
                    FileUtils.copyFile(screenShotFile, destinationFile);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                return ImagesPath + ".png";
            }
        }

