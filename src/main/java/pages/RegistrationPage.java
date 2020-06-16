package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase {
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name="firstname")
	WebElement FirstName;
	
	@FindBy(name="lastname")
	WebElement LastName;
	
	@FindBy(name="phone")
	WebElement Phone;
	
	@FindBy(name="email")
	WebElement Email;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(name="confirmpassword")
	WebElement ConfirmPassword;
	
	@FindBy(className = "signupbtn")
	WebElement SignupBtn;
	
	@FindBy(id = "bookings")
	public WebElement Text;
	
	public void UserRegistration(String firstname,String lastname,String phone,String email,String password) {
		FirstName.sendKeys(firstname);
		LastName.sendKeys(lastname);
		Phone.sendKeys(phone);
		Email.sendKeys(email);
		Password.sendKeys(password);
		ConfirmPassword.sendKeys(password);
		SignupBtn.click();
	}
}
