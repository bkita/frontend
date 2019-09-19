package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAnAccountEmailForm extends PageObject {

    public CreateAnAccountEmailForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "create-account_form")
    private WebElement createAnAccountEmailForm;

    @FindBy(id = "email_create")
    private WebElement createAnAccountInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountButton;

    public CreateAnAccountEmailForm waitForCreateAnAccountEmailForm() {
        wait.until(ExpectedConditions.visibilityOf(createAnAccountEmailForm));
        return this;
    }

    public CreateAnAccountEmailForm enterEmail(String email) {
        createAnAccountInput.click();
        createAnAccountInput.sendKeys(email);
        return this;
    }

    public CreateAnAccountEmailForm clickOnCreateAnAccountButton(){
        createAnAccountButton.click();
        return this;
    }
}
