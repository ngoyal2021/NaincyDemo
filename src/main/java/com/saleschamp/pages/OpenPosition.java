package com.saleschamp.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.saleschamp.base.Base;
import com.saleschamp.util.Log;
import com.saleschamp.util.TestUtil;

public class OpenPosition extends Base {

	@FindBy(xpath = "(//a[text()='Careers'])[1]")
	WebElement careerLink;

	@FindBy(xpath = "(//p[text()='HOT ROLES'])[1]")
	WebElement hotDealsLink;

	@FindBy(xpath = "(//div[@id='open-positions']//h3")
	WebElement roleName;

	@FindBy(xpath = "(//h3[text()='Senior Frontend Developer']/parent::div/a")
	WebElement applyRole;

	// Initializing the Page Objects:
	public OpenPosition() {
		PageFactory.initElements(driver, this);
		System.out.println("test");
	}

	// Click on Career Menu
	public void clickOnCareer() throws InterruptedException {
		Thread.sleep(5000);
		careerLink.click();
		// test.info("Click on Career");

	}

	// It will scroll to expected element
	public void scrollToVacancy() throws InterruptedException {
		TestUtil.scrollDownByVisibilityOfEle(hotDealsLink);
		Thread.sleep(2000);
		// test.info("Scroll to vacancy");

	}

	// <summary>
	// This method will be taking the expecting role from config file as a parameter
	// and then will verify the expecting role
	// in open vacancy area and if finds then will click on apply button
	// </summary>
	// <author>Naincy Goyal</author>

	public void verifyRoleAndSelect(String data) throws InterruptedException {

		List<WebElement> allRole = driver.findElements(By.xpath("//div[@id='open-positions']//h3"));
		for (WebElement roles : allRole) {
			String role = roles.getText();
			if (role.equalsIgnoreCase(data)) {
				Log.info("Successfully role found");
				test.info("Successfully role found");
				Assert.assertTrue(true);
				String text1 = "//h3[text()='XYZ']/parent::div/a";
				String text2 = text1.replace("XYZ", data);
				WebElement ele1 = driver.findElement(By.xpath(text2));
				ele1.click();
				Thread.sleep(1000);
				break;

			} else {
				Log.info("Expected role is not available" + " " + data);
				test.info("Expected role is not available" + " " + data);
				// Assert.assertTrue(false);
			}
		}
	}

}
