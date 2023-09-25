package essential_Concepts;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		// 1. first button
		WebElement firstRadio = driver.findElement(By.className("myradio"));
		firstRadio.click();

		// 2.second button

		WebElement checked = driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/input[2]"));
		boolean status = checked.isSelected();
		if (status == true) {
			System.out.println("Checked is select");
		} else
			System.out.println("Unchecked is selected");

		// WebElement selectAge =
		// driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/div/div/input[2]"));
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if (age > 1 && age < 21) {
			WebElement below20 = driver
					.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/div/div/input[1]"));
			below20.click();
		} else if (age > 40) {
			WebElement above40 = driver
					.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/div/div/input[3]"));
			above40.click();

		}
	}

}
