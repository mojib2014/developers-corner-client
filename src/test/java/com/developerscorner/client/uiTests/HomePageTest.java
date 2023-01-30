package com.developerscorner.client.uiTests;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.developerscorner.client.configuration.SeleniumConfig;

public class HomePageTest extends SeleniumConfig {

	private static final String baseUrl = "http://localhost:8080/#!/";

	public HomePageTest() {
	}

	@Test
	void shoulGetHomePage() {
		try {
			driver.get(baseUrl);
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
			HomePageForm form = PageFactory.initElements(driver, HomePageForm.class);

			form.clear();
			form.fillForm("testuser", "Java", "Java data types");

			new Actions(driver).moveToElement(form.questionBtn).pause(Duration.ofSeconds(2)).click().perform();

			new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(form.tags));
			assertEquals(form.tags.getText(), "Java");
			
			new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(form.newQuestionBtn));
			form.newQuestionBtn.click();
			
			new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(form.questionFormTitle));
			
			assertTrue(form.questionFormTitle.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
