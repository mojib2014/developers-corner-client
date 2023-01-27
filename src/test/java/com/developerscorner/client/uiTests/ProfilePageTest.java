package com.developerscorner.client.uiTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.developerscorner.client.configuration.SeleniumConfig;

public class ProfilePageTest extends SeleniumConfig {

	private static final String baseUrl = "http://localhost:8080/#!/profile";
	
	public ProfilePageTest() {}
	
	@Test
	void shouldGetProfilePage() {
		try {
			driver.get(baseUrl);
			ProfileForm form = PageFactory.initElements(driver, ProfileForm.class);
			new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(form.title));
			assertTrue(form.title.getText().contains("Profile"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void shouldCheckCurrentUserExists() {
		try {
			driver.get(baseUrl);
			ProfileForm form = PageFactory.initElements(driver, ProfileForm.class);
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(form.email));
			assertEquals(form.email.getText(), "testuser@email.com", "Current email is not the same as expected email");			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void shouldEditProfile() {
		try {
			driver.get(baseUrl);
			ProfileForm form = PageFactory.initElements(driver, ProfileForm.class);
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(form.modalTitle));
			assertEquals(form.modalTitle.getText(), "Edit Profile Form");
			
			form.fillForm("updated first", "updated second", "updated nick name", "updated@email.com", "updated");
			new Actions(driver).moveToElement(form.submitBtn).pause(Duration.ofSeconds(5)).click().perform();
			assertEquals(form.firstName.getText(), "updated first");
			form.closeModal.click();
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(form.email));
			assertEquals(form.email.getText(), "updated@email.com", "Current email is not the same as expected email");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
