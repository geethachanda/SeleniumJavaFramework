package com.parabanktest;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.parabankframework.LoginObjects;

public class LoginTest extends BaseTest {
	private static Logger logger= LogManager.getLogger(LoginTest.class);
	@Parameters({"uname"})
	@Test(priority=3)
	public void login(String uname) throws IOException {
		
		
		LoginObjects logintest =new LoginObjects(driver);
		logintest.loginpage(uname,"Anvi123");
		logger.info("login attempted");
		Assert.assertEquals(driver.getTitle(), "ParaBank | Accounts Overview");
	}
}
