package homework.cucumber.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class login {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("ada di halaman login saucedemo")
    public void ada_di_halaman_login_saucedemo() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
    }

    @And("masukan password invalid")
    public void masukanPasswordInvalid() {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauceX");
    }

    @Then("tampilkan error message")
    public void tampilkanErrorMessage() {
        String notifError = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", notifError);
    }

    @And("stop sesi")
    public void stopSesi() {
        driver.close();
    }


    @Given("ada di halaman inventory")
    public void adaDiHalamanInventory() {
        driver.get("https://www.saucedemo.com/inventory.html");
        String menu = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals("Products",menu);
    }

    @When("klik tombol atc")
    public void klikTombolAtc() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }

    @Then("tombol atc berubah jadi remove")
    public void tombolAtcBerubahJadiRemove() {
        String textButton = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals("Remove",textButton);
    }

    @And("counter di cart jadi satu")
    public void counterDiCartJadiSatu() {
        String angka = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        Assert.assertEquals("1",angka);
    }

    @When("klik tombol remove")
    public void klikTombolRemove() {
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
    }

    @Then("counter di cart jadi nol")
    public void counterDiCartJadiNol() {
        boolean status = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).isDisplayed();
        Assert.assertEquals(true,status);
    }
}
