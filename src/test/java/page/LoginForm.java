package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginForm extends PageObject {

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login_form")
    private WebElement loginForm;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    public LoginForm waitForLoginForm() {
        wait.until(ExpectedConditions.visibilityOf(loginForm));
        return this;
    }

    public LoginForm enterEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public LoginForm enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginForm clickOnSignInButton() {
        signInButton.click();
        return this;
    }
}
