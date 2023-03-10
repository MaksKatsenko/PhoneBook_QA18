package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    String correctEmail = "Telran2022@gmail.com";
    String correctPassword = "Ads$gf1288";
    String IncorrectEmail = "ran2018mail.com";
    String IncorrectPassword = "ds1288";

     @Test
    public void loginPositiveTest(){
        app.getUser().openLoginRegistrationForm();
         app.getUser().fillLoginRegistrationForm(correctEmail, correctPassword);
         app.getUser().submitLogin();
         Assert.assertTrue(app.getUser().isLogged());
     }

    @Test
    public void loginNegativeTest1(){
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(IncorrectEmail, correctPassword);
        app.getUser().submitLogin();
    }

    @Test
    public void loginNegativeTest2(){
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(correctEmail, IncorrectPassword);
        app.getUser().submitLogin();
    }

}
