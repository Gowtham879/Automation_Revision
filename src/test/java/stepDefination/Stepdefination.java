package stepDefination;

import Utilities.BaseClass;
import hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utilities.SeleniumCommands;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Stepdefination extends SeleniumCommands {
    BaseClass baseClass=new BaseClass();
    SeleniumCommands seleniumCommands=new SeleniumCommands();
    RegisterPage registerPage=new RegisterPage();
    LoginPage loginPage=new LoginPage();
    HomePageHeader homePageHeader=new HomePageHeader();
    FilterPage filterPage=new FilterPage();
    CheckOutProcess checkOutProcess=new CheckOutProcess();
    @Given("User launch the Application")
    public void user_launch_the_Application()  {

        baseClass.launchDemoWebShop();
    }
//--------------------------------------------REGISTRATION-PAGE---------------------------------------------------
    @When("User is able to give the PersonalDetails and Create the Password such as Gender and  {string}")
    public void user_is_able_to_give_the_PersonalDetails_and_Create_the_Password_such_as_Gender_and(String FirstName) {
       registerPage.RegisterDetails1(FirstName);
    }
    @When("and {string} {string} and  {string} {string}")
    public void and_and(String LastName, String Email, String Password, String ConfirmPassword) {
       registerPage.RegisterDetails2(LastName,Email,Password,ConfirmPassword);
    }
    @Then("Click on the Register button and Verify the Confirm message.")
    public void click_on_the_Register_button_and_Verify_the_Confirm_message() {
        registerPage.RegisterDeatails3();
    }
    @Then("Close the Application.")
    public void close_the_Application() {
        baseClass.Exit();
    }
//--------------------------------------------LOGIN-PAGE----------------------------------------------------------
    @When("after Registration Completed User able to login with same Register valid Credentials")
    public void after_Registration_Completed_User_able_to_login_with_same_Register_valid_Credentials() {
        loginPage.login();
    }
    @When("{string} and {string}")
    public void and(String Email, String Password) {
        loginPage.LoginDetails(Email,Password);
    }
    @Then("Verify the Login Email")
    public void verify_the_Login_Email() {
        loginPage.verfify();
    }
//--------------------------------------------ADDTOCART-PAGE--------------------------------------------------------
    @When("User is select {string} from {string} select the {string}")
    public void user_is_select_from_select_the(String MainCategorie, String Product, String Item) {
    homePageHeader.HomePageDeatails(MainCategorie,Product,Item);
    }
    @When("applying the Filtersfrom DropDowns {string} {string} and {string} {string}")
    public void applying_the_Filtersfrom_DropDowns_and(String string, String FilterValue1, String string3, String FilterValue2) {
//       filterPage.FiterDetails1(FilterValue1,FilterValue2);
        filterPage.firstTwoFilter2();
    }
    @When("user is apply's the Filters Click on AddtoCart")
    public void user_is_apply_s_the_Filters_Click_on_AddtoCart(DataTable filterTable) {
        List<Map<String, String>> filterList = filterTable.asMaps(String.class, String.class);
        for (int i = 0; i < filterList.size(); i++) {
            String FilterName = filterList.get(i).get("FilterName");
            System.out.println(FilterName);
            String FilterValue = filterList.get(i).get("FilterValue");
            System.out.println(FilterValue);
            seleniumCommands.Scroll();
            filterPage.FiterDetails2(FilterName,FilterValue);
                }
        filterPage.addtocart();
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    @When("user is going through CheckoutProcess")
    public void user_is_going_through_CheckoutProcess() {
         loginPage.LoginForShipping();
         checkOutProcess.checkoutprocess();
    }@Then("Verify Order Confirm")
    public void verify_Order_Confirm() {
     checkOutProcess.verifycation();
     loginPage.logout();
    }
//-----------------------------------------------DEFECT-SCREENSHOT-------------------------------------------------------
    @AfterStep
    public void takeScreenshot(Scenario scenario) throws IOException
    {
        if (scenario.isFailed())
        {
            byte[] scrennshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("ScreenShot", new ByteArrayInputStream(scrennshot));
        }
    }
}
