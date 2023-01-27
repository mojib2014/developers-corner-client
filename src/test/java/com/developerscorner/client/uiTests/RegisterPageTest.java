package com.developerscorner.client.uiTests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.developerscorner.client.configuration.SeleniumConfig;

public class RegisterPageTest extends SeleniumConfig {

	private static final String baseUrl = "http://localhost:8080/";
	
	public RegisterPageTest() {}

	@Test
	public void shouldRegisterAUser() {
		driver.get(baseUrl);

		HomePageForm homeForm = PageFactory.initElements(driver, HomePageForm.class);
		
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(homeForm.logoutBtn));
		homeForm.logoutBtn.click();
		
		driver.get(baseUrl + "#!/register"); 

		RegisterForm form = PageFactory.initElements(driver, RegisterForm.class);
		
		form.clear();
		form.fillForm("new user", "user new", "nick n", "Mentor", "new.user@email.com", "123456");

		new Actions(driver).moveToElement(form.registerBtn).pause(Duration.ofSeconds(2)).click().perform();

		new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(form.email));
		assertEquals(form.email.getText(), "new.user@email.com");
	}
}
