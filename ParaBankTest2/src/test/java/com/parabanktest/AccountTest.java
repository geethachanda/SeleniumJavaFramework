package com.parabanktest;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.parabankframework.RegisterObjects;

public class AccountTest extends BaseTest{
	private static Logger logger= LogManager.getLogger(AccountTest.class);
  @Parameters({"browservalue","uname"})
	@Test(priority=1)
	public void accountSuccess(String browservalue, String uname) throws IOException, InterruptedException{
	  
		setUp(browservalue);
		logger.info("Welcome to ParaBank login page");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		RegisterObjects reg=new RegisterObjects(driver);
	
		try {
		reg.assertfields();
		logger.info("Navigated to Registration page");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		    logger.error("Exception occured", new Exception("Assertion failed"));
		}
		reg.regiterdata(uname);
		logger.info("Registration successful");

		
		
	}

}
