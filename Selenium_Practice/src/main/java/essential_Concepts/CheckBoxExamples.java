package essential_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxExamples {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		// 1.select language
		WebElement language = driver.findElement(By.xpath("//*[@id='contentblock']/section/div[1]/input[1]"));
		language.click();

		// 2.check selenium is selected
		boolean status = driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/input")).isSelected();
		System.out.println("Status is " + " " + status);

		// 3.deselct selected
		boolean status1 = driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/input[1]")).isSelected();
		boolean status2 = driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/input[2]")).isSelected();

		if (status1) {
			driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/input[1]")).click();
		} else if (status2) {
			driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/input[2]")).click();

		}

		// 4.select all checkboxes

		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/input[2]")).click();
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/input[3]")).click();
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/input[4]")).click();
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/input[5]")).click();
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/input[6]")).click();

	}

}
