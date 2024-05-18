package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinition {

    private WebDriver driver;

    public LoginStepDefinition(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("launch the URL {string}")
    public void launch_the_url(String URL) {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        System.out.println(URL);
        driver.get(URL);
    }
    @When("enter username {string} and password {string}")
    public void enter_username_and_password(String userName, String password) {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        System.out.println("UserName: "+userName + " Password: "+password);
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
    }
    @When("click Login button")
    public void click_login_button() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        System.out.println("click");
        driver.findElement(By.id("login-button")).click();
    }
    @Then("verify user navigated to dashboard page")
    public void verify_user_navigated_to_dashboard_page() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        System.out.println("Verify");
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", url);
        driver.quit();
    }

    @Then("verify Error displayed")
    public void validated_login_failure(){
        Assert.assertEquals(true,driver.findElement(By.xpath("//button[@class='error-button']")).isDisplayed());
        driver.quit();
    }

    @After
    public void quitDriver(){
        driver.quit();
    }
}
