package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

     @Test
    public void loginPositiveTest(){
         User user = User.builder()
                 .email("Telran2022@gmail.com")
                 .password("Ads$gf1288")
                 .build();

        app.getUser().openLoginRegistrationForm();
         app.getUser().fillLoginRegistrationForm(user);
         app.getUser().submitLogin();
         Assert.assertTrue(app.getUser().isLogged());
     }

    @Test
    public void loginNegativeTest1(){
        User user = User.builder()
                .email("ran2018mail.com")
                .password("Ads$gf1288")
                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
    }

    @Test
    public void loginNegativeTest2(){
        User user = User.builder()
                .email("Telran2022@gmail.com")
                .password("ds1288")
                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
    }

}
