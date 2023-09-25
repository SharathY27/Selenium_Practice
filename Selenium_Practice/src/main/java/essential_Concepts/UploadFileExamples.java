package essential_Concepts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFileExamples {

	public static void main(String[] args) throws AWTException, InterruptedException {
//		WebDriverManager.chromedriver().setup();
		WebDriverManager.edgedriver().setup();
//		System.setProperty("webdriver.chrome.driver","D:/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://leafground.com/pages/upload.html");
//		WebElement uploadButton = driver.findElement(By.name("filename"));

		WebElement uploadButton = driver.findElement(By.xpath("//div[@id='mydiv']/input"));

		Thread.sleep(3000);
//		driver.findElement(By.name("filename")).sendKeys(Keys.ENTER);
		System.out.println("0");
		uploadButton.click();

//		Thread.sleep(5000);
		System.out.println("1");

		String location = "C:\\Users\\sharathkumar.y\\Downloads\\WrapperMethods.txt";
		StringSelection selection = new StringSelection(location);

//		for copying contents into clipboard(like cut,copy) we use Toolkit class in java

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

//		Now we copied the link and we have to paste the link in file selection window after clicking upload button

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		driver.close();

	}

}
