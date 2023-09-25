package placeOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class GreenCartTest {

    WebDriver driver;

    @BeforeMethod
    public void startup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @Test
    public void placeOrder() throws InterruptedException {
        List<WebElement> all_items=driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
        for (int i =0; i <4; i++){
                all_items.get(i).click();
        }
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//div[@class='cart-preview active']/div[@class='action-block']/button")).click();
        driver.findElement(By.xpath(("//input[@placeholder='Enter promo code']"))).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']"))).isDisplayed();
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        driver.findElement(By.xpath("//div[@class='wrapperTwo']/div/select")).click();
        driver.findElement(By.xpath("//select/option[89]")).click();
        driver.findElement(By.className("chkAgree")).click();
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
    }

}
