package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"),email);
        type(By.id("password"),password);
    }
    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"),user.getPassword());
    }

    public void submit() {
        click(By.cssSelector("button[type='submit']"));
    }

    public String checkMessage() {
        new WebDriverWait(wd,5)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        String message = wd.findElement(By.cssSelector(".dialog-container h2")).getText();
        return message;
    }

    public void submitOkButton() {
        if(isElementPresent(By.xpath("//button[text()='Ok']"))) {
            click(By.xpath("//button[text()='Ok']"));}
    }

    public boolean isLogOutPresent() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//a[text()=' Logout ']"));
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
    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"),user.getPassword());
    }
    public void checkPolicyXY() {
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));

        Rectangle rect = label.getRect();
        int offSetX = rect.getWidth()/3;
        int offSetY = rect.getHeight()/3;

        Actions actions = new Actions(wd);
        actions.moveToElement(label).release().perform();
        actions.moveByOffset(-offSetX,-offSetY).click().release().perform();
    }

    public boolean isErrorPasswordDisplayedSize() {
        Boolean firstChild = new WebDriverWait(wd,5)
                .until(ExpectedConditions
                        .textToBePresentInElement(wd.findElement(By.cssSelector("div.error div:first-child")),
                        "Password must contain minimum 8 symbols"));
        return firstChild;
    }
    public boolean isErrorPasswordDisplayedFormat() {
        Boolean lastChild = new WebDriverWait(wd,5)
                .until(ExpectedConditions
                        .textToBePresentInElement(wd.findElement(By.cssSelector("div.error div:last-child")),
                                "Password must contain 1 uppercase letter, 1 lowercase letter and one number"));
        return lastChild;
    }

    public boolean isYallaButtonActive() {
        return wd.findElement(By.cssSelector("button[type='submit']")).isEnabled();
    }

    public boolean isButtonNotClickable() {
        return isElementPresent(By.cssSelector("button[disabled]"));
    }
}
