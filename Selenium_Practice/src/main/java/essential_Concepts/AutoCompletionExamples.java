package essential_Concepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompletionExamples {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/autoComplete.html");
		WebElement option = driver.findElement(By.id("tags"));
		option.sendKeys("s");
		Thread.sleep(4000); // Explicit wait for options to load...two types of wait Implicit/Explicit
		List<WebElement> optionsList = driver.findElements(By.xpath("//*[@id='ui-id-1']/li"));
		System.out.println("outside loop");

		for (WebElement webElement : optionsList) {
			if (webElement.getText().equals("Selenium"))// Remember getText() method only used to get text from
														// webElement
			{
				webElement.click();
				System.out.println("In the loop");
				break;
			}
		}

		driver.close();

	}

}
