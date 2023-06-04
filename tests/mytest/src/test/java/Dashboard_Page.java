import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard_Page extends PageBase {
    public Dashboard_Page(WebDriver driver) {
        super(driver);
        this.driver.get("https://leetcode.com/progress/");
    }
}
