package placeOrder;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class PlaceOrderStepDef {

    WebDriver driver;

    @Given("setup the driver and open the site")
    public void setup_the_driver_and_open_the_site() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("our site is on home page")
    public void our_site_is_on_home_page() {
        String actualName = driver.findElement(By.cssSelector(".brand.greenLogo")).getText();
        Assert.assertEquals(actualName, "GREENKART");
    }

    @Then("add some items to cart")
    public void add_some_items_to_cart() {
        List<WebElement> all_items = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
        for (int i = 0; i < 4; i++) {
            all_items.get(i).click();
        }
    }

    @Then("click on cart button and proceed to checkout")
    public void click_on_cart_button_and_proceed_to_checkout() {
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//div[@class='cart-preview active']/div[@class='action-block']/button")).click();
    }

    @Then("enter promoCode and click apply and verify")
    public void enter_promo_code_and_click_apply_and_verify() {
        driver.findElement(By.xpath(("//input[@placeholder='Enter promo code']"))).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
    }

    @Then("place order")
    public void place_order() {
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
    }

    @Then("select country and click agree")
    public void select_country_and_click_agree() {
        driver.findElement(By.xpath("//div[@class='wrapperTwo']/div/select")).click();
        driver.findElement(By.xpath("//select/option[89]")).click();
        driver.findElement(By.className("chkAgree")).click();
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
    }

    @Then("select country")
    public void selectCountry() {
        driver.findElement(By.xpath("//div[@class='wrapperTwo']/div/select")).click();
        driver.findElement(By.xpath("//select/option[89]")).click();
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
    }

    @Then("verify order is placed")
    public void verifyOrderIsPlaced() {
        driver.findElement(By.xpath("//span[contains(text(),'Thank you, your order has been placed successfully ')]")).isDisplayed();
    }

    @Then("verify order is not placed")
    public void verifyOrderIsNotPlaced() {
        boolean final_text = driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/span")).isDisplayed();
        Assert.assertTrue(final_text);
    }
}