package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;

import java.util.List;


public class automationpractice_pageObject extends BaseClass {


    public static Logger log = LogManager.getLogger(pages.zeroBank_pageObject.class);

    @FindBy(xpath = "//div[@id='nav']//li")
    public List<WebElement> homePageNavBarList;

    @FindBy(xpath = "//div[@id='nav']//li[@id='homeMenu' and @class='active']")
    public WebElement homeTabActive;

    @FindBy(xpath = "//div[@id='online_banking_features']//span")
    public List<WebElement> homeSubMenu;

    @FindBy(id = "onlineBankingMenu")
    public WebElement menuOnlineBanking;

    @FindBy(id = "feedback")
    public WebElement menuFeedBack;

    @FindBy(xpath = "//div[@id='nav']//li[@id='onlineBankingMenu' and @class='active']")
    public WebElement onlineBankingTabActive;

    @FindBy(xpath = "//div[@id='nav']//li[@id='feedback' and @class='active']")
    public WebElement feedBackTabActive;

    @FindBy(xpath = "//input[@id='name' and @required]")
    public WebElement feedBackNameField;

    @FindBy(xpath = "//input[@id='email' and @required]")
    public WebElement feedBackEmailField;

    @FindBy(xpath = "//input[@id='subject' and @required]")
    public WebElement feedBackSubjectField;

    @FindBy(xpath = "//textarea[@id='comment' and @required]")
    public WebElement feedBackCommentField;

    @FindBy(xpath = "//input[@value='Send Message']")
    public WebElement feedBackSendMessageButton;

    @FindBy(id = "feedback-title")
    public WebElement feedBackHeader;

    @FindBy(xpath = "//div[contains(@class,'offset3')]")
    public WebElement feedBackThankYouNote;


    public automationpractice_pageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void bavBarMenuValidation() {
        String[] ExpList = new String[]{"HOME", "ONLINE BANKING", "FEEDBACK"};
        menuListValidation(homePageNavBarList, ExpList);


    }

    public void pageTitle() {
        String actualTitle = "";
        String ExpectedTitle = "Zero - Personal Banking - Loans - Credit Cards";

        try {
            actualTitle = driver.getTitle();
            Assert.assertEquals(ExpectedTitle, actualTitle);
            log.info("The actual title is " + actualTitle);
            log.info("The Expected title is " + ExpectedTitle);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("The actual title is " + actualTitle);
            log.error("The Expected title is " + ExpectedTitle);
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }


    }

    public void homePageSubTab() {

        try {
            waitForVisibility(homeTabActive, 5);
            log.info("Home button active ....");

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }


    }

    public void homeSubMenuValidation() {
        String[] ExpList = new String[]{"Checking Account Activity", "Transfer Funds", "My Money Map"};
        menuListValidation(homeSubMenu, ExpList);


    }

    public void clickOnlineBanking() {

        try {
            menuOnlineBanking.click();
            waitForVisibility(onlineBankingTabActive, 10);
            log.info("Online Banking  active ....");

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }


    }

    public void clickFeedBack() {

        try {
            menuFeedBack.click();
//            waitForVisibility(feedBackTabActive, 10);
//            log.info("Feed Back  active ....");

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }


    }

    public void onlineBankingSubMenuValidation() {
        String[] ExpList = new String[]{"Account Summary", "Account Activity", "Transfer Funds", "Pay Bills",
                "My Money Map", "Online Statements"};
        menuListValidation(homeSubMenu, ExpList);


    }

    public void feedBackFormNameValidation() {

        try {
            waitForVisibility(feedBackNameField, 5);
            feedBackNameField.sendKeys("testing");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }


    }


    public void feedBackFormEmailValidation() {

        try {
            waitForVisibility(feedBackEmailField, 5);
            feedBackEmailField.sendKeys("testing@mailinator.com");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }


    }

    public void feedBackForSubjectValidation() {

        try {
            waitForVisibility(feedBackSubjectField, 5);
            feedBackSubjectField.sendKeys("this is new testing");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }


    }

    public void verfiy_pixel() {

        try {
            //Locate element for which you wants to get height and width.
            WebElement Image = driver.findElement(By.xpath("//img[contains(@src,'1.jpg')]"));

            //Get width of element.
            int ImageWidth = Image.getSize().getWidth();
            log.info("Image width Is " + ImageWidth + " pixels");

            //Get height of element.
            int ImageHeight = Image.getSize().getHeight();
            log.info("Image height Is " + ImageHeight + " pixels");

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void feedBackForCommentValidation() {

        try {
            waitForVisibility(feedBackCommentField, 5);
            feedBackCommentField.sendKeys("this is new testing for the test");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }


    }

    public void feedBackForSuccessValidation() {

        try {
            feedBackSendMessageButton.click();
            waitForVisibility(feedBackHeader, 5);
            Assert.assertEquals(feedBackHeader.getText().trim(), "Feedback");
            Assert.assertTrue(!feedBackThankYouNote.getText().trim().isEmpty());
            log.info(feedBackThankYouNote.getText().trim());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }


    }


}