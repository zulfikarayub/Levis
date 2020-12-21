package pageObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import io.cucumber.core.api.Scenario;

public class Levis_Sale_Submenu_PageObjects {

	WebDriver driver;

	public Levis_Sale_Submenu_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='cat-sale']/a[text()='SALE']")
	public WebElement SaleMenu;

	@FindBy(xpath = "//*[@class='cerrar no-boton']")
	public WebElement IntialPopUP;

	@FindBy(xpath = "//*[@id='cat-sale']//li[@class='desplegable'][1]//a")
	public List<WebElement> SubMenu_Hombre;

	@FindBy(xpath = "//*[@id='cat-sale']//li[@class='desplegable'][2]//a")
	public List<WebElement> SubMenu_Mujer;

	@FindBy(xpath = "//*[@id='cat-sale']//li[@class='desplegable'][3]//a")
	public List<WebElement> SubMenu_Kids;

	public void Sale_SubMenu_Validation(List<WebElement> elementname, String[] SubMenuName) {

		ArrayList<String> ActualSubMenu = new ArrayList<String>();
		ArrayList<String> ExpectedSubMenu = new ArrayList<String>();
		ExpectedSubMenu.addAll(Arrays.asList(SubMenuName));
		String ActualText;

		try {

			for (WebElement SubMenulist : elementname) {

				ActualText = SubMenulist.getText().trim().replaceAll(",", "");

				ActualSubMenu.add(ActualText);

			}
			System.out.println(ActualSubMenu);
			Assert.assertEquals(ActualSubMenu, ExpectedSubMenu);

		} catch (AssertionError e) {
			e.printStackTrace();
			System.out.println("The actual title is " + ActualSubMenu);
			System.out.println("The Expected title is " + ExpectedSubMenu);
			Assert.fail("Validation failure occour");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
