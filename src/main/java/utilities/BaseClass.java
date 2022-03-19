package utilities;

import com.google.common.base.Function;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.zeroBank_pageObject;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseClass extends Driver {

    public static final String USERNAME = "fsdbai_dsad";
    public static final String AUTOMATE_KEY = "1XaTd3nehMwVYaYcVakR";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
    public static WebDriver driver;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
    public static String runtype;
    public static Logger log = LogManager.getLogger(BaseClass.class);
    public static zeroBank_pageObject zeroBank_pageObject;
    public static JavascriptExecutor js;


    public BaseClass() {
    }


    public void initTestMethod() {
        driver = geTDriver();
        zeroBank_pageObject = new zeroBank_pageObject(driver);
        js = (JavascriptExecutor) driver;
    }

    public WebDriver geTDriver() {
        try {
            runtype = ConfigReader.getProperty("runtype");
            if (runtype.equalsIgnoreCase("local")) {
                if (driver == null) {
                    switch (ConfigReader.getProperty("browser")) {
                        case "chrome":
                            WebDriverManager.chromedriver().setup();
                            setDriver(new ChromeDriver());
                            break;
                        case "firefox":
                            WebDriverManager.firefoxdriver().setup();
                            setDriver(new FirefoxDriver());
                            break;
                        case "ie":
                            WebDriverManager.iedriver().setup();
                            setDriver(new InternetExplorerDriver());
                            break;
                        case "safari":
                            WebDriverManager.getInstance(SafariDriver.class).setup();
                            setDriver(new SafariDriver());
                            break;
                        case "headless-chrome":
                            WebDriverManager.chromedriver().setup();
                            setDriver(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                            break;
                    }

                }

            } else if (runtype.equalsIgnoreCase("remote")) {
                DesiredCapabilities caps = new DesiredCapabilities();

                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.0.0");
                URL browserStackUrl = new URL(URL);
                setDriver(new RemoteWebDriver(browserStackUrl, caps));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver = getDriver();
        tdriver.set(driver);
        return newDriver();
    }


    public WebDriver newDriver() {
        return tdriver.get();
    }



    public static void waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = null;
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSec));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());

        }

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement fluentWait(final WebElement webElement, int timeinsec) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeinsec)).pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });
        return element;
    }


    /**
     * Selects a random value from a dropdown list
     *
     * @param select
     * @return
     */
    public static void selectRandomTextFromDropdown(WebElement select, int whichIndex) {
        Select selectOption = new Select(select);
        log.info("selecting by index of .... " + whichIndex);
        log.info("selecting by index of .... " + selectOption.getAllSelectedOptions());
        selectOption.selectByIndex(whichIndex);

    }


    public void visit(String url) {
        geTDriver();
        initTestMethod();
        getDriver().get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public static void getScreenShot(Scenario scenario) {


        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");
    }


    public void menuListValidation(List<WebElement> elementname, String[] SubMenuName) {

        ArrayList<String> ActualMenu = new ArrayList<String>();
        ArrayList<String> ExpectedMenu = new ArrayList<String>();
        ExpectedMenu.addAll(Arrays.asList(SubMenuName));
        int count;
        String actualText;

        try {
            count = elementname.size();
            log.info("total count of nav bar is.." + count);

            for (WebElement headerText : elementname) {
                actualText = headerText.getText().trim();

                ActualMenu.add(actualText);

            }
            log.info("Actual menu fo  UI" + ActualMenu);
            Assert.assertEquals(ActualMenu, ExpectedMenu);


        } catch (Exception e) {
            e.printStackTrace();
            log.error("The actual title is " + ActualMenu);
            log.error("The Expected title is " + ExpectedMenu);
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }


    }

}
