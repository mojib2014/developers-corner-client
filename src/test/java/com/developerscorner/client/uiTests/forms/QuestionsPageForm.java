package com.developerscorner.client.uiTests.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class QuestionsPageForm {

	WebDriver driver;
	
	public QuestionsPageForm(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how=How.ID, using="title")
	public WebElement title;
	@FindBy(how=How.XPATH, using="//*[@id=\"username\"]")
	public WebElement username;
	@FindBy(how=How.XPATH, using="//*[@id=\"openModal\"]")
	public WebElement openModal;
	@FindBy(how=How.CLASS_NAME, using="modal-title")
	public WebElement modalTitle;
	@FindBy(how=How.ID, using="formUsername")
	public WebElement formUsername;
	@FindBy(how=How.ID, using="mentor")
	public WebElement mentorRole;
	@FindBy(how=How.ID, using="tags")
	public WebElement tags;
	@FindBy(how=How.ID, using="question")
	public WebElement question;
	@FindBy(how=How.ID, using="submitBtn")
	public WebElement submitBtn;
	@FindBy(how=How.XPATH, using="//*[@id=\"removeBtn\"]")
	public WebElement removeBtn;
	
	public void fillForm(String testUsername, String testTags, String testQuestion) {
		formUsername.sendKeys(testUsername);
		mentorRole.click();
		tags.sendKeys(testTags);
		question.sendKeys(testQuestion);
	}
	
	public void submit() {
		submitBtn.click();
	}
	
	public void clear() {
		formUsername.clear();
		tags.clear();
		question.clear();
	}
}
