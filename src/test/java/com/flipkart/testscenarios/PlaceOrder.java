package com.flipkart.testscenarios;

import org.testng.annotations.Test;


import com.flipkart.base.TestBase_1;
import com.flipkart.pages.Loginpage_1;
import com.flipkart.pages.searchProductPage;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class PlaceOrder extends TestBase_1 {
  
  @BeforeClass
  public void beforeClass() {
	  launchBrowser();
	  navigateToURL();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  @Test(priority = 1)
  public void loginTest() {
	  Loginpage_1 loginPage = new Loginpage_1();
		boolean actResult = loginPage.validateLogin("9715092092", "prasath");
		Assert.assertTrue(actResult);
  }
  @Test(priority = 2)
  public void searchProductTest() {
	  searchProductPage searchProd = new  searchProductPage();
	  boolean actResult = searchProd.validateSearchProduct("laptops");
		Assert.assertTrue(actResult);
	  
  }
  @Test
  public void selectProductTest() {
  }
  @Test
  public void addToCartTest() {
  }
  @Test
  public void confirmOrderTest() {
  }
  @Test
  public void makePaymentTest() {
  }
  @Test
  public void logoutTest() {
  }

}
