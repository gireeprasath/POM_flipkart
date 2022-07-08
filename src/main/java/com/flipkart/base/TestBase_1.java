package com.flipkart.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase_1 {
	public static WebDriver driver;
	FileInputStream fis;
	Properties prop;

	public void launchBrowser() {

		String fileName = ".\\src\\main\\resources\\Config\\config.properties";

		try {
			fis = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		prop = new Properties();

		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (prop.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
	}

	public void navigateToURL() {
		driver.get(prop.getProperty("URL"));
	}

	
	
	public void captureScreenshot(String msg) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
		String dateTime = sdf.format(date);
		String fileName = "screenshot_" + dateTime;
		
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".\\src\\test\\resources\\Screenshots\\" + fileName + ".png");
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
