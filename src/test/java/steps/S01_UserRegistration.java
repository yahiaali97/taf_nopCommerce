package steps;

import base.TestBase;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P01_Registration;

import static org.testng.Assert.assertTrue;

public class S01_UserRegistration extends TestBase {
    P01_Registration registerObject;
    Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.internet().password();

    @Given("The user is in the home page")
    public void the_user_is_in_the_home_page() {
        registerObject = new P01_Registration(driver);
        registerObject.openRegisterPage();
    }

    @When("I click on register link")
    public void i_click_on_register_link() {
        assertTrue(driver.getCurrentUrl().contains("register"));
    }

    @When("I entered user data")
    public void i_entered_user_data() {
        registerObject.userRegistration(firstname, lastname, email, password);
    }

    @Then("The Registration page displayed successfully")
    public void the_registration_page_displayed_successfully() {
        assertTrue(driver.findElement(registerObject.resultMsg).getText()
                .contains("Your registration completed"));
    }
}