package StepDefinitions;

import PageObjects.loginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class loginStepDef extends loginPage {

	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	@Given("^Launch the Orange HCM website$")
	public void launch_the_Orange_HCM_website() throws Throwable {
		launchURL(url);
	}
		
	@Given("^Enter the valid credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_the_valid_credentials_and(String arg1, String arg2) throws Throwable {
		enterUserDetails(arg1,arg2);
	}


	@When("^click on Login button$")
	public void click_on_Login_button() throws Throwable {
		 clickLogin();
	}

	@Then("^It will take you to Home page$")
	public void it_will_take_you_to_Home_page() throws Throwable {
		verifyHomePage();
	}

}
