package com.developerscorner.client.uiTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class QuestionsPageForm {

	WebDriver driver;
	
	public QuestionsPageForm(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how=How.ID, using="title")
	WebElement title;
	@FindBy(how=How.ID, using="username")
	WebElement username;
	@FindBy(how=How.ID, using="openModal")
	WebElement openModal;
	@FindBy(how=How.CLASS_NAME, using="modal-title")
	WebElement modalTitle;
	@FindBy(how=How.ID, using="formUsername")
	WebElement formUsername;
	@FindBy(how=How.ID, using="mentor")
	WebElement mentorRole;
	@FindBy(how=How.ID, using="tags")
	WebElement tags;
	@FindBy(how=How.ID, using="question")
	WebElement question;
	@FindBy(how=How.ID, using="submitBtn")
	WebElement submitBtn;
	@FindBy(how=How.ID, using="removeBtn")
	@CacheLookup
	WebElement removeBtn;
	
	void fillForm(String testUsername, String testTags, String testQuestion) {
		formUsername.sendKeys(testUsername);
		mentorRole.click();
		tags.sendKeys(testTags);
		question.sendKeys(testQuestion);
	}
	
	void submit() {
		submitBtn.click();
	}
	
	void clear() {
		formUsername.clear();
		mentorRole.clear();
		tags.clear();
		question.clear();
	}
}
