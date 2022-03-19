package ui_tests.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import utilities.BaseClass;

import static utilities.ConfigReader.getProperty;

@RunWith(Cucumber.class)
public class zeroBank_StepDef extends BaseClass {

    @Given("User launch the URL {string} successfully")
    public void user_launch_the_url_successfully(String url) {

        visit(getProperty(url));
    }

    @Given("verify page title")
    public void verify_page_title() {
        zeroBank_pageObject.pageTitle();
    }
    @When("verify page nav bar")
    public void verify_page_nav_bar() {
        zeroBank_pageObject.homePageSubTab();
        zeroBank_pageObject.bavBarMenuValidation();
    }
    @Then("verify home page internal tab")
    public void verify_home_page_internal_tab() {
        zeroBank_pageObject.homeSubMenuValidation();
    }

    @Then("verify online bank internal tab")
    public void verify_online_bank_internal_tab() {
        zeroBank_pageObject.onlineBankingSubMenuValidation();
    }

    @Then("click on online banking tab")
    public void click_on_online_banking_tab() {
        zeroBank_pageObject.clickOnlineBanking();
    }

    @Then("click on feedback tab")
    public void click_on_feedback_tab() {
        zeroBank_pageObject.clickFeedBack();
    }


    @Given("verify name field validation")
    public void verify_name_field_validation() {
        zeroBank_pageObject.feedBackFormNameValidation();
    }
    @Given("verfiy email field validation")
    public void verfiy_email_field_validation() {
        zeroBank_pageObject.feedBackFormEmailValidation();
    }
    @Given("verify subject field validation")
    public void verify_subject_field_validation() {
        zeroBank_pageObject.feedBackForSubjectValidation();
        zeroBank_pageObject.feedBackForCommentValidation();
    }
    @Given("verify success message is displayed")
    public void verify_success_message_is_displayed() {
      zeroBank_pageObject.feedBackForSuccessValidation();
    }

}