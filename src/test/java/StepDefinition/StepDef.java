package StepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.*;

import PageObject.LoginPage;
import Utilities.ReadConfig;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {
	
	public WebDriver driver;
	
	public LoginPage loginPg;
	public ReadConfig readConfig;
	

@Given("User Launch Chrome browser")
public void user_launch_chrome_browser() throws IOException {
	
	readConfig = new ReadConfig();
	String browser =readConfig.getBrowser();
	loginPg = new LoginPage(driver);
	switch(browser.toLowerCase()) {
	case "chrome" :
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		break;
	case "edge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		break;
		default:
			driver = null;
			break;
	}
    
}

@When("User opend URL {string}")
public void user_opend_url(String url) {
	driver.get(url);
	driver.manage().window().maximize();
	
    
}

@When("User enters Email as {string} and password as {string}")
public void user_enters_email_as_and_password_as(String emailadd, String password) {
	
	loginPg.enterEmail(emailadd);
	loginPg.enterPassword(password);
    
}

@When("Click on Login")
public void click_on_login() {
	loginPg.clickOnLoginBtn();
    
}

@Then("Page Title should be {string}")
public void page_title_should_be(String expectedResult) {
	String actualTitle = driver.getTitle();
	
	if(actualTitle.equals(expectedResult)) {
		Assert.assertTrue(true);
	}
	else {
		Assert.assertFalse(false);
	}
    
}

@When("User clicks on Log out link")
public void user_clicks_on_log_out_link() {
	loginPg.ClickOnLogOut();
    
}

@Then("Close browser")
public void close_browser() {
	driver.close();
    
}
@AfterStep
public void addscreenshot(Scenario scenario) {
	
		final byte[] screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
	
}

}
