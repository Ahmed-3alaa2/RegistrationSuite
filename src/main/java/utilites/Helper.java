package utilites;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
public static void captureScreenshot(WebDriver driver , String screenshotname) throws IOException {
		
		Path destination = Paths.get("./Screenshots",screenshotname+".png");
		Files.createDirectories(destination.getParent());
		FileOutputStream out = new FileOutputStream(destination.toString());
		out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
		out.close();
	}
}
