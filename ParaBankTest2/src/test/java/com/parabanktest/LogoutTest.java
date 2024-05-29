package com.parabanktest;

import java.io.IOException;
import org.testng.annotations.Test;
import com.parabankframework.LogoutObjects;

public class LogoutTest extends BaseTest{
	@Test(priority=2)

public void logoutaccount() throws IOException{
	  LogoutObjects lgout=new LogoutObjects(driver);
	  lgout.logout();

  }
}
