package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.ConfigReader;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class ComposeEmail {
	static ConfigReader cr = new ConfigReader();
	WebDriver driver = StepDefinition.Hooks.driver;
	
	
	 @Given("^Verify User has successfully logged In$")
	    public void googlesearch_homepage() throws InterruptedException {
		 
	        WebElement new_message = driver.findElement(By.xpath(cr.valueOnTheKey("new_message_button")));
	        
	        if(new_message.isEnabled()==true) {
	        	System.out.println("Compose button is enabled and We successfully logged In");
	        }else {
	        	System.out.println("Validation Failed");
	        }
	        
	        Assert.assertTrue(new_message.isEnabled());  //hard Validation
	        Thread.sleep(1000);
	 }                   
	 @When("^User click on the New Message button$")
	    public void click_new_message_button() throws InterruptedException {
		 driver.findElement(By.xpath(cr.valueOnTheKey("new_message_button"))).click();
		 Thread.sleep(3000);
 
	 }
	 
	 @And("^User validate that a new popup should be displayed with the headers as a new message$")
	    public void validate_new_message_button() throws InterruptedException {
		String new_message_heading = driver.findElement(By.xpath(cr.valueOnTheKey("new_message_button_validation"))).getText();
		Assert.assertEquals("New message", new_message_heading);  

	 }
	 
	 @And("^User validate clicking on the send button without entering anything in To field$")
	    public void validate_without_To_email_negative_case() throws InterruptedException {
		driver.findElement(By.xpath(cr.valueOnTheKey("send_button"))).click();
		String st1 = driver.findElement(By.xpath(cr.valueOnTheKey("validate_without_email_negative_case_xpath"))).getText();
		Assert.assertEquals("Recipient missing",st1);
		driver.findElement(By.xpath("//button[text()='Got it']")).click();
		Thread.sleep(2000);
	 }
	 @And("^User validate clicking on the send button without entering anything in Subject field$")
	    public void validate_without_Subject_negative_case() throws InterruptedException {
		 enter_sender_email();
		driver.findElement(By.xpath(cr.valueOnTheKey("send_button"))).click();
		String st1 = driver.findElement(By.xpath(cr.valueOnTheKey("without_subject_email"))).getText();
		Assert.assertEquals("Subject missing",st1);
		driver.findElement(By.xpath(cr.valueOnTheKey("close_composeemail_window"))).click();
		Thread.sleep(2000);
		click_new_message_button();
		
	 }
	 
	 @And("^User enters the senders email address$")
	    public void enter_sender_email() throws InterruptedException {
		 driver.findElement(By.xpath(cr.valueOnTheKey("sender_email_xpath"))).sendKeys(cr.valueOnTheKey("Sender_email"));
		 Thread.sleep(2000);

	 }
	 @And("^User validate if multiple commas are allowed to separate multiple email ids of TO, CC, and BCC sections.$")
	    public void validate_comma_separated_emails() throws InterruptedException {
		 driver.findElement(By.xpath(cr.valueOnTheKey("sender_email_xpath"))).sendKeys(","+cr.valueOnTheKey("second_Sender_email"));
		 Thread.sleep(2000);
		 

	 }
	 
	 @And("^User click on the cc button$")
	    public void click_cc_button() throws InterruptedException {
		 driver.findElement(By.xpath(cr.valueOnTheKey("cc_bcc_xpath"))).click();
		 Thread.sleep(3000);

	 }
	 
	 @And("^User enters the email in cc$")
	    public void enter_cc_email() throws InterruptedException {
		 driver.findElement(By.xpath(cr.valueOnTheKey("cc_email_xpath"))).sendKeys(cr.valueOnTheKey("cc_email_value"));
		 Thread.sleep(3000);

	 }
	 
	 @And("^User enters the Subject$")
	    public void enter_subject() throws InterruptedException {
		 driver.findElement(By.xpath(cr.valueOnTheKey("subject_xpath"))).sendKeys(cr.valueOnTheKey("subject_value"));
		 Thread.sleep(3000);

	 }
	 @And("^User enter the body of the email$")
	    public void enter_body() throws InterruptedException {
	WebElement emailBodyElement=driver.findElement(By.xpath(cr.valueOnTheKey("email_body_xpath")));
	JavascriptExecutor js	= (JavascriptExecutor) driver;
	//js.executeScript("document.evaluate(, document, null, 9, null).singleNodeValue.innerHTML="+ "jhasfdjdj");
	//js.executeScript("argument[0].value='My first email'", emailBodyElement);
	js.executeScript("arguments[0].innerHTML=Bjfagjh",emailBodyElement );
	Thread.sleep(40000);

	 }
	 
		/*
		 * @And("^User click on the send button$") public void click_send_button()
		 * throws InterruptedException {
		 * driver.findElement(By.xpath(cr.valueOnTheKey("send_button"))).click();
		 * Thread.sleep(20000);
		 * 
		 * }
		 */
		 

}
