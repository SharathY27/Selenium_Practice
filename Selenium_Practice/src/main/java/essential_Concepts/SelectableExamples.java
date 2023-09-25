package essential_Concepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectableExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/selectable.html");
		List<WebElement> selectable = driver.findElements(By.xpath("//*[@id='selectable']/li"));
		int size = selectable.size();
		System.out.println(size);

		Actions action = new Actions(driver);
		// first method
		// action.keyDown(Keys.CONTROL).click(selectable.get(0)).click(selectable.get(1)).click(selectable.get(2)).build().perform();
		// second method
//		for(int k=0;k<3;k++)
//		{
//			action.keyDown(Keys.CONTROL).click(selectable.get(k));
//		}
		// third method
		for (int k = 0; k < 3; k++) {
			action.clickAndHold(selectable.get(k));
		}
		action.release();
		action.build().perform();

	}

}
