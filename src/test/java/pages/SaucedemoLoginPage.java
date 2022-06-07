package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.SauceDemoBaseClass;
import testcases.SauceDemoBaseClass;

public class SaucedemoLoginPage {

	WebDriver driver = SauceDemoBaseClass.driver;

	ExtentTest test = SauceDemoBaseClass.test;

	// =============== Web Elements =====================//

	@FindBy(xpath = "//*[@id='user-name']")
	WebElement UserName;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy( id = "login-button")
	WebElement LoginButton;

	public SaucedemoLoginPage() {

		PageFactory.initElements(driver, this);
	}

	// =============== Functions =====================//
	public void LoginFunction(String UserNameVal, String PasswordVal) {

		UserName.sendKeys(UserNameVal);
		test.log(LogStatus.PASS, "Enter UserName", "Name Entered successfully");

		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Password", "Password Entered successfully");

		LoginButton.click();
		test.log(LogStatus.PASS, "Click on LoginButton", "LoginButton clicked successfully");

	}

}
