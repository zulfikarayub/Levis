package StepDefination;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.TestContext;
//import io.cucumber.core.api.Scenario;
//import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
//import io.cucumber.java.Scenario;
//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.AfterStep;
//import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.Levis_Sale_Submenu_PageObjects;

public class Hooks {

	Levis_Sale_Submenu_PageObjects Levis_Sale_Submenu_PageObjects;
	WebDriver driver;

	private final TestContext context;

	public Hooks(TestContext context) {
		this.context = context;
		Levis_Sale_Submenu_PageObjects = new Levis_Sale_Submenu_PageObjects(driver);
	}

	@Before
	public void beforeSteps(Scenario scenario) throws IOException {

		// for driver version please the suitable and change it accordingly to run in
		// your system

		WebDriverManager.chromedriver().version("2.38").setup();
		driver = new ChromeDriver();
		context.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@AfterStep
	public void afterStep(Scenario scenario) {

		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/jpg", "jpg");

	}

	@After
	public void tearDown(Scenario scenario) throws IOException {

		context.getDriver().close();

	}

}
