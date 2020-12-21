package javaFunctionality;

import cucumber.TestContext;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageObject.Levis_Sale_Submenu_PageObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Levis_Sale_Submenu_Functionality {
	private Properties properties;
	private final String propertyFilePath = "src\\test\\java\\Resource\\TestData.properties";
	String BrandName = "Samsung";
	String Searchtype = "Heladeras";
	WebDriver driver;
	Levis_Sale_Submenu_PageObjects Levis_Sale_Submenu_PageObjects;

	public Levis_Sale_Submenu_Functionality(TestContext context) {

		this.driver = context.getDriver();
		Levis_Sale_Submenu_PageObjects = new Levis_Sale_Submenu_PageObjects(driver);

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			properties.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}

	}

	public void lauchURl(String URl) {
		URl = properties.getProperty(URl);
		driver.get(URl);
		driver.manage().window().maximize();

	}

	public void landingpage() {

		String actualTitle = "";
		String ExpectedTitle = "Levi's ® Argentina";

		try {
			Levis_Sale_Submenu_PageObjects.IntialPopUP.click();
			actualTitle = driver.getTitle();
			Assert.assertEquals(ExpectedTitle, actualTitle);
			System.out.println("The actual title is " + actualTitle);
			System.out.println("The Expected title is " + ExpectedTitle);

		} catch (AssertionError e) {
			e.printStackTrace();

			System.out.println("The actual title is " + actualTitle);
			System.out.println("The Expected title is " + ExpectedTitle);
			throw e;

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void SaleMenu_Hover() {

		try {

			Actions act = new Actions(driver);
			act.moveToElement(Levis_Sale_Submenu_PageObjects.SaleMenu).build().perform();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void Validate_submenu_Link() {

		try {
			String[] HombreList = new String[] { "HOMBRE", "Jeans", "Pantalones", "Remeras y Polos", "Camperas",
					"Camisas", "Sweaters y Buzos", "Accesorios" };
			Levis_Sale_Submenu_PageObjects.Sale_SubMenu_Validation(Levis_Sale_Submenu_PageObjects.SubMenu_Hombre,
					HombreList);

			String[] MujerList = new String[] { "MUJER", "Jeans", "Remeras", "Camperas", "Camisas", "Sweaters y Buzos",
					"Faldas y Vestidos" };
			Levis_Sale_Submenu_PageObjects.Sale_SubMenu_Validation(Levis_Sale_Submenu_PageObjects.SubMenu_Mujer,
					MujerList);

			String[] KidsList = new String[] { "KIDS", "Girls (4 - 7 años)", "Boys (4 - 7 años)",
					"Teen Girls (8 - 16 años)", "Teen Boys (8 - 16 años)" };
			Levis_Sale_Submenu_PageObjects.Sale_SubMenu_Validation(Levis_Sale_Submenu_PageObjects.SubMenu_Kids,
					KidsList);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
