package com.developerscorner.client.uiTests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.developerscorner.client.configuration.SeleniumConfig;
import com.developerscorner.client.uiTests.forms.HomePageForm;
import com.developerscorner.client.uiTests.forms.RegisterForm;

public class RegisterPageTest extends SeleniumConfig {

	private static final String baseUrl = "http://localhost:8080/#!/register";
	private static final String homePageUrl = "http://localhost:8080/#!/";

	public RegisterPageTest() {
	}

	@Test
	public void shouldRegisterAUser() {
		driver.get(baseUrl);
		new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.urlToBe(baseUrl));

		RegisterForm form = PageFactory.initElements(driver, RegisterForm.class);

		form.fillForm("new user", "user new", "nick n", "Mentor", "new.user@email.com", "123456");
		assertTrue(form.registerBtn.isEnabled());
		form.submit();
	}

	/**
	 * Negative tests
	 */

	@Test
	void shouldDisplayFieldIsRequiredIfOneOfTheFieldIsBlank() {
		driver.get(homePageUrl);
		new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.urlToBe(homePageUrl));
		
		HomePageForm homeForm = PageFactory.initElements(driver, HomePageForm.class);
		homeForm.logoutBtn.click();


		driver.get(baseUrl);
		new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.urlToBe(baseUrl));

		RegisterForm form = PageFactory.initElements(driver, RegisterForm.class);

		form.fillForm("", "user new", "nick n", "Mentor", "new.user@email.com", "123456");
		assertFalse(form.registerBtn.isEnabled());
	}
}
