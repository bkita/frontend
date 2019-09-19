package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountDetailsForm extends PageObject {

    public CreateAnAccountDetailsForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "account-creation_form")
    private WebElement createAnAccountDetailsForm;

    @FindBy(id = "id_gender1")
    private WebElement genderMr;

    @FindBy(id = "id_gender2")
    private WebElement genderMrs;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daySelect;

    @FindBy(id = "months")
    private WebElement monthSelect;

    @FindBy(id = "years")
    private WebElement yearSelect;

    @FindBy(id = "address1")
    private WebElement streetInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "id_state")
    private WebElement stateSelect;

    @FindBy(id = "postcode")
    private WebElement postCodeInput;

    @FindBy(id = "phone_mobile")
    private WebElement mobileNumberInput;

    @FindBy(id = "alias")
    private WebElement aliasAddressInput;

    @FindBy(id = "submitAccount")
    private WebElement submitAccountButton;

    public CreateAnAccountDetailsForm waitForCreateAnAccountDetailsForm() {
        wait.until(ExpectedConditions.visibilityOf(createAnAccountDetailsForm));
        return this;
    }

    public CreateAnAccountDetailsForm setGenderMr() {
        genderMr.click();
        return this;
    }

    public CreateAnAccountDetailsForm setGenderMrs() {
        genderMrs.click();
        return this;
    }

    public CreateAnAccountDetailsForm enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public CreateAnAccountDetailsForm enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public CreateAnAccountDetailsForm enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public CreateAnAccountDetailsForm setDateOfBirth(String day, String month, String year) {
        new Select(daySelect).selectByValue(day);
        new Select(monthSelect).selectByValue(month);
        new Select(yearSelect).selectByValue(year);
        return this;
    }

    public CreateAnAccountDetailsForm enterStreet(String street) {
        streetInput.sendKeys(street);
        return this;
    }

    public CreateAnAccountDetailsForm enterCity(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    public CreateAnAccountDetailsForm selectState(String state) {
        new Select(stateSelect).selectByVisibleText(state);
        return this;
    }

    public CreateAnAccountDetailsForm enterPostCode(String postCode) {
        postCodeInput.sendKeys(postCode);
        return this;
    }

    public CreateAnAccountDetailsForm enterMobileNumber(String mobileNumber) {
        mobileNumberInput.sendKeys(mobileNumber);
        return this;
    }

    public CreateAnAccountDetailsForm enterAliasAddress(String aliasAddress) {
        aliasAddressInput.clear();
        aliasAddressInput.sendKeys(aliasAddress);
        return this;
    }

    public CreateAnAccountDetailsForm clickOnRegisterButton() {
        submitAccountButton.click();
        return this;
    }
}
