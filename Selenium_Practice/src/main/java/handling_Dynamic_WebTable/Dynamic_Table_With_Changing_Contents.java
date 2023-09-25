package handling_Dynamic_WebTable;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_Table_With_Changing_Contents {

	public static void takeScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("Screenshots/snap.png");
		FileUtils.copyFile(srcFile, DestFile);
	}

	public static void main(String[] args) throws IOException {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("http://www.uitestingplayground.com/dynamictable");
		driver.manage().window().maximize();
		List<WebElement> columnHeaders = driver
				.findElements(By.xpath("//div[@role='table']/div[2]//span[@role='columnheader']"));

		int numberOfColumns = columnHeaders.size();

		int numberOfRows = driver.findElements(By.xpath("//div[@role='table']/div[3]/div")).size();

		Map<String, Integer> columnIndex = new HashMap<String, Integer>();
		int i = 1;
		for (WebElement ele : columnHeaders) {
			columnIndex.put(ele.getText(), i);
			i++;
		}

		takeScreenShot(driver);

		// to get network speed of Chrome
		String name = "Chrome";
		String requiredColumnValue = "CPU";
		int indexValueOfRequiredColumnValue = columnIndex.get(requiredColumnValue);
		int indexValueOfName = columnIndex.get("Name");

		System.out.println(columnIndex);
		System.out.println(indexValueOfName + " , " + indexValueOfRequiredColumnValue);

		for (int r = 1; r < numberOfRows; r++) {
			String val = driver
					.findElement(By.xpath("//div[@role='table']/div[3]/div[" + r + "]/span[" + indexValueOfName + "]"))
					.getText();
			if (val.equals(name)) {
				String result = driver.findElement(By.xpath(
						"//div[@role='table']/div[3]/div[" + r + "]/span[" + indexValueOfRequiredColumnValue + "]"))
						.getText();
				System.out.println("Result is : " + result);
				break;
			}
		}

		/*
		 * boolean flag = false; for (int r = 1; i < numberOfRows; i++) { for (int cell
		 * = 1; cell < numberOfColumns; cell++) { if
		 * (driver.findElement(By.xpath("//div[@role='table']/div[3]/div[" + r +
		 * "]/span[" + cell + "]")) .getText().equals(name)) { String requiredValue =
		 * driver .findElement(By.xpath( "//div[@role='table']/div[3]/div[1]/span[" +
		 * indexValueOfRequiredColumnValue + "]")) .getText();
		 * System.out.println("Result : " + requiredValue); flag = true; break; } } if
		 * (flag) { break; } }
		 */
		driver.close();
	}

}
