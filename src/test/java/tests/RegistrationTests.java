package tests;

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
        app.getUser().openLoginRegistrationForm();
        int i = (int)(System.currentTimeMillis() /1000) % 3600;
        String email = "arc" + i + "@def.com";
        String password = "$Altcd12434";
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[text()='ADD']")));
    }

    @Test
    public void regNegativeTest() {
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(IncorrectEmail, CorrectPassword);
        app.getUser().submitRegistration();
    }

    @Test
    public void regNegativeTest2() {
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(CorrectEmail, IncorrectPassword);
        app.getUser().submitRegistration();
    }

    @AfterMethod
    public void tearDown(){
   //     wd.quit();
    }
}
