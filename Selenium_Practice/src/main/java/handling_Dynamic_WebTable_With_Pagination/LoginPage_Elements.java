package handling_Dynamic_WebTable_With_Pagination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Elements {

	WebDriver driver;

	@FindBy(id = "input-username")
	private WebElement username;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(xpath = "//button[text()[normalize-space()='Login']]")
	private WebElement login_Button;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin_Button() {
		return login_Button;
	}

	public LoginPage_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
