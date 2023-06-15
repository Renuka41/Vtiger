package genereicUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerssimpleImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String Methodname = result.getMethod().getMethodName();
		System.out.println(Methodname+".............excution started........");
		test=report.createTest(Methodname)
;
		test.log(Status.INFO, Methodname+" ->execution Started");
		}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String Methodname = result.getMethod().getMethodName();

		System.out.println(".............excution onTestSuccess........");
		test.log(Status.PASS, Methodname+"  ->PASS");
		

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String Methodname = result.getMethod().getMethodName();

		System.out.println(Methodname+".................execution failed...................");
		System.out.println(result.getThrowable());
		
		
		
		test.log(Status.FAIL,Methodname+" ->FAIL");
		test.log(Status.WARNING,result.getThrowable());
		//take screenshot
		String screenShotName = Methodname+"-"+new JavaUtility().getSystemDate();
		WebDriverUtility wUtil= new WebDriverUtility();
		try {
			String path = wUtil.takeScreenShot(BaseClasses.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(".................execution skipped...................");

		String MethodName=result.getMethod().getMethodName();
		System.out.println(MethodName+",.............Test excution skipped..........");
	System.out.println(result.getThrowable());
	test.log(Status.SKIP,MethodName+" ->SKIP");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(".................execution failedwith the percentage...................");

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(".................execution failedwith the time out...................");

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(".................execution onStarted...................");
		 ExtentSparkReporter html=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemFormat()+".html");
		html.config().setDocumentTitle("vtiger Execution Report");
		html.config().setReportName("Execution reports BuildV2.3.1");
		html.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base brower", "chrome");
		report.setSystemInfo("Base url", "https://Testenv.com");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Reporter Name", "Renuka");
		

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(".................execution onfinished...................");

		report.flush();//it is responsible for report generation
	}
	
	

}
