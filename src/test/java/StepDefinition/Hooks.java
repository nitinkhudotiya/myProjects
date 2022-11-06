package StepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.cucumber.core.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;

public class Hooks {
	static WebDriver driver;
	static ConfigReader cr = new ConfigReader();

	@Before
	public WebDriver beforeScenario() {

		/*
		 * WebDriverManager.chromedriver().setup(); ChromeOptions options = new
		 * ChromeOptions(); options.addArguments("--headless"); driver = new
		 * ChromeDriver(options); driver.manage().window().maximize(); return driver;
		 */

		
		   WebDriverManager.chromedriver().setup();
		   ChromeOptions options = new ChromeOptions();
		  options.addArguments("--incognito");
		   driver = new ChromeDriver(options);
		  driver.manage().window().maximize(); 
		  return driver; 
		 

	}

	@After
	public void afterScenario(Scenario scenario) {
		// Capture ScreenShot for the failed test cases.
		if (scenario.isFailed()) {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			try {
				FileUtils.copyFile(file, new File(
						System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".png"));
				scenario.embed(screenshot, "image/png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Capture ScreenShot for non-failed test cases.
		if (!scenario.isFailed()) {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			try {
				FileUtils.copyFile(file, new File(
						System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".png"));
				scenario.embed(screenshot, "image/png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		driver.close();
	}

	public static LocalDateTime getCurrentDateAndTime() {
		LocalDateTime now = LocalDateTime.now();
		return now;
	}
}
