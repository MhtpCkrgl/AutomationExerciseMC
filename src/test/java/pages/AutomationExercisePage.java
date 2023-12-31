package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePage {
    public AutomationExercisePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//a[@href='/login']")
    public WebElement siginButton;


    @FindBy (xpath = "//h2[text()='New User Signup!']")
    public WebElement newUserSignUp;

    @FindBy (xpath = "//input[@name='name']")
    public WebElement userName;
    @FindBy (xpath = "//h2[@class='title text-center']")
    public WebElement enterAccountInfo;

    @FindBy (xpath = "//input[@value='Mr']")
    public WebElement titleButton;

    @FindBy (xpath = "(//input[@type='checkbox'])[1]")
    public WebElement checkBox1;

    @FindBy (xpath = "(//input[@type='checkbox'])[2]")
    public WebElement checkBox2;

    @FindBy (xpath = "//input[@id='first_name']")
    public WebElement fillName;

    @FindBy (xpath = "//b[text()='Account Created!']")
    public WebElement accountCreatedText;

    @FindBy (xpath = "//a[@class='btn btn-primary']")
    public WebElement continueButton;

    @FindBy (xpath = "//span[@class='ns-710zx-e-16']")
    public WebElement closeButton;

    @FindBy (xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
    public WebElement loggedInAsUsername;
    @FindBy (xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
    public WebElement deleteAccountButton;

    @FindBy (xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    public WebElement accountDeletedMessage;

    @FindBy (xpath = "//h2[text()='Login to your account']")
    public WebElement loginToYourAccountText;

    @FindBy (xpath = "(//input[@placeholder='Email Address'])[1]")
    public WebElement correctEmailBox;

    @FindBy (xpath = "//input[@placeholder='Password']")
    public WebElement correctPasswordBox;
    @FindBy (xpath ="//button[@type='submit']")
    public WebElement loginButton;

    @FindBy (xpath ="//*[@id=\"form\"]/div/div/div[1]/div/form/p")
    public WebElement incorrectEmailorPasswordMessage;
}
