package window_Handling;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Runner {

	static WebDriver driver;

	// To open new Tab

	public static void open_New_Tab(String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open()");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(url);
		driver.close();
		driver.switchTo().window(tabs.get(0));
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://demo.opencart.com/admin/index.php?");
		driver.manage().window().maximize();

		String url = "https://google.co.in";
		open_New_Tab(url);
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		open_New_Tab(url);
		driver.close();

	}

}
