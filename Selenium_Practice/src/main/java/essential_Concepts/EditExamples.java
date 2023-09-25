package essential_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditExamples {

	public static void main(String[] args) {
		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		// 1. email
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("mani27899@gmail.com");

		// 2.Append text
		WebElement append = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/input"));
		append.sendKeys("name here");

		// 3.get default text
//		WebElement default1 = driver.findElement(By.name("usernmae"));
//		String value = default1.getAttribute("value");
		String value = driver.findElement(By.name("username")).getAttribute("value");
		System.out.println(value);
		// 4.clear default text
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div/div/input")).clear();

		WebElement disabled = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[5]/div/div/input"));
		boolean status = disabled.isEnabled();
		System.out.println(status);
		driver.quit();

	}

}
