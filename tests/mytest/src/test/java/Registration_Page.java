import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration_Page extends PageBase{

    private By usernameLocator = By.xpath("//*[@id='app']/div/div[2]/div/div[2]/div/div/div/form/span[1]/input");
    private By passwordLocator = By.xpath("//*[@id='app']/div/div[2]/div/div[2]/div/div/div/form/span[2]/input");
    private By confirmPassLocator = By.xpath("//*[@id='app']/div/div[2]/div/div[2]/div/div/div/form/span[3]/input");
    private By emailLocator = By.xpath("//*[@id='app']/div/div[2]/div/div[2]/div/div/div/form/span[4]/input");
    private By signupLocator = By.xpath("//*[@id='app']/div/div[2]/div/div[2]/div/div/div/button");
    private By studentLocator = By.xpath("//*[@id='__next']/div/div/div[2]/div[1]");

    public Registration_Page(WebDriver driver) {
        super(driver);
    }

    public Registration_Page createAccountForRegistration(String username, String email, String password, String confirmPassword) {
        this.waitAndReturnElement(usernameLocator).sendKeys(username);
        this.waitAndReturnElement(passwordLocator).sendKeys(password);
        this.waitAndReturnElement(confirmPassLocator).sendKeys(confirmPassword);
        this.waitAndReturnElement(emailLocator).sendKeys(email);

        this.waitAndReturnElement(signupLocator).click();

        return new Registration_Page(driver);
    }

}
