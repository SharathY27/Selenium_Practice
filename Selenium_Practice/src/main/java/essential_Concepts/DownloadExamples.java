package essential_Concepts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadExamples {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/download.html");
		WebElement file = driver.findElement(By.linkText("Download Excel"));
		file.click();

		Thread.sleep(4000); // for file to download

		File fileLocation = new File("C:\\Users\\sharathkumar.y\\Downloads");

		File[] totalFiles = fileLocation.listFiles();

		for (File files : totalFiles) {
			if (files.getName().equals("WrapperMethods.txt")) {
				System.out.println("File is present");
				break;
			}
		}

		driver.close();

	}

}
