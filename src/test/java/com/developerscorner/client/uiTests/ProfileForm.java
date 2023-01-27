package com.developerscorner.client.uiTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfileForm {

	WebDriver driver;
	
	public ProfileForm(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how=How.ID, using="title")
	WebElement title;
	
	@FindBy(how=How.ID, using="email")
	@CacheLookup
	WebElement email;
	
	@FindBy(how=How.ID, using="openModalBtn")
	WebElement openModalBtn;
	
	@FindBy(how=How.CLASS_NAME, using="modal-title")
	WebElement modalTitle;
	
	@FindBy(how=How.ID, using="closeModal")
	WebElement closeModal;
	
	@FindBy(how=How.ID, using="firstName")
	WebElement firstName;
	
	@FindBy(how=How.ID, using="lastName")
	WebElement lastName;
	
	@FindBy(how=How.ID, using="nickName")
	WebElement nickName;
	
	@FindBy(how=How.ID, using="formEmail")
	WebElement formEmail;
	
	@FindBy(how=How.ID, using="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.ID, using="submitBtn")
	WebElement submitBtn;
	
	void fillForm(String fName, String lName, String nName, String email, String pass) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		nickName.sendKeys(nName);
		formEmail.sendKeys(email);
		password.sendKeys(pass);
	}
	
	void submit() {
		submitBtn.click();
	}
	
	void clear() {
		firstName.clear();
		lastName.clear();
		nickName.clear();
		formEmail.clear();
		password.clear();
	}
}
