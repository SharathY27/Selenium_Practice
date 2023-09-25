package essential_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImagesInteractionExamples {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");

		WebElement firstImage = driver.findElement(By.xpath("//*[@id='contentblock']/section/div[1]/div/div/img"));
		firstImage.click();

		driver.navigate().back();// it will move back to same page

		WebElement secondImage = driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/img"));

		// naturalWidth is a css attribute...If it is 0 then it is a broken image else
		// not broken image

		if (secondImage.getAttribute("naturalWidth").equals("0")) {
			System.out.println("It is a broken image");
		} else {
			System.out.println("It is a normal image");
		}

	}

}
