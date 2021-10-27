package com.saleschamp.testcases;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import com.saleschamp.base.Base;
import com.saleschamp.pages.CandidateInfo;
import com.saleschamp.pages.OpenPosition;
import com.saleschamp.util.Log;

public class ApplyForJob extends Base {
	OpenPosition pos;
	CandidateInfo canInfo;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		// initializaton();
		pos = new OpenPosition();
		canInfo = new CandidateInfo();

	}

	@Test(groups = { "Functionality" })
	public void TC001_ApplyForRole() throws InterruptedException {

		Log.startTestCase("TC001_ApplyForRole");
		test = extent.createTest("TC001_ApplyForRole");
		System.out.print(test);
		pos.clickOnCareer();
		test.info("Click on Career");
		Thread.sleep(2000);
		pos.scrollToVacancy();
		test.info("Scroll to vacancy to check for vacancy ");
		pos.verifyRoleAndSelect(prop.getProperty("role"));
		Log.info("Verified and Select the expected role");
		test.info("Verified and applied for the expected role");
		canInfo.scrollAndVerifyTitle();
		if (canInfo.sendCandidateDetail(prop.getProperty("role"))) {
			Assert.assertTrue(true);
			Log.info("Able to receive successful message after clicking on send button");

			test.pass("Able to receive successful message after clicking on send button");
		} else {
			Assert.assertTrue(false);
			Log.info("Not able to click on send button");

		}
		Thread.sleep(2000);

		extent.flush();
	}
}