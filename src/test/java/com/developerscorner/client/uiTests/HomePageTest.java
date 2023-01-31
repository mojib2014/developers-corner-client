package com.developerscorner.client.uiTests;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.developerscorner.client.configuration.SeleniumConfig;
import com.developerscorner.client.uiTests.forms.HomePageForm;

public class HomePageTest extends SeleniumConfig {

	private static final String baseUrl = "http://localhost:8080/#!/";

	public HomePageTest() {
	}

	/**
	 * Positive tests
	 */
	@Test
	void shoulGetHomePage() {
		try {
			driver.get(baseUrl);
			new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.urlToBe(baseUrl));
			HomePageForm form = PageFactory.initElements(driver, HomePageForm.class);

			assertEquals(form.title.getText(), "Welcome to Developers Corner");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void shouldCreateQuestion() {
		try {
			driver.get(baseUrl);
			new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.urlToBe(baseUrl));
			
			HomePageForm form = PageFactory.initElements(driver, HomePageForm.class);

			form.fillForm("testuser", "Java", "Java data types");

			assertTrue(form.questionBtn.isEnabled(), "Button should be eanbled at this point");
			form.submit();
			
			new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(form.newQuestionBtn));
			form.newQuestionBtn.click();
			
			new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(form.questionFormTitle));
			
			assertTrue(form.questionFormTitle.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Negative tests
	 */
	@Test
	void shouldDisplayFieldIsRequiredIfUsernameNotFilled() {
		driver.get(baseUrl);
		HomePageForm form = PageFactory.initElements(driver, HomePageForm.class);
		
		form.fillForm("", "Spring MVC", "Selenium automated test in spring");
		
		assertEquals(form.usernameRequired.getText(), "This is a required field");
		assertFalse(form.questionBtn.isEnabled());
	}
}
