package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenu extends PageObject {

    public TopMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "login")
    private WebElement signInButton;

    @FindBy(id = "contact-link")
    private WebElement contactUsButton;

    public TopMenu clickOnSignInButton() {
        signInButton.click();
        return this;
    }

    public TopMenu clickOnContactUsButton() {
        contactUsButton.click();
        return this;
    }
}
