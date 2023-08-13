package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class AutomationExerciseTest03 {
    /*
       1. Launch browser
       2. Navigate to url 'http://automationexercise.com'
       3. Verify that home page is visible successfully
       4. Click on 'Signup / Login' button
       5. Verify 'Login to your account' is visible
       6. Enter incorrect email address and password
       7. Click 'login' button
       8. Verify error 'Your email or password is incorrect!' is visible
     */
    @Test
    public void test03() {
        AutomationExercisePage page = new AutomationExercisePage();

        // Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExercisesUrl"));

        // Verify that home page is visible successfully
        String expectedUrl = ConfigReader.getProperty("automationExercisesUrl");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), expectedUrl);

        // Click on 'Signup / Login' button
        page.siginButton.click();

        // Verify 'Login to your account' is visible
        String expectedText = "Login to your account";
        Assert.assertEquals(expectedText, page.loginToYourAccountText.getText());

        // Enter incorrect email address and password
        page.correctEmailBox.sendKeys(ConfigReader.getProperty("incorrectEmail"));
        page.correctPasswordBox.sendKeys(ConfigReader.getProperty("incorrectPassword"));

        // Click on 'login' button
        page.loginButton.click();

        // Verify error 'Your email or password is incorrect!' is visible
        String expectedError = "Your email or password is incorrect!";
        Assert.assertEquals(expectedError, page.incorrectEmailorPasswordMessage.getText());


    }
}
