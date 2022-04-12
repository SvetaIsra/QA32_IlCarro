package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if(app.user().isLogOutPresent()){
            app.user().logout();
        }
    }

    @Test
    public void registrationSuccess() {
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        app.user().openRegistrationForm();
        app.user().fillRegistrationForm("Sonya","Sun","sonya"+index+"@gmail.com","Sonya2022$");
        app.user().checkPolicyXY();
        app.user().submit();
        Assert.assertEquals(app.user().checkMessage(),"You are logged in success");

    }
    @Test
    public void registrationSuccessModel() {
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User().withName("Sonya").withLastName("Sun").withEmail("sonya"+index+"@gmail.com").withPassword("Sonya2022$");

        app.user().openRegistrationForm();
        app.user().fillRegistrationForm(user);
        app.user().checkPolicyXY();
        app.user().submit();
        Assert.assertEquals(app.user().checkMessage(),"You are logged in success");

    }
    @Test
    public void registrationWrongPasswordModel() {
        User user = new User()
                .withName("Lia")
                .withLastName("Like")
                .withEmail("lia@gmail.com")
                .withPassword("12345");

        app.user().openRegistrationForm();
        app.user().fillRegistrationForm(user);
        app.user().checkPolicyXY();
        app.user().submit();
        //error + button not active
        Assert.assertTrue(app.user().isErrorPasswordDisplayedSize());
        Assert.assertTrue(app.user().isErrorPasswordDisplayedFormat());
        Assert.assertFalse(app.user().isYallaButtonActive());
        Assert.assertTrue(app.user().isButtonNotClickable());

    }
    @AfterMethod
    public void postCondition() {
        app.user().submitOkButton();
    }

}
