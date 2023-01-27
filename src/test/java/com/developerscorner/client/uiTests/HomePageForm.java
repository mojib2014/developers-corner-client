package com.developerscorner.client.uiTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageForm {

	WebDriver driver;

	public HomePageForm(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "questionBtn")
	WebElement questionBtn;
	@FindBy(how = How.ID, using = "title")
	WebElement title;
	@FindBy(how = How.ID, using = "username")
	WebElement username;
	@FindBy(how = How.ID, using = "student")
	WebElement studentRole;
	@FindBy(how = How.ID, using = "tags")
	WebElement tags;
	@FindBy(how = How.ID, using = "question")
	WebElement question;
	@FindBy(how = How.ID, using = "new-question-btn")
	WebElement newQuestionBtn;
	@FindBy(how=How.ID, using="question-form-title")
	WebElement questionFormTitle;
	@FindBy(how=How.ID, using="logoutBtn")
	WebElement logoutBtn;

	void fillForm(String testUsername, String testTags, String testQuestion) {
		username.sendKeys(testUsername);
		studentRole.click();
		tags.sendKeys(testTags);
		question.sendKeys(testQuestion);

	}

	void submit() {
		questionBtn.click();
	}
	
	void clear() {
		username.clear();
		studentRole.clear();
		tags.clear();
		question.clear();
	}
}
