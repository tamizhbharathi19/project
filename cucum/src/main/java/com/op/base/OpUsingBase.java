package com.op.base;


import java.io.IOException;

import org.openqa.selenium.By;

import junit.framework.Assert;

public class OpUsingBase extends OpBaseClass {
	public static void main(String[] args) throws IOException, InterruptedException {
		
	       LaunchBrowser("chrome");
	       URLLaunch("https://opencart.abstracta.us/");
	        
	       clickButton(driver.findElement(By.xpath("//span[text()='My Account']//parent::a")));
	       clickButton(driver.findElement(By.linkText("Register")));
	       clickButton(driver.findElement(By.linkText("Login")));// To click Register
	       SendKeyToElement(driver.findElement(By.id("input-email")),("xyz12@gmail.com"));
	       SendKeyToElement(driver.findElement(By.id("input-password")),("abc1234"));
	       clickButton(driver.findElement(By.xpath("//input[@type='submit']")));
	       SendKeyToElement(driver.findElement(By.xpath("//input[@placeholder='Search']")),("Nikon D300"));
			clickButton(driver.findElement(By.xpath("//i[@class='fa fa-search']")));
			clickButton(driver.findElement(By.linkText("Nikon D300")));
			SendKeyToElement(driver.findElement(By.id("input-quantity")),("1"));
			clickButton(driver.findElement(By.id("button-cart")));// Add to Cart
			clickButton(driver.findElement(By.xpath("//span[text()='Checkout']")));// Click Checkout

			clickButton(driver.findElement(By.xpath("(//input[@value='Continue'])[1]")));// To Continue
			System.out.println("Click on continue");
			clickButton(driver.findElement(By.xpath("(//input[@value='Continue'])[2]")));// To Continue
			// d.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Eagerly
			// waiting to capture memories");
			System.out.println("Entered text");
			clickButton(driver.findElement(By.id("button-shipping-method")));// To Continue
			System.out.println("Click checkbox");
			clickButton(driver.findElement(By.xpath("//input[@name='agree']")));// To Continue
			System.out.println("checkbox clicked");
			clickButton(driver.findElement(By.id("button-payment-method")));// To Continue
			clickButton(driver.findElement(By.id("button-confirm")));// To Confirm Order
			// String OrderPlaced = d.findElement(By.xpath("//div//h1")).getText();
			//TakesScreenshot ts = (TakesScreenshot) driver;
			screenShot("placedOrder");
			String OrderTitle =Title();
			System.out.println("Order Placed::::");
			Assert.assertEquals("Your order has been placed!", OrderTitle);
			clickButton(driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")));
			clickButton(driver.findElement(By.linkText("Logout")));
			String Logout= Title();
			Assert.assertEquals("Account Logout", Logout);  
			driver.close();
	}

}
