package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest
{
    String baseurl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        // Open browser and launch base url
        openBrowser(baseurl);
    }

    @Test
    public void UserShouldLoginSuccessfullyWithValidCredentials(){
        String expectedMessage = "Secure Area";
        //element to send username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
        //element to send the password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //element to click on login button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        //element to get message
        String actualMessage = driver.findElement(By.xpath("//h2")).getText();
        //verification of actual and expectedMessage
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        String expectedMessage = "Your username is invalid!";
        //Element to send username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
        //Element to send password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //Element to click on login button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        // Element to get message
        String actualMessage = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        // verification of actual message and excepted message
        Assert.assertEquals("fail to login",expectedMessage,actualMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage(){
        String expectedMessage = "Your password is invalid!";
        //Element to send username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //Element to send password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
        //Element to click on login button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        // Element to get message
        String actualMessage = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @After
    public void tearDown() {
        // Close all windows
        closeBrowser();
    }
}
