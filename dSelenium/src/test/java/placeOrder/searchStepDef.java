package placeOrder;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchStepDef {

	WebDriver driver;

	@Given("StepUp Driver")
	public void startup() {
		System.out.println("startup");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("User is on Home page")
	public void user_is_on_home_page() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@Then("User click on search bar and enter {string}")
	public void user_click_on_search_bar_and_enter_name(String name) {
		driver.findElement(By.className("search-keyword")).sendKeys(name);
	}

	@Then("validation how many items we get {int} items")
	public void validation_how_many_items_we_get(int total) {
		driver.findElement(By.className("search-button")).click();
		List<WebElement> count = driver.findElements(By.xpath("//div[@class='product']"));
		System.out.println(count.size());
		Assert.assertEquals(count.size(), total);
	}

	@Then("Click enter and check there are no items")
	public void click_enter_and_check_there_are_no_items() {
		driver.findElement(By.className("search-button")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//h2[text()='Sorry, no products matched your search!']")).isDisplayed());
	}

	@Then("Close Browser")
	public void closeBrowser() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
