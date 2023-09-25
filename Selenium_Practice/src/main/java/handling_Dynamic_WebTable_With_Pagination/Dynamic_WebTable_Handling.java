package handling_Dynamic_WebTable_With_Pagination;

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

public class Dynamic_WebTable_Handling {

	static WebDriver driver;
	static JavascriptExecutor js;
	static int numberOfPages;
	static Actions actions;

	public static void loginPage_Action() {
		LoginPage_Elements elements = new LoginPage_Elements(driver);
		elements.getUsername().sendKeys("demo");
		elements.getPassword().sendKeys("demo");
		elements.getLogin_Button().click();
	}

	public static void homePage_Action() {
		HomePage_Elements elements = new HomePage_Elements(driver);
		try {
			if (elements.getClose_Popup().isDisplayed()) {
				elements.getClose_Popup().click();
			}
		} catch (Exception e) {
			e.getMessage();
		}

		elements.getSales_Button_From_Sidebar().click();
		elements.getOrders_Button_From_Sidebar().click();
	}

	public static void scroll_To_BottomPage() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
	}

	static void scroll_To_TopPage() {
		js.executeScript("window.scrollTo(0,0)", "");
	}

	static void scrollIntoViewOfElement(WebElement ele) {
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}

	static void finding_Number_Of_Pages_Present() {
		String text = driver.findElement(By.xpath("//*[@id=\"form-order\"]//div[@class='col-sm-6 text-end']"))
				.getText();
		System.out.println(text);

		numberOfPages = Integer.valueOf(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));

		System.out.println(numberOfPages + " pages are present");
	}

	public static void takeScreenShot() throws IOException {
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("Screenshots/snap.png");
		FileUtils.copyFile(srcFile, DestFile);
	}

	static void getTotalNumberOfRows() throws InterruptedException {

		for (int i = 1; i <= 2; i++) {
			Thread.sleep(2000);
			WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
			int nextPageNumber = Integer.valueOf(activePage.getText()) + 1;
			int totalNumberOfRows = driver.findElements(By.xpath("//table//tbody//tr")).size();
			System.out.println(
					"Total Number Of Rows Present in page " + activePage.getText() + " is " + totalNumberOfRows);
			for (int r = 1; r <= totalNumberOfRows; r++) {
				String customer = driver.findElement(By.xpath("//table/tbody//tr[" + String.valueOf(r) + "]//td[4]"))
						.getText();
				String status = driver.findElement(By.xpath("//table/tbody//tr[1]//td[5]/label")).getText();
				String total = driver.findElement(By.xpath("//table/tbody//tr[1]//td[6]")).getText();
				String orderId = driver.findElement(By.xpath("//table/tbody//tr["+r+"]//td[2]")).getText();
				if (orderId.trim().equals("2170")) {
					System.out.println("Order id is : " + orderId);
					driver.findElement(By.xpath("//table/tbody//tr[1]//td[1]/input[@type='checkbox']")).click();
					Thread.sleep(2000);
					try {
						takeScreenShot();
					} catch (IOException e) {
						System.out.println("=======================");
					}
				}
				if (status.equals("Pending")) {
					System.out.println("Customer Name : " + customer + ", Total is : " + total);
				}

			}

			if (!(nextPageNumber <= 2)) {
				break;
			}
			WebElement nextPage = driver.findElement(By
					.xpath("//*[@id=\"form-order\"]//ul[@class='pagination']//li//a[text()='" + nextPageNumber + "']"));
			System.out.println("Next PageNumber is : " + nextPageNumber);
			scrollIntoViewOfElement(nextPage);
			Thread.sleep(2000);

			nextPage.click();
			scroll_To_TopPage();
			Thread.sleep(3000);

		}
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
		driver.get("https://demo.opencart.com/admin/index.php?");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		try {
			loginPage_Action();
			Thread.sleep(3000);
			homePage_Action();
			finding_Number_Of_Pages_Present();
			Thread.sleep(2000);
			getTotalNumberOfRows();

		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();

	}

}
