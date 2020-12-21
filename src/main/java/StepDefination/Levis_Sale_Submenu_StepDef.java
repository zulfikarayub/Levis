package StepDefination;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javaFunctionality.Levis_Sale_Submenu_Functionality;

public class Levis_Sale_Submenu_StepDef {
	String Appurl = "https://www.fravega.com";
	Levis_Sale_Submenu_Functionality LevisSaleFun;

	public Levis_Sale_Submenu_StepDef(TestContext context) {
		LevisSaleFun = new Levis_Sale_Submenu_Functionality(context);
	}

	@Given("user Lauch the application url {string} and verfiy page title")
	public void user_lauch_the_application_url_and_verfiy_page_title(String url) {
		LevisSaleFun.lauchURl(url);
		LevisSaleFun.landingpage();
	}

	@Given("user hover on sale link from menu bar")
	public void user_hover_on_sale_link_from_menu_bar() {
		LevisSaleFun.SaleMenu_Hover();
	}
	
	@Then("user validate the submenu name and click link validation")
	public void user_validate_the_submenu_name_and_click_link_validation() {
		LevisSaleFun.Validate_submenu_Link();
	}

}
