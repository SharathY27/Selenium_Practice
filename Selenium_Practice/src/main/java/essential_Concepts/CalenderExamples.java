package essential_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://leafground.com/pages/Calendar.html");
		WebElement date = driver.findElement(By.id("datepicker"));

		date.click();

//		date.sendKeys("27/08/1999");//one method
//		
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
//		Calendar cal = Calendar.getInstance();
//		System.out.println("Todays date is " + dateFormat.format(date1));

		// a[@title='Next'] //for next month

		WebElement selecter = driver.findElement(By.xpath("//a[@title='Next']"));

		selecter.click();

		// a[contains(text(),10)] //for day picking

		WebElement daySelect = driver.findElement(By.xpath("//a[contains(text(),10)]"));

		daySelect.click();

	}

}
