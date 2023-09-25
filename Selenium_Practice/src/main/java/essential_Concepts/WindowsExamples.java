package essential_Concepts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver","D:/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		WebElement firstButton = driver.findElement(By.id("home"));
		firstButton.click();
		String oldWindow = driver.getWindowHandle();// it will store parent window
		Set<String> allWindows = driver.getWindowHandles(); // it will store all windows
		for (String newWindows : allWindows) {
			driver.switchTo().window(newWindows);
		}

		WebElement editButton = driver.findElement(By.xpath("//*[@id='post-153']/div[2]/div/ul/li[1]/a/img"));
		editButton.click();
		System.out.println("ok1");
		driver.close();
		System.out.println("ok2");
//		driver.switchTo().defaultContent(); //it is not working  and its only for frames
//		driver.switchTo.defaultContent(), it will take you to i1, whereas 
//		with driver.switchTo.parentFrame() control will switch to i2 i.e. immediate parent frame
		driver.switchTo().window(oldWindow);
		System.out.println("ok3");
		WebElement multipleWindow = driver
				.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/button"));
		multipleWindow.click();

		int size = driver.getWindowHandles().size();
		System.out.println("No of windows opened is " + " " + size);

		WebElement dontCloseMe = driver.findElement(By.id("color"));
		dontCloseMe.click();

		Set<String> newWindows = driver.getWindowHandles();
		for (String windows : newWindows) {
			if (!windows.equals(oldWindow)) {
				driver.switchTo().window(windows);
				driver.close();
			}
		}

	}

}
