package essential_Concepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLinkAdvancedExamples {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		driver.get("http://leafground.com/pages/Link.html");
		driver.navigate().to("http://leafground.com/pages/Link.html");

//		driver.get dont have back , forward and refresh functions 
//		driver.navigate.to() method has back,forward and refresh functions
		WebElement homePage = driver.findElement(By.partialLinkText("Home Page"));
		homePage.click();
		System.out.println("1");
		driver.navigate().back();
//		driver.navigate().forward();

//		2.Find where am supposed to go without clicking me?

		WebElement whereToGo = driver.findElement(By.partialLinkText("Find where"));
		String destination = whereToGo.getAttribute("href");
		System.out.println("Link is going to " + " " + destination);

		// 3.Verify am I broken

		WebElement brokenCheck = driver.findElement(By.partialLinkText("Verify"));
		brokenCheck.click();
		String title = driver.getTitle();
		if (title.contains("404")) {
			System.out.println("Link is broken");
		} else {
			System.out.println("Link is not broken");
		}
		driver.navigate().back();

		homePage.click();

		// StaleElementReferenceException
//		It will cause beacuse element may be missing or after page refresh all content sets to new properties...
//		so we cannot access web element with existing created web element after refresh....
//		Solution : create new web element and call it will work

		driver.navigate().back();

		// 4.find total number of <a> tag
		List<WebElement> numberOfTags = driver.findElements(By.tagName("a"));
		int total = numberOfTags.size();
		System.out.println("Number of links is " + " " + total);

		driver.close();

	}

}
