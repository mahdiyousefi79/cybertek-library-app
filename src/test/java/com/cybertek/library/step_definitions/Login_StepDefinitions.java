package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    LandingPage landingPage =new LandingPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
       String url = ConfigurationReader.getProperty("qa2-url");
       Driver.getDriver().get(url);
    }


    @When("I login as librarian")
    public void i_login_as_librarian() {
        String username = ConfigurationReader.getProperty("lib22_user");
        String password = ConfigurationReader.getProperty("lib22_password");
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signINButton.click();
    }


    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        String expectedInUrl = "dashboard";
        wait.until(ExpectedConditions.urlContains(expectedInUrl));

        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedInUrl));

        Driver.closeDriver();
    }

    @When("I login as student")
    public void iLoginAsStudent() {
        String username = ConfigurationReader.getProperty("student95_user");
        String password = ConfigurationReader.getProperty("student95_password");
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signINButton.click();
    }

    @Then("books should be displayed")
    public void booksShouldBeDisplayed() {

        String expectedInUrl= "books";

        wait.until(ExpectedConditions.urlContains(expectedInUrl));

        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedInUrl));

        Driver.closeDriver();

    }

    @When("I enter username {string}")
    public void i_enter_username(String string) {

        loginPage.usernameInput.sendKeys(string);

    }



    @When("I enter password  {string}")
    public void i_enter_password(String string) {

        loginPage.passwordInput.sendKeys(string);

    }
    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.signINButton.click();

    }
    @Then("there should be {int} users")
    public void there_should_be_users(Integer int1) {

    wait.until(ExpectedConditions.visibilityOf(landingPage.userCount));



         String expectedUserName = String.valueOf(int1);
         String actualUserNumber =landingPage.userCount.getText();

         Assert.assertEquals("Actual user number is not as expected",actualUserNumber,expectedUserName);

    }


    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String username, String password) {

       loginPage.usernameInput.sendKeys(username);
       loginPage.passwordInput.sendKeys(password);
       loginPage.signINButton.click();

    }
}
