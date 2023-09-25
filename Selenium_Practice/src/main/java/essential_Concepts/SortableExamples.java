package essential_Concepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableExamples {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://leafground.com/pages/sortable.html");
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='sortable']/li"));

		WebElement from = elements.get(6);
		WebElement to = elements.get(0);

		Actions action = new Actions(driver);

		// one method
//		action.dragAndDrop(from, to);
//		
//		Thread.sleep(3000);
//		
//		action.build().perform();

		// another method

		action.clickAndHold(from);
		action.moveToElement(to);
		action.release(to);
		action.build().perform();

		System.out.println("Task done");

	}

}
