package com.developerscorner.client.uiTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.developerscorner.client.configuration.SeleniumConfig;
import com.developerscorner.client.uiTests.forms.HomePageForm;
import com.developerscorner.client.uiTests.forms.QuestionsPageForm;

public class QuestionsPageTest extends SeleniumConfig {

	private static final String baseUrl = "http://localhost:8080/#!/questions";
	private static final String homePageUrl = "http://localhost:8080/#!/";

	public QuestionsPageTest() {
	}

	/**
	 * Positive tests
	 */
	@Test
	void shouldGetQuestionsPage() {
		try {
			driver.navigate().to(baseUrl);
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(baseUrl));
			
			QuestionsPageForm form = PageFactory.initElements(driver, QuestionsPageForm.class);

			assertEquals(form.title.getText(), "Your Questions");
			assertEquals(form.username.getText(), "testuser");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void shouldCreateQuestion() {
		try {
			driver.get(homePageUrl);
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(homePageUrl));
			
			HomePageForm form = PageFactory.initElements(driver, HomePageForm.class);

			form.fillForm("testuser", "Java", "Generics example");

			assertTrue(form.questionBtn.isEnabled(), "Button should be eanbled at this point");
			form.submit();
			
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(form.newQuestionBtn));
			form.newQuestionBtn.click();
			
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(form.questionFormTitle));
			
			assertTrue(form.questionFormTitle.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void shouldEditAQuestion() {
		try {
			driver.get(baseUrl);
			QuestionsPageForm form = PageFactory.initElements(driver, QuestionsPageForm.class);
			
			form.openModal.click();
	
			assertEquals(form.modalTitle.getText(), "Edit Question Form");
			
			form.clear();
			form.fillForm("testuser", "Java", "Spring mvc unit test with testNg");
			
			assertTrue(form.submitBtn.isEnabled(), "The submit button is enalbed at this point");
			form.submit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void shouldDeleteAQuestion() {
		try {
			driver.navigate().to(baseUrl);
			QuestionsPageForm form = PageFactory.initElements(driver, QuestionsPageForm.class);
			
			form.removeBtn.click();
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfAllElements(form.username));
			assertNull(form.username.getText());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Negative tests
	 */
	@Test
	void shouldDisplayFieldRequiredIfOneOfTheFieldsIsBlank() {
		try {
			driver.navigate().to(baseUrl);
			QuestionsPageForm form = PageFactory.initElements(driver, QuestionsPageForm.class);
			
			form.openModal.click();
			form.clear();
			form.fillForm("", "JavaScript", "JavaScript scope");
			
			assertFalse(form.submitBtn.isEnabled(), "The submit button should be disabled at this point");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
