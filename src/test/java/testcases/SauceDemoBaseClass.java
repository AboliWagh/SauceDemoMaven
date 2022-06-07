package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SauceDemoBaseClass {

	public static WebDriver driver;

	XSSFWorkbook wbook;
	XSSFSheet sheet;
	public static ExtentReports report;
	public static ExtentTest test;

//////////Functions/////////

	@BeforeTest
	public void DataSetUp() throws IOException {

		FileInputStream fis = new FileInputStream("exceldata.xlsx");

		wbook = new XSSFWorkbook(fis);

		sheet = wbook.getSheet("data");

		report = new ExtentReports("ExtentReport.html");
	}

	@AfterTest
	public void DataTearDown() throws IOException {

		wbook.close();
		report.flush();
		report.close();
	}

	@BeforeMethod
	public void SetUp() throws MalformedURLException {

		System.setProperty("webDriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

	}

//////////Function 2 TearDown/////////
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
