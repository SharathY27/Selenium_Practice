package pratice_With_UI_Automation_Playground;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Runner {
	static WebDriver driver;

	static void move_To_Element_With_ActionClass(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public static void takeScreenShot() throws IOException {
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("Screenshots/snap.png");
		FileUtils.copyFile(srcFile, DestFile);
	}

	static void dynamic_Id() throws InterruptedException, IOException {
		WebElement dynamic_Id = driver.findElement(By.xpath("//a[text()='Dynamic ID']"));
		move_To_Element_With_ActionClass(dynamic_Id);
		Thread.sleep(2000);
		dynamic_Id.click();
		Thread.sleep(2000);
		takeScreenShot();
	}

	static void waitUntilPageIsLoaded(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (js.executeScript("return document.readyState").equals("complete")) {
			System.out.println("Page loaded");
		}
	}

	static void load_Delay() throws IOException, InterruptedException {
		WebElement loadDelayLink = driver.findElement(By.xpath("//a[text()='Load Delay']"));
		move_To_Element_With_ActionClass(loadDelayLink);
		scroll_To_Element_View(loadDelayLink);
		takeScreenShot();
		loadDelayLink.click();
		waitUntilPageIsLoaded(driver);

	}

	static void scroll_To_Element_View(WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(3000);
	}

	static void ajax_Request() throws InterruptedException {
		WebElement ajax = driver.findElement(By.xpath("//a[text()='AJAX Data']"));
		scroll_To_Element_View(ajax);
		ajax.click();
		Thread.sleep(3000);
		driver.findElement(By.id("ajaxButton")).click();
		Thread.sleep(16000);
		WebElement ajaxData = driver.findElement(By.xpath("//div[@id='content']/p"));
		System.out.println("Ajax Text : " + ajaxData.getText());

	}

	static void scrollBar() throws InterruptedException, IOException {
		WebElement scroll = driver.findElement(By.xpath("//a[text()='Scrollbars']"));
		scroll.click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		Thread.sleep(2000);
		WebElement hidingButton = driver.findElement(By.xpath("//button[@id='hidingButton']"));
		move_To_Element_With_ActionClass(hidingButton);
//		scroll_To_Element_View(hidingButton);
		takeScreenShot();
	}

	static void non_breaking_space() throws IOException {
		WebElement non_break = driver.findElement(By.xpath("//a[text()='Non-Breaking Space']"));
		non_break.click();
		WebElement ele = driver.findElement(By.xpath("//button[translate(.,'\u00A0',' ')='My Button']"));
		ele.click();
		highlightingElement(ele);
		takeScreenShot();
	}

	public static void highlightingElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');", element);
	}

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("http://www.uitestingplayground.com/");
		driver.manage().window().maximize();

		try {
//			dynamic_Id();
//			load_Delay();
//			ajax_Request();
//			scrollBar();
			non_breaking_space();
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.close();
		
		//https://www.automationexercise.com/login

	}

}
