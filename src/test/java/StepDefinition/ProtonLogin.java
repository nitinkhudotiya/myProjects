package StepDefinition;

import Utility.ConfigReader;


import io.cucumber.java.en.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProtonLogin {
	
	static ConfigReader cr = new ConfigReader();
	WebDriver driver = StepDefinition.Hooks.driver;
	
	
	 @Given("^User lands on the proton login homepage$")
	    public void googlesearch_homepage() throws InterruptedException {
		 
	        driver.get(cr.valueOnTheKey("BaseUrl"));
	        Thread.sleep(5000);
	 }
	
	 @And("^User enters the emailId in the Email textbox$")
	    public void enter_emailId() throws InterruptedException {
		 driver.findElement(By.id(cr.valueOnTheKey("enter_email_id"))).sendKeys(cr.valueOnTheKey("Email"));
		 Thread.sleep(3000);
	    }
	
	 @And("^User enters Password in the Enter your password textbox$")
	    public void enter_password() throws InterruptedException {
		 driver.findElement(By.id(cr.valueOnTheKey("password_id"))).sendKeys(cr.valueOnTheKey("Password"));
		 Thread.sleep(3000);
	    }
	
	 @And("^User click on the Sign In button$")
	    public void click_SignIn() throws InterruptedException {
		 driver.findElement(By.xpath(cr.valueOnTheKey("sign_in_button"))).click();
		 Thread.sleep(3000);
	    }
	 
	 @Then("^Wait for the email homepage to load$")
	    public void wait_to_load_homepage() {
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
	    }
	
	

}
