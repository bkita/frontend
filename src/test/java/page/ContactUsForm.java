package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsForm extends PageObject {

    public ContactUsForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "contact-form-box")
    private WebElement contactUsForm;

    @FindBy(id = "submitMessage")
    private WebElement sendButton;

    @FindBy(className = "alert-danger")
    private WebElement errorBox;

    public ContactUsForm waitForContactUsForm() {
        wait.until(ExpectedConditions.visibilityOf(contactUsForm));
        return this;
    }

    public ContactUsForm clickOnSendButtonWithErrors() {
        sendButton.click();
        return this;
    }

    public ContactUsForm waitForErrorBox() {
        wait.until(ExpectedConditions.visibilityOf(errorBox));
        return this;
    }

    public String getErrorMessage() {
        waitForErrorBox();
        return errorBox.getText();
    }
}
