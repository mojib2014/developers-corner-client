package com.developerscorner.client.uiTests;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.developerscorner.client.configuration.SeleniumConfig;

public class LoginPageTest extends SeleniumConfig {

	private String baseUrl = "http://localhost:8080/#!/login";
	
	public LoginPageTest() {}
	
	@Test
	public void shouldGetLoginPage() {
		driver.get(baseUrl);
		
		LoginForm form = PageFactory.initElements(driver, LoginForm.class);
		
		assertEquals(form.title.getText(), "Login Form");
	}
	
	@Test
	public void shouldLogInAUser() {
		try {
			driver.get(baseUrl);
			
			LoginForm form = PageFactory.initElements(driver, LoginForm.class);
			
			form.fillForm("testuser@email.com", "123456");
			
			new Actions(driver).moveToElement(form.loginBtn).pause(Duration.ofSeconds(2)).click().perform();
			new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(form.email));
			assertEquals(form.email.getText(), "testuser@email.com");			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
