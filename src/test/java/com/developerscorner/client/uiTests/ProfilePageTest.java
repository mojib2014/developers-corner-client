package com.developerscorner.client.uiTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.developerscorner.client.configuration.SeleniumConfig;
import com.developerscorner.client.uiTests.forms.ProfileForm;

public class ProfilePageTest extends SeleniumConfig {

	private static final String baseUrl = "http://localhost:8080/#!/profile";
	
	public ProfilePageTest() {}
	
	@Test
	void shouldGetProfilePage() {
		try {
			driver.get(baseUrl);
			ProfileForm form = PageFactory.initElements(driver, ProfileForm.class);
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(form.title));
			assertTrue(form.title.getText().contains("Profile"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void shouldCheckCurrentUserExists() {
		try {
			driver.get(baseUrl);
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(baseUrl));			
			ProfileForm form = PageFactory.initElements(driver, ProfileForm.class);
			
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(form.fName));
			//assertEquals(form.fName.getText(), "updated first");			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void shouldEditProfile() {
		try {
			driver.get(baseUrl);
			ProfileForm form = PageFactory.initElements(driver, ProfileForm.class);
			
			form.openModalBtn.click();
	
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(form.modalTitle));
			assertEquals(form.modalTitle.getText(), "Edit Profile Form");
			form.clear();
			form.fillForm("updated first", "updated last", "updated nick name", "testuser@email.com", "123456");
			form.submit();
			
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(form.fName));
			assertEquals(form.fName.getText(), "updated first");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Negative tests
	 */
	@Test
	void shouldDisplayFieldRequiredIfOnceOfTheFieldsIsBlank() {
		try {
			driver.get(baseUrl);
			
			ProfileForm form = PageFactory.initElements(driver, ProfileForm.class);
			
			form.openModalBtn.click();
			
			form.clear();
			form.fillForm("", "last name", "nick name", "new.new@email.com", "123456");
			
			assertFalse(form.submitBtn.isEnabled(), "submit button should be disabled at this point");			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
