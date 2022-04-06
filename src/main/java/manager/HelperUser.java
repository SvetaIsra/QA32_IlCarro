package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
      //  click(By.cssSelector("[href='/login?url=%2Fsearch']"));
        click(By.xpath("//*[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
      //  type(By.xpath("//input[@id='email']"),email);
      //  type(By.xpath("//input[@id='password']"),password);
        type(By.id("email"),email);
        type(By.id("password"),password);
    }

    public void submit() {
        click(By.cssSelector("button[type='submit']"));
    }
    public String checkMessage() {
        String message = wd.findElement(By.cssSelector(".dialog-container h2")).getText();
        System.out.println(message);
        return message;
    }

    public void submitOkButton() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isLogOutPresent() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(String name, String lastName, String email, String password) {
        type(By.id("name"),name);
        type(By.id("lastName"),lastName);
        type(By.id("email"),email);
        type(By.id("password"),password);

    }

    public void checkPolicy() {
        click(By.cssSelector("label[for='terms-of-use']"));
    }

    public void checkPolicyXY() {
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));

        Rectangle rect = label.getRect();
        int offSetX = rect.getWidth()/2;
        int offSetY = rect.getHeight()/2;

        Actions actions = new Actions(wd);
        actions.moveToElement(label).release().perform();
        actions.moveByOffset(-offSetX,-offSetY).click().release().perform();
    }
}
