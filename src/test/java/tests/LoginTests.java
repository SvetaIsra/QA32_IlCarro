package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {

    @Test
    public void loginSuccess(){
        WebElement loginItem = wd.findElement(By.cssSelector("[href='/login?url=%2Fsearch']"));
        loginItem.click();

        WebElement emailInput = wd.findElement(By.xpath("//input[@id='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("sveta.mail.il@gmail.com");

        WebElement passwordInput = wd.findElement(By.xpath("//input[@id='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Sveta2022$");

        wd.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Logged in success']")).size()>0);
    }
    @Test
    public void loginSuccessNew(){
        click(By.cssSelector("[href='/login?url=%2Fsearch']"));
        type(By.xpath("//input[@id='email']"),"sveta.mail.il@gmail.com");
        type(By.xpath("//input[@id='password']"),"Sveta2022$");
        click(By.cssSelector("button[type='submit']"));
        isElementPresent(By.xpath("//*[text()='Logged in success']"));
    }

}
