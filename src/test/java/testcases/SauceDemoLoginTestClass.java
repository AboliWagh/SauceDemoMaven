package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.SaucedemoLoginPage;

public class SauceDemoLoginTestClass extends SauceDemoBaseClass{

//********** TESTS **********//
	
//////////LOGIN LoginFailureTest /////////////
@Test
public void LoginFailureTest() {
test = report.startTest("LoginFailureTest");

SaucedemoLoginPage login = new SaucedemoLoginPage();
login.LoginFunction("abc@qwe.com", "Xyzabcd@1234");

WebElement ErrorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
String ActualMsg = ErrorMsg.getText();
String ExpeMsg = "Epic sadface: Username and password do not match any user in this service";

if (ActualMsg.equals(ExpeMsg)) {
	System.out.println("TC Passed");

} else {
	System.out.println("TC Failed");
}

report.endTest(test);

}

//////////LOGIN SUCESS  with parameterizedTest /////////////

@Test
@Parameters({"Param1","Param2"})
public void parameterizedTest(String UserNameVal, String PasswordVal) {
test = report.startTest("parameterizedTest");

SaucedemoLoginPage login = new SaucedemoLoginPage();
login.LoginFunction(UserNameVal, PasswordVal);

report.endTest(test);
}


//////////LOGIN SUCESS  with External data fetching /////////////
@Test
public void ExcelDataTest() {
test = report.startTest("ExcelDataTest");

String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();

SaucedemoLoginPage login = new SaucedemoLoginPage();
login.LoginFunction(UserNameVal, PasswordVal);

report.endTest(test);

}
}
