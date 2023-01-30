package com.developerscorner.client.uiTests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.developerscorner.client.configuration.SeleniumConfig;

public class RegisterPageTest extends SeleniumConfig {

	private static final String baseUrl = "http://localhost:8080/#!/";
	
	public RegisterPageTest() {}
	
	@Test
	public void shouldRegisterAUser() {
		driver.get(baseUrl);
		
		new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.urlToBe(baseUrl));
		HomePageForm homeForm = PageFactory.initElements(driver, HomePageForm.class);
		new Actions(driver).moveToElement(homeForm.logoutBtn).pause(Duration.ofSeconds(2)).click().perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.localStorage.removeItem('token')");
//		System.out.println("current url ================" + driver.getCurrentUrl());
		
		driver.get(baseUrl + "register"); 
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(baseUrl + "register"));
		
		RegisterForm form = PageFactory.initElements(driver, RegisterForm.class);
		
		form.fillForm("new user", "user new", "nick n", "Mentor", "new.user@email.com", "123456");
		System.out.println("the form was ======================" + form.email.getText());
//		new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(form.email));
//		assertEquals(form.email.getText(), "new.user@email.com");
		form.submit();

	}
}
