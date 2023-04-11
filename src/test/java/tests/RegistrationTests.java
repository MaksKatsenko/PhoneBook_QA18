package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

 @BeforeMethod(alwaysRun = true)
 public void preCondition(){
     if (app.getUser().isLogged()){
         app.getUser().logout();
     }
 }

    @Test(groups = {"smoke"})
    public void regPositiveTest() {
        int i = (int)(System.currentTimeMillis() /1000) % 3600;
        User user = User.builder()
                .email("arc" + i + "@def.com")
                .password("$Altcd12434")
                .build();

        app.getUser().openLoginRegistrationForm();
        logger.info("regPositiveTest starts with: " + user.getEmail() + " & " + user.getPassword());
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

        Assert.assertTrue(app.getUser().isErrorFormatMessage());
        Assert.assertTrue(app.getUser().isAlertPresent());

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

        Assert.assertTrue(app.getUser().isErrorFormatMessage());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
   //     wd.quit();
    }
}
