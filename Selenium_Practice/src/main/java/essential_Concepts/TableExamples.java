package essential_Concepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableExamples {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://leafground.com/pages/table.html");
		
		//1.NO of columns
		List<WebElement> columns = driver.findElements(By.tagName("th"));
		int noOfColumns = columns.size();
		System.out.println("No of columns is " + noOfColumns);
		
		//2.No of rows
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		int noOfRows = rows.size();
		System.out.println("No of rows is " + noOfRows);
		
		//3. Percentage of Learn to interact with Elements
		WebElement getPercent = driver.findElement(By.xpath("//td[normalize-space() = 'Learn to interact with Elements'] //following :: td[1]"));
		
		String percentage = getPercent.getText();
		System.out.println("Percentage is  " + percentage);
		
		
		//4.Select least vital check box
		List<WebElement> progessStringValues =  driver.findElements(By.xpath("//td[2]"));
		List<Integer> progressIntegerValues = new ArrayList<Integer>();
		for(WebElement webElement : progessStringValues)
		{
			String eachValue = webElement.getText().replace("%", "");
			int integerValue = Integer.parseInt(eachValue);
			progressIntegerValues.add(integerValue);
		}
		
		System.out.println("Values of progess are " + progressIntegerValues);
		
		int leastValue = Collections.min(progressIntegerValues);
		
		//td[normalize-space()= '20%']//following :: td[1]
		String finalValue = Integer.toString(leastValue);
		
		String path = "//td[normalize-space() =" + "\"" + finalValue + "%" + "\""+ "]"  + "//following :: td[1]";
		
		System.out.println(path);
		WebElement checkBox = driver.findElement(By.xpath(path));
		
		if(!checkBox.isSelected())
		{
			checkBox.click();
		}
		
		
		
	}

}
