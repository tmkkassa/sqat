import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



class MainPage extends PageBase {

    
     private By loginLocator = By.xpath("//*[@id='landing-page-app']/div/div[1]/div[3]/div[1]/div/div/div[2]/div/a[5]");
     
     //private By footerBy = By.xpath("/html/body/footer/div/div[2]/div/div/div[1][contains(text(), 'Copyrights')]");
    //   private By footerBy = By.xpath("/html/body/footer/div/div[2]/div/div/div[1][contains(text(), 'Copyrights')]");

     //private By footerBy = By.xpath("//a[contains(text(), 'Copyrights')]");
     private By accessLoginBy = By.xpath("//*[@id='landing-page-app']/div/div[1]/div[3]/div[1]/div/div/div[2]/div/a[5]");
 
     private By subMenuContainerBy = By.xpath("//div[@class='text-primary-hover' and contains(text(), 'Copyrights')]");
 
     private By requestDemoLocator = By.xpath("(//a[@href='/request-demo/'])[1]");
     private By signUpLocator = By.xpath("(//a[@href='/get-started/'])[2]");
 
    
    public MainPage(WebDriver driver ) {
        super(driver);
        this.driver.get("https://leetcode.com/");
    }    

    public Login_Page accessLogin() {
        this.waitAndReturnElement(loginLocator).click();
        return new Login_Page(this.driver);
    }

    // public String getFooterText() {
    //     return this.waitAndReturnElement(footerBy).getText();
    // }
 

}