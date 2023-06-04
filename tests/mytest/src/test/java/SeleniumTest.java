import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.*;

import org.junit.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class SeleniumTest {
	
	private WebDriver driver;
    private Properties properties;
    private String[] staticPages;

    @Before
    public void setup() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "/home/tmkkassa/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();

        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        this.driver.manage().window().maximize();

        properties = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    @Test
    public void testInvalidLogin() {
        MainPage mainPageResult = new MainPage(this.driver);
        Login_Page loginPage = mainPageResult.accessLogin();
        String email = "abebebikila@gmail.com";
        String password = "romemarathon";
        Dashboard_Page dashboardPage = loginPage.logIn(email, password);
        System.out.println("invalid "+dashboardPage.getBodyText());
        String dashboardBodyTextContains = properties.getProperty("dashboard.body.text.contains");        
        assertTrue(dashboardPage.getBodyText().contains(dashboardBodyTextContains));
    }
    public Dashboard_Page login() {
        MainPage mainPageResult = new MainPage(this.driver);
        Login_Page loginPage = mainPageResult.accessLogin();
        String email = properties.getProperty("user.email");
        String password = properties.getProperty("user.password");
        return loginPage.logIn(email, password);
    }

    @Test
    public void testLogin() {
        Dashboard_Page dashboardPage = login();
        System.out.println("helloooooooooooo "+dashboardPage.getBodyText());
        String dashboardBodyTextContains = properties.getProperty("dashboard.body.text.contains");
        assertTrue(dashboardPage.getBodyText().contains(dashboardBodyTextContains));
        
    }

    @Test
    public void testStaticPageLoad() {
        // MainPage mainPageResult = new MainPage(this.driver);
        String staticPagesString = properties.getProperty("static.pages");
        staticPages = staticPagesString.split(",");
        // String staticPageTitle = properties.getProperty("static.page.title");

        for (String url : staticPages) {
            Static_Page_Load staticPage = new Static_Page_Load(this.driver, url);
            staticPage.navigateToPage();
            Assert.assertTrue(staticPage.getBodyText().contains("LeetCode"));
        }
    }

    @Test
    public void testRegistrationPage() {
        MainPage mainPageResult = new MainPage(this.driver);
        Login_Page loginPage = mainPageResult.accessLogin();
        Registration_Page registrationPage = loginPage.createAccount();
        String username = properties.getProperty("user.registration.username");
        String email = properties.getProperty("user.registration.email");
        String password = properties.getProperty("user.registration.password");

        registrationPage.createAccountForRegistration(username, email, password,password);
        // Wait for the element with "I am a" text to be visible on the page
        WebDriverWait wait = new WebDriverWait(driver, 10);
        By bodyTextLocator = By.xpath("//*[contains(text(), 'I am a')]");
        WebElement bodyTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(bodyTextLocator));
        assertTrue(registrationPage.getBodyText().contains("I am a"));
        
    }

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}