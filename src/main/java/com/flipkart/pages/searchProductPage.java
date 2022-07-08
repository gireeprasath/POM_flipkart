package com.flipkart.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.base.TestBase_1;

public class searchProductPage extends TestBase_1{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	By searchLoc = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input");
	
	public boolean validateSearchProduct(String productName) {
		
		driver.findElement(searchLoc).sendKeys(productName);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		driver.findElement(searchLoc).sendKeys(Keys.ENTER);
		
		boolean flagResult = true;
		
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/div[1]/div[3]/a")));	
		}catch(TimeoutException te) {
			captureScreenshot("Search Failure");
			flagResult = false;
		}
		
		if(flagResult) {
		String actResult = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/div[1]/div[3]/a")).getText();
		return actResult.equals("Laptops");
		}
		else 
		return false;

	}

	public void captureScreenshot(String string) {
		// TODO Auto-generated method stub
		
	}
	

}
