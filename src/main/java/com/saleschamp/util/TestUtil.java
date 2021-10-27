package com.saleschamp.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.saleschamp.base.Base;

public class TestUtil extends Base {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "C:\\SalesChamp\\com.saleschamp\\src\\main\\java\\com\\saleschamp\\testdata\\OpenPosition.xlsx";

	static DateFormat dateFormat;
	static Date date;

	static JavascriptExecutor js;
	public static final String DateFormat = "yyyyMMddHH:mm:ss";

	// <summary>
	// This method will take the screenshot and wil copy the screenshot in
	// destination where filename contains date to identify uniquely
	// </summary>
	// <author>Naincy Goyal</author>

	public static String takeScreenshotAtEndOfTest(String filename) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + filename + "_" + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;

	}

	public static String getDate(String format) {
		dateFormat = new SimpleDateFormat(format);
		date = new Date();
		return dateFormat.format(date);
	}

	// <summary>
	// This method will scroll to expecting element
	// </summary>
	// <author>Naincy Goyal</author>

	public static void scrollDownByVisibilityOfEle(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);
	}

	// <summary>
	// This method helps to create random string.
	// </summary>
	// <returns>returns string</returns>
	// <author>Naincy Goyal</author>
	public static String randomString() {

		String character = "abcdefghijklmnopqrstuvwzyz";
		String randomString = "";
		int length = 5;
		Random rand = new Random();
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = character.charAt(rand.nextInt(character.length()));
		}

		for (int i = 0; i < text.length; i++) {
			randomString += text[i];
		}
		return randomString;
	}

	// <summary>
	// This method helps to click on element which resides in iframe and to resume
	// it will come back on
	// original window
	// </summary>
	// <author>Naincy Goyal</author>
	public static void moveToIframeAndSelectCheckbox(WebElement ele, WebElement iframe) throws InterruptedException {

		// switch to frame by element
		driver.switchTo().frame(iframe);
		// Perform all the required tasks
		ele.click();
		Thread.sleep(50000);
		// Switching back to the main window
		driver.switchTo().defaultContent();
	}

	// <summary>
	// This method helps to accept an alert
	// </summary>
	// <author>Naincy Goyal</author>
	public static boolean isAlertPresent() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			// alert.dismiss();
		} catch (NoAlertPresentException e) {

		}
		return true;
	}
}
