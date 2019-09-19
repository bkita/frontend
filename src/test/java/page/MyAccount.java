package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccount extends PageObject {

    public MyAccount(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "info-account")
    private WebElement accountInfoText;

    public MyAccount waitForMyAccountInfo() {
        wait.until(ExpectedConditions.visibilityOf(accountInfoText));
        return this;
    }

    public String getAccountInfoText() {
        return accountInfoText.getText();
    }
}
