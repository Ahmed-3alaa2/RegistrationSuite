package tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;

public class TestBase {
	public   WebDriver driver;
	// initialize proxy to monitor request and save response in har file
	BrowserMobProxy proxy = new BrowserMobProxyServer();
	@BeforeSuite
	public void StartDriver() {
		proxy.start();
		Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		proxy.newHar("PhpTravel");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//driver//chromedriver.exe");
		driver = new ChromeDriver(capabilities);
		proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT,CaptureType.REQUEST_HEADERS,CaptureType.RESPONSE_HEADERS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.phptravels.net/Register");

	}


	@AfterSuite
	public void TearDown() {
		Har har = proxy.getHar();
		try {
			// getting post response from harfile
			har.getLog().getEntries().removeIf(x-> !x.getRequest().getUrl().equals("https://www.phptravels.net/account/signup"));
			har.writeTo(new File(System.getProperty("user.dir") + "\\har\\Response-Information.har"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		proxy.stop();
		driver.close();
	}

	/*
	 * // @AfterMethod // public void screenshotonfailure(ITestResult result) throws
	 * IOException { // if(result.getStatus() == ITestResult.FAILURE) { //
	 * System.out.println("Failed"); // Helper.captureScreenshot(driver,
	 * result.getName()); // driver.close(); // } // }
	 */
}