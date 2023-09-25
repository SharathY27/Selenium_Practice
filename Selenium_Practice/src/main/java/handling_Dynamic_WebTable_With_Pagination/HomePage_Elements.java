package handling_Dynamic_WebTable_With_Pagination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_Elements {

	WebDriver driver;
	
	@FindBy(xpath = "//h5[text()[normalize-space()='Important Security Notification!']]/following-sibling::button")
	private WebElement close_Popup;

	@FindBy(xpath = "//ul[@id='menu']//li/a[text()[normalize-space()='Sales']]")
	private WebElement sales_Button_From_Sidebar;

	@FindBy(xpath = "//ul[@id='menu']//li//ul//li/a[text()[normalize-space()='Orders']]")
	private WebElement orders_Button_From_Sidebar;

	public WebElement getClose_Popup() {
		return close_Popup;
	}

	public WebElement getSales_Button_From_Sidebar() {
		return sales_Button_From_Sidebar;
	}

	public WebElement getOrders_Button_From_Sidebar() {
		return orders_Button_From_Sidebar;
	}
	
	public HomePage_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
