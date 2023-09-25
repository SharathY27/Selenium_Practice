package essential_Concepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		// 1.Frames
		driver.switchTo().frame(0);
		WebElement button1 = driver.findElement(By.id("Click"));
		button1.click();

		String text = driver.findElement(By.id("Click")).getText();
		System.out.println(text);

		driver.switchTo().defaultContent();

		// 2.Nested frames

		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		WebElement button2 = driver.findElement(By.id("Click1"));
		button2.click();

		driver.switchTo().defaultContent();
		// 3.Total no of frames
		List<WebElement> noOfFrames = driver.findElements(By.tagName("iframe"));
		int size = noOfFrames.size();

		System.out.println("No of frames is  " + size);

		driver.close();

	}

}
