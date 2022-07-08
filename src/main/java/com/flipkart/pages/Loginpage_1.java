package com.flipkart.pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.base.TestBase_1;


public class Loginpage_1 extends TestBase_1 {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	
	By userNameLoc = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input");
	
	By passwordLoc = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input");
	
	By loginButtonLoc = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button");
	
	public  boolean validateLogin(String uName, String pwd) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.findElement(userNameLoc).sendKeys(uName);
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(passwordLoc).sendKeys(pwd);
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(loginButtonLoc).click();
		
		
		boolean flagResult = true;
		
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")));	
			}catch(TimeoutException te) {
				captureScreenshot("Login Failure");
				flagResult = false;
			}
		
		
		if(flagResult) {
			String actResult = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")).getText();
			return actResult.equals("Giree Prasath");
			}
			else 
			return false;
		}
}


