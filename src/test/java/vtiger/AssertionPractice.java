package vtiger;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice 
{
	@Test
	public void test()
	{
		System.out.println("Step1");
		System.out.println("Step2");

		System.out.println("Step3");
Assert.assertEquals(true, false);
		System.out.println("Step4");
		System.out.println("Step5");
		System.out.println("Step6");
		System.out.println("Step7");

	}
	@Test
	public void test1()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("Step1");
		System.out.println("Step2");
sa.assertFalse(false);
		System.out.println("Step3");
		sa.assertEquals(false, true);
		System.out.println("Step4");
		System.out.println("Step5");
		System.out.println("Step6");
		System.out.println("Step7");
		sa.assertAll();

	}

}
