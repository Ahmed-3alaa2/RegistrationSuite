package tests;




import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.RegistrationPage;

public class PageRegistrationTest extends TestBase {
HomePage homepage ;
RegistrationPage registrationpage;

Faker fakerdata = new Faker();
String firstname = fakerdata.name().firstName();
String lastname= fakerdata.name().lastName();
String phonenumber = fakerdata.phoneNumber().cellPhone();
String email = fakerdata.internet().emailAddress();
String password = fakerdata.number().digits(8).toString();

@Test(priority = 1)
public void UserRegistration() {
	homepage= new HomePage(driver);
	registrationpage = new RegistrationPage(driver);
	registrationpage.UserRegistration(firstname, lastname, phonenumber, email, password);
	// check if word "booking" displayed or not after registration
	Assert.assertTrue(registrationpage.Text.isDisplayed());
}

@Test(priority = 2)
public void Userlogout() {
	homepage= new HomePage(driver);
	homepage.UserLogout();
	//check loging btn displayed after logging out
	Assert.assertTrue(homepage.LoginBtn.isDisplayed());
}

@Test(priority = 3)
public void Userlogin() {
	homepage= new HomePage(driver);
	homepage.UserLogin(email, password);
	//check booking keyword displayed after successful login 
	Assert.assertTrue(registrationpage.Text.isDisplayed());
}


}
