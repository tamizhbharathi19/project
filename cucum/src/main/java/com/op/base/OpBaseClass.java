package com.op.base;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class OpBaseClass {
	 public static WebDriver driver;

	public static void LaunchBrowser(String browser) {

		try {
			if (browser.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						"E:\\Users\\Tamizholi\\eclipse-workspace-oxy\\cucum\\src\\test\\resource\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void URLLaunch(String url) {
		try {
			driver.get(url);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String Title() {
		String title = driver.getTitle();
		return title;

	}

	public static void VisibilityOfElement(WebElement element) 
	{
		WebDriverWait wb = new WebDriverWait(driver, 30);
		wb.until(ExpectedConditions.visibilityOf(element));

	}

	public static void SendKeyToElement(WebElement element, String value) {
		VisibilityOfElement(element);
		boolean displayed = element.isDisplayed();
		boolean enabled = element.isEnabled();
		if (displayed && enabled) {
			element.clear();
			element.sendKeys(value);
		
	
		}
}
	public static void screenShot(String name) {

		try {

			TakesScreenshot ts = (TakesScreenshot) driver;

			File f = ts.getScreenshotAs(OutputType.FILE);

			File f1 = new File(System.getProperty("user.dir") + "/Result/" + name + ".png");

			FileUtils.copyFile(f, f1);

		} catch (Exception e) {

			System.out.println("Unable to take screenshot");
		}
		
	}
		public static void clickButton(WebElement element) {

			try {

				element.click();

			} catch (Exception e) {

				System.out.println("Unable to click the button");
			}

		}
	
		public static void QuitBrowser() {
			driver.quit();
			System.out.println("Testing Completed successfully");

		}

}
