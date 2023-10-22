package homework.cucumber.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("ada di halaman login saucedemo")
    public void ada_di_halaman_login_saucedemo() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        String  name = driver.getTitle();
        Assert.assertEquals("Swag Labs",name);
    }

    @When("masukan username valid")
    public void masukanUsernameValid() {
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
    }

    @And("masukan password valid")
    public void masukanPasswordValid() {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
    }

    @And("klik tombol login")
    public void klikTombolLogin() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("diarahkan ke homepage")
    public void diarahkanKeHomepage() {
        String title = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals("Swag Labs", title);
        driver.close();
    }

    @And("masukan password invalid")
    public void masukanPasswordInvalid() {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauceX");
    }

    @Then("tampilkan error message")
    public void tampilkanErrorMessage() {
        String notifError = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this serviceS", notifError);
        driver.close();
    }
}
