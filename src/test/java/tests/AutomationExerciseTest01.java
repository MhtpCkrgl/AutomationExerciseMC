package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class AutomationExerciseTest01 {
    /*
    TASK:
      1. Launch Browser
      2. Navigate to url 'http://automationexercise.com'
      3. Verify that home page is visible successfully
      4. Click on 'Signup/Login' button
      5. Verify 'New User Signup!' is visible
      6. Enter name and email
      7. Click 'Signup' button
      8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
      9. Fill Title, Name, Email, Password, Date of birth areas
      10. Select checkbox 'Sign up for our newsletter!'
      11. Select checkbox 'Receive special offers from our partners!'
      12. Fill First name, Last name, Company, Address, Address2, Country, State,
      City, Zipcode, Mobile Number areas
      13. Click 'Create Account button'
      14. Verify that 'ACCOUNT CREATED!' is visible
      15. Click 'Continue' button
      16. Verify that 'Logged in as username' is visible
      17. Click 'Delete Account' button
      18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */
    AutomationExercisePage page = new AutomationExercisePage();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();
    String fakeMail = faker.internet().emailAddress();
    String fakeName = faker.name().firstName();
    String fakeLastName = faker.name().lastName();
    String companyName = faker.company().name();
    String adress = faker.address().fullAddress();
    String phone = faker.phoneNumber().phoneNumber();
    String fakePassword = faker.internet().password();

    @Test
    public void test01() {
        // Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExercisesUrl"));


        // Verify that home page is visible successfully
        String expectedUrl = ConfigReader.getProperty("automationExercisesUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        // Click on 'Signup / Login' button
        page.siginButton.click();

        // Verify 'New User Signup!' is visible
        Assert.assertTrue(page.newUserSignUp.isDisplayed());

        // Fill details: Title, Name, Email, Password, Date of birth


        actions.click(page.userName).sendKeys(fakeName, Keys.TAB, fakeMail, Keys.TAB, Keys.ENTER).perform();

        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(page.enterAccountInfo.isDisplayed());


        if (!page.titleButton.isSelected()) {
            page.titleButton.click();
        }

        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.TAB, Keys.TAB, fakePassword, Keys.TAB, "2", Keys.TAB, "January" + Keys.ENTER, Keys.TAB,
                "1990" + Keys.ENTER).perform();
        ReusableMethods.bekle(2);

        // Select checkbox 'Sign up for our newsletter!'
        // Select checkbox 'Receive special offers from our partners!'
        ReusableMethods.scroll(page.checkBox1);
        if (!page.checkBox1.isSelected()) {
            page.checkBox1.click();
        }
        ReusableMethods.scroll(page.checkBox2);
        if (!page.checkBox2.isSelected()) {
            page.checkBox2.click();
        }

        // Fill First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number and create account.

        page.fillName.sendKeys(fakeName, Keys.TAB, fakeLastName, Keys.TAB, companyName, Keys.TAB, adress, Keys.TAB, adress,
                Keys.TAB, "Türkiye", Keys.TAB, "Ankara", Keys.TAB, "Çankaya", Keys.TAB, "06890", Keys.TAB, phone, Keys.TAB, Keys.ENTER);

        // Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(page.accountCreatedText.isDisplayed());

        // Click 'Continue' button
        page.continueButton.click();

        // Close popup
        Driver.getDriver().switchTo().frame(0);
        ReusableMethods.bekle(3);
        page.closeButton.click();
        Driver.getDriver().switchTo().defaultContent();

        // Verify that 'Logged in as username' is visible
        Assert.assertTrue(page.loggedInAsUsername.isDisplayed());

        // Click 'Delete Account' button
        page.deleteAccountButton.click();

        // Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(page.accountDeletedMessage.isDisplayed());

    }
}