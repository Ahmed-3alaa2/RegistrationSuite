package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
				
	}
	
	@FindBy(css = "li.d-none.d-md-block.fl")
	WebElement Dropdownlist;
	
	@FindBy(linkText = "Logout")
	WebElement logoutBtn;
	
	@FindBy(name = "username")
	WebElement Email;
	
	@FindBy(name = "password")
	WebElement Password;
	
	@FindBy(css = "button.btn.btn-primary.btn-lg.btn-block.loginbtn")
	public WebElement LoginBtn;
	
	public void UserLogout() {
	
		Dropdownlist.click();
	  logoutBtn.click();
	
	}
	
	public void UserLogin(String username,String password) {
		Email.sendKeys(username);
		Password.sendKeys(password);
		LoginBtn.click();
	}

}
