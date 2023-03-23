package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    String CorrectEmail = "Telran2022@gmail.com";
    String CorrectPassword = "Ads$gf1288";
    String IncorrectEmail = "ran2018mail.com";
    String IncorrectPassword = "ds1288";

 @BeforeMethod
 public void preCondition(){
     if (app.getUser().isLogged()){
         app.getUser().logout();
     }
 }

    @Test
    public void regPositiveTest() {
        int i = (int)(System.currentTimeMillis() /1000) % 3600;
        User user = User.builder()
                .email("arc" + i + "@def.com")
                .password("$Altcd12434")
                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[text()='ADD']")));
    }

    @Test
    public void regNegativeTest() {
        User user = User.builder()
                .email("ran2018mail.com")
                .password("Ads$gf1288")
                .build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();
    }

    @Test
    public void regNegativeTest2() {
        User user = User.builder()
                .email("Telran2022@gmail.com")
                .password("ds1288")
                .build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();
    }

    @AfterMethod
    public void tearDown(){
   //     wd.quit();
    }
}
