package com.developerscorner.client.uiTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.developerscorner.client.configuration.SeleniumConfig;

public class QuestionsPageTest extends SeleniumConfig {

	private static final String baseUrl = "http://localhost:8080/#!/questions";

	public QuestionsPageTest() {
	}

	@Test
	void shouldGetQuestionsPage() {
		try {
			driver.get(baseUrl);

			QuestionsPageForm form = PageFactory.initElements(driver, QuestionsPageForm.class);

			new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(form.title));
			new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(form.username));

			assertEquals(form.title.getText(), "Your Questions");
			assertEquals(form.username.getText(), "testuser");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void shouldEditAQuestion() {
		try {
			driver.get(baseUrl);
			
			QuestionsPageForm form = PageFactory.initElements(driver, QuestionsPageForm.class);
			
			new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(form.openModal));
			form.openModal.click();
			
			new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(form.modalTitle));
			assertEquals(form.modalTitle.getText(), "Edit Question Form");
			
			form.clear();
			form.fillForm("testuser", "Java", "Spring mvc unit test with testNg");
			
			form.submit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void shouldDeleteAQuestion() {
		try {
			driver.get(baseUrl);
			
			QuestionsPageForm form = PageFactory.initElements(driver, QuestionsPageForm.class);
			
			new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(form.removeBtn));
			form.removeBtn.click();
			
			assertFalse(form.removeBtn.isDisplayed());
			assertNull(form.username.getText());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
