import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Login_Page extends PageBase {

    private By usernameFieldLocator = By.xpath("//*[@id='id_login']");
    private By passwordFieldLocator = By.xpath("//*[@id='id_password']");
    private By loginButtonLocator = By.xpath("//*[@id='signin_btn']");
    private By createAccountLocator = By.xpath("//*[@id='app']/div/div[2]/div/div[2]/div/div/div/div[1]/span");


    public Login_Page(WebDriver driver) {
        super(driver);
        this.driver.get("https://leetcode.com/accounts/login/");
    }

    public Dashboard_Page logIn() {
        return new Dashboard_Page(this.driver);
    }

    public Dashboard_Page logIn(String username, String password) {
        this.waitAndReturnElement(usernameFieldLocator).sendKeys(username);
        this.waitAndReturnElement(passwordFieldLocator).sendKeys(password);
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("initial-loading")));
        this.waitAndReturnElement(loginButtonLocator).click();
        return new Dashboard_Page(this.driver);
    }

    public Registration_Page createAccount() {
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("initial-loading")));
        this.waitAndReturnElement(createAccountLocator).click();
        return new Registration_Page(this.driver);
    }
}
