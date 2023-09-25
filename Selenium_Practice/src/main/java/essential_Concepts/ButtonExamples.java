package essential_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonExamples {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		// 1.Button position
		WebElement getButtonPosition = driver.findElement(By.id("position"));
		Point xyPoint = getButtonPosition.getLocation();
		int x = xyPoint.getX();
		int y = xyPoint.getY();
		System.out.println(x + " " + y);

		// 2.ColorButton
		WebElement buttonColor = driver.findElement(By.id("color"));
		String color = buttonColor.getCssValue("background-color");
		System.out.println(color);

		// 3.Button dimension
		WebElement buttonSize = driver.findElement(By.id("size"));
		int height = buttonSize.getSize().getHeight();
		int width = buttonSize.getSize().getWidth();
		System.out.println(height + " " + width);

		// 4.homepage
		driver.findElement(By.id("home")).click();

		Thread.sleep(3000);
		driver.quit();
	}

}
