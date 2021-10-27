package com.saleschamp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.saleschamp.base.Base;
import com.saleschamp.util.Log;
import com.saleschamp.util.TestUtil;

public class CandidateInfo extends Base {

	@FindBy(xpath = "//h4[text()='Apply for a role ']")
	WebElement applyTitle;

	@FindBy(xpath = "//label[text()='Name*']/following-sibling::input")
	WebElement nameText;

	@FindBy(xpath = "//label[text()='Email Address*']/following-sibling::input")
	WebElement emailText;

	@FindBy(xpath = "//label[text()='Message*']/following-sibling::textarea")
	WebElement messageText;

	@FindBy(xpath = "//span[@id='recaptcha-anchor']")
	WebElement captchaCheckbox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitButton;

	@FindBy(xpath = "//iframe[@title='reCAPTCHA']")
	WebElement reCaptchaIframe;

	@FindBy(xpath = "//button[@title='Help']")
	WebElement reCaptchaHelpIcon;

	@FindBy(xpath = "//div[contains(text(),'Thank you!')]")
	WebElement thankHeader;

	@FindBy(xpath = "//iframe[@title='recaptcha challenge']")
	WebElement reCaptchaIframeChallenge;

	// Initializing the Page Objects:
	public CandidateInfo() {
		PageFactory.initElements(driver, this);
	}

	// <summary>
	// This method will scroll and then verify whether scroll at right element or
	// not
	// </summary>
	// <author>Naincy Goyal</author>

	public void scrollAndVerifyTitle() {
		TestUtil.scrollDownByVisibilityOfEle(applyTitle);
		String text = applyTitle.getText();
		if (text.equalsIgnoreCase("Apply for a role")) {
			System.out.println("Scrolled at right element");
			test.info("scroll to fill candidate information");
		} else {
			System.out.println("Scrolled at incorrect element");
			test.fail("Candidate Information form is not displaying");
		}

	}

	// <summary>
	// This method will enter few information and then will click on Send button
	// without Recaptcha checkbox checked- to verify
	// whether getting an alert or not , will accept the alert and then will click
	// on Send button
	// After click on send button will verify the success message
	// </summary>
	// <returns>returns true/false</returns>
	// <author>Naincy Goyal</author>

	public boolean sendCandidateDetail(String data) throws InterruptedException {
		String name = TestUtil.randomString();
		nameText.sendKeys(name);
		emailText.sendKeys(name + "@" + "gmail.com");
		messageText.sendKeys("Apply for Role:" + " " + data);
		Thread.sleep(5000);
		submitButton.click();
		if (TestUtil.isAlertPresent()) {
			TestUtil.moveToIframeAndSelectCheckbox(captchaCheckbox, reCaptchaIframe);
		}
		if (submitButton.isDisplayed()) {
			submitButton.click();
			test.info("Handled captcha and click on send button");
			TestUtil.scrollDownByVisibilityOfEle(thankHeader);
			Thread.sleep(2000);
		} else {
			Log.error("Recaptcha is not going away before timeout");
			test.fail("Recaptcha is not going away before timeout");
		}
		if (thankHeader.isDisplayed()) {

			Log.info("Successfully applied for role");
			test.pass("Successfully applied for role");
			Assert.assertTrue(true);
			return true;

		} else {

			Log.error("Success message is not getting displayed");
			test.fail("Send button is not clcikable- Success message is not getting displayed");
			Assert.assertTrue(false);
			return false;
		}
	}
}
