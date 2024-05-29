package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.parabanktest.BaseTest;

public class Listeners extends BaseTest implements ITestListener{
    ExtentTest test;
  ExtentReports	extent=Reports();

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Method started"+ result.getName());
		test= extent.createTest(result.getMethod().getMethodName());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String filePath=null;
		try {
			driver= (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("Method failed"+ result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.fail(result.getThrowable());
	

       try {
		 filePath= screenshot(result.getMethod().getMethodName(), driver);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Method skipped"+ result.getName());
			}



	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Method passed"+ result.getName());
	      test.log(Status.PASS, "Test Pass");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}

