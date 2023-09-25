package essential_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenGoogle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("report.html");
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);

		ExtentTest test = extentReports.createTest("Whatapp Duck");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.findElement(By.name("q")).sendKeys("Priyanka Mohan");
		driver.findElement(By.name("q")).submit();
		test.pass("Test Passed");
		driver.quit();
		extentReports.flush();

	}
}
