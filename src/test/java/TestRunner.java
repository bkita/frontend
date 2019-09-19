import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestRunner {

    private final String URL = "http://automationpractice.com/";

    private WebDriver driver;
    private static Faker faker;
    private static String email;
    private static String password;

    private TopMenu topMenu;
    private CreateAnAccountEmailForm createAnAccountEmailForm;
    private CreateAnAccountDetailsForm createAnAccountDetailsForm;
    private MyAccount myAccount;
    private LoginForm loginForm;
    private ContactUsForm contactUsForm;

    @BeforeAll
    public static void beforeAll() {
        faker = new Faker();
        email = faker.internet().emailAddress();
        password = faker.internet().password();
    }

    @BeforeEach
    public void beforeEach() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        topMenu = new TopMenu(driver);
        createAnAccountEmailForm = new CreateAnAccountEmailForm(driver);
        createAnAccountDetailsForm = new CreateAnAccountDetailsForm(driver);
        myAccount = new MyAccount(driver);
        loginForm = new LoginForm(driver);
        contactUsForm = new ContactUsForm(driver);

        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterAll() {
        driver.quit();
    }

    @Test
    @Order(1)
    public void createAnAccountTest() {
        topMenu.clickOnSignInButton();

        createAnAccountEmailForm.waitForCreateAnAccountEmailForm()
                .enterEmail(email)
                .clickOnCreateAnAccountButton();

        createAnAccountDetailsForm.waitForCreateAnAccountDetailsForm()
                .setGenderMr()
                .enterFirstName(faker.name().firstName())
                .enterLastName(faker.name().lastName())
                .enterPassword(password)
                .setDateOfBirth("13", "2", "1990")
                .enterStreet(faker.address().streetAddress())
                .enterCity(faker.address().city())
                .selectState("Florida")
                .enterPostCode("01000")
                .enterMobileNumber("300400500")
                .enterAliasAddress(faker.address().streetAddress())
                .clickOnRegisterButton();

        myAccount.waitForMyAccountInfo();
        assertThat(myAccount.getAccountInfoText()).contains("Welcome to your account.");
    }

    @Test
    @Order(2)
    public void signInTest() {
        topMenu.clickOnSignInButton();

        loginForm.waitForLoginForm()
                .enterEmail(email)
                .enterPassword(password)
                .clickOnSignInButton();

        myAccount.waitForMyAccountInfo();
        assertThat(myAccount.getAccountInfoText()).contains("Welcome to your account.");
    }

    @Test
    @Order(3)
    public void canNotSendEmptyContactUsForm() {
        topMenu.clickOnContactUsButton();

        contactUsForm.waitForContactUsForm()
                .clickOnSendButtonWithErrors();

        assertThat(contactUsForm.getErrorMessage()).contains("Invalid email address");
    }
}
