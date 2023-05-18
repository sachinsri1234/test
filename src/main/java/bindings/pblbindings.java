package bindings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.List;
import io.cucumber.datatable.DataTable;

public class pblbindings {

	public static WebDriver driver;
	public static String URL = "https://jpetstore.aspectran.com/account/signonForm";
	public static Actions actions;

	@Given("User is on Fish Store login page")
	public void user_is_on_fish_store_login_page() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		actions = new Actions(driver);
		driver.manage().window().maximize();
		driver.get(URL);

	}

	@When("User enters {string} in username input field")
	public void user_enters_in_username_input_field(String string) {
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		actions.doubleClick(userName).build().perform();
		userName.sendKeys(string);
	}

	@When("User enters {string} in the password input field")
	public void user_enters_in_the_password_input_field(String string) {

		WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
		actions.doubleClick(passWord).build().perform();
		passWord.sendKeys(string);

	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {

		WebElement loginBtn = driver.findElement(By.xpath("//button[text() = 'Login']"));
		loginBtn.click();

	}

	@Then("User has been successfully redirected to the homepage")
	public void user_has_been_successfully_redirected_to_the_homepage() {
		WebElement wb = driver.findElement(By.xpath("//a[text() = 'My Account']"));
		assertTrue(wb.isDisplayed());

	}

	@When("User selects the desired product")
	public void user_selects_the_desired_product(DataTable dataTable) {

		List<List<String>> data1 = dataTable.asLists(String.class);
		WebElement prodId = driver.findElement(By.linkText(data1.get(0).get(0)));
		prodId.click();

		WebElement itemId = driver.findElement(By.linkText(data1.get(0).get(1)));
		itemId.click();
		WebElement itemId2 = driver.findElement(By.linkText(data1.get(0).get(2)));
		itemId2.click();

	}

	@When("User clicks on the add to cart button")
	public void user_clicks_on_the_add_to_cart_button() {
		WebElement addToCart = driver.findElement(By.linkText("Add to Cart"));
		addToCart.click();

	}

	@When("User clicks on proceed to checkout")

	public void user_clicks_on_proceed_to_checkout() {
		WebElement checkout = driver.findElement(By.linkText("Proceed to Checkout"));
		checkout.click();

	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		WebElement contBtn = driver.findElement(By.xpath("//button[text() = 'Continue']"));
		contBtn.click();

	}

	@When("User clicks on confirm button")
	public void user_clicks_on_confirm_button() {
		WebElement confirmBtn = driver.findElement(By.xpath("//button[text() = 'Confirm']"));
		confirmBtn.click();
	}

	@Then("User is able to make the successful purchase")
	public void user_is_able_to_make_the_successful_purchase() {
		String orderId = driver.findElement(By.xpath("//div[@id='CenterForm']/table/tbody/tr/td[2]")).getText();
		driver.findElement(By.linkText("My Orders")).click();
		String myOrders_orderId = driver.findElement(By.xpath("//div[@id='Catalog']/table/tbody/tr[2]/td/a")).getText();
		assertEquals(orderId.split("#")[1], myOrders_orderId);

	}

//	@AfterAll
//	public static void end() {
//
//		driver.quit();
//
//	}

}

