package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class AutomatioExerciseTest02 {

    //NOTE: In order to work successfully this test  first you have to register or you dont work deletion steps
    //At the and of test registration have deleted

    @Test
    public void test02() {
        AutomationExercisePage page = new AutomationExercisePage();

        // Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExercisesUrl"));

        // Verify that home page is visible successfully
        String expectedUrl = ConfigReader.getProperty("automationExercisesUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        // Click on 'Signup / Login' button
        page.siginButton.click();

        // Verify 'Login to your account' is visible
        String expectedText = "Login to your account";
        Assert.assertEquals(expectedText, page.loginToYourAccountText.getText());

        // Enter correct email address and password
        page.correctEmailBox.sendKeys(ConfigReader.getProperty("correctMail"));
        page.correctPasswordBox.sendKeys(ConfigReader.getProperty("correctPassword"));


        // Click on 'login' button
        page.loginButton.click();

        // Verify that 'Logged in as username' is visible
        Assert.assertTrue(page.loggedInAsUsername.isDisplayed());

        // Click 'Delete Account' button
        page.deleteAccountButton.click();

        // Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(page.accountDeletedMessage.isDisplayed());
    }
}
