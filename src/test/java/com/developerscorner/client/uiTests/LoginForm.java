package com.developerscorner.client.uiTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginForm {

	WebDriver driver;

	public LoginForm(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "loginBtn")
	WebElement loginBtn;
	@FindBy(how = How.ID, using = "title")
	WebElement title;
	@FindBy(how = How.ID, using = "email")
	public WebElement email; // Email and Password public so that we can use it in config
	@FindBy(how = How.ID, using = "password")
	public WebElement password;

	public void fillForm(String testEmail, String pass) {
		email.sendKeys(testEmail);
		password.sendKeys(pass);
	}

	public void clear() {
		email.clear();
		password.clear();
	}

	public void submit() {
		loginBtn.click();
	}
}
