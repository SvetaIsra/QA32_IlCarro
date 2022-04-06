package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if(app.user().isLogOutPresent()){
            app.user().logout();
        }
    }

    @Test
    public void loginSuccessNew(){
        app.user().openLoginForm();
        app.user().fillLoginForm("sveta.mail.il@gmail.com","Sveta2022$");
        app.user().submit();
        app.user().pause(1000);
        Assert.assertEquals(app.user().checkMessage(),"Logged in success");

    }
    @Test
    public void loginSuccessNew2(){

        app.user().openLoginForm();
        app.user().fillLoginForm("sveta.mail.il@gmail.com","Sveta2022$");
        app.user().submit();
        app.user().pause(1000);
        Assert.assertEquals(app.user().checkMessage(),"Logged in success");
    }

    @AfterMethod
    public void postCondition() {
        app.user().submitOkButton();
    }

}
