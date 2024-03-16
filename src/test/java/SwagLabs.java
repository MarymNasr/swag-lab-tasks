import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabs {
    private WebDriver driver;
    void addItemToCart(String item) {
        String oldLocator="//div[@class=\"inventory_item_name \"and text()=\"%s\"]/parent::a/parent::div/following-sibling::div/button[@class=\"btn btn_primary btn_small btn_inventory \"]";
        String newLocator = String.format(oldLocator,item);

        By newLocator1=By.xpath(newLocator);
        WebElement newLocatorr =driver.findElement(newLocator1);
        newLocatorr.click();

    }

    void search(String item){
        String oldLocator="//div[@class=\"inventory_item_name\"and text()=\"%s\"]";
        String newLocator = String.format(oldLocator,item);
        Assert.assertEquals(driver.findElement(By.xpath(newLocator)).getText().contains(item),true);
    }
    @Test
    public void testDemo(){

        //get an object from chrome to our website
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        //test that this is the login page
        By loginPageHeaderSelector = By.className("login_logo");
        WebElement loginPageHeader = driver.findElement(loginPageHeaderSelector);

        Assert.assertEquals(loginPageHeader.getText(),"Swag Labs","login page header does not match requirement");

        //enter credentials
        By userNameSelector=By.id("user-name");
        WebElement username =driver.findElement(userNameSelector);
        username.sendKeys("standard_user");

        By passwordSelector=By.id("password");
        WebElement password =driver.findElement(passwordSelector);
        password.sendKeys("secret_sauce");

        By loginSelector=By.id("login-button");
        WebElement login =driver.findElement(loginSelector);
        login.click();

        String item = "Sauce Labs Backpack";

        addItemToCart(item);

        By cartSelector=By.id("shopping_cart_container");
        WebElement cart =driver.findElement(cartSelector);
        cart.click();

        search(item);


    }
}


