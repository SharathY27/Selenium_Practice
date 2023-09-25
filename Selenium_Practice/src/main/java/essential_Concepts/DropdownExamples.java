package essential_Concepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownExamples {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		WebElement dropdown1 = driver.findElement(By.id("dropdown1"));
		Select select = new Select(dropdown1);
		select.selectByIndex(3);
		select.selectByVisibleText("Appium");
		select.selectByValue("4");

		List<WebElement> options = select.getOptions();
		int size = options.size();
		System.out.println(size);

		WebElement multiSelectBox = driver.findElement(By.xpath("//*[@id='contentblock']/section/div[6]/select"));
		Select multiSelect = new Select(multiSelectBox);
		multiSelect.selectByIndex(1);
		multiSelect.selectByIndex(2);
		multiSelect.selectByIndex(3);
		driver.quit();

	}

}
