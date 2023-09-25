package essential_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkExamples {

	public static void main(String[] args) throws InterruptedException {

		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		// WebElement homepage = driver.findElement(By.linkText("Go to Home Page"));
		WebElement homepage = driver.findElement(By.partialLinkText("Home Page"));
		homepage.click();
		driver.quit();
		// driver.close();

	}

}
