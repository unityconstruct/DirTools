package com.uc.util.dirtools.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_NG {
  @Test
  public void Test_TestNGTest() {
/*		for (Constant.LoginPageElements e : Constant.LoginPageElements.values()) {
			System.out.println(
				Constant.LoginPageElements.LOGIN_TXT_USERNAME.name() + " : " + 
				Constant.LoginPageElements.LOGIN_TXT_PASSWORD.getValue()
				);
		}
			//
		System.out.println(
				Constant.DataSheet.Col_UserName.ordinal() + " : " + 
				Constant.LoginPageElements.LOGIN_TXT_USERNAME.name() + " : " + 
				Constant.LoginPageElements.LOGIN_TXT_PASSWORD.getValue() );
		System.out.println(); */
	  System.out.println("TestNGTest()");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("WTF");
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
