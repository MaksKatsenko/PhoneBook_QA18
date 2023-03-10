import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
     if (isLogged()){
         logout();
     }
 }

    @Test
    public void regPositiveTest() {
       openLoginRegistrationForm();
        int i = (int)(System.currentTimeMillis() /1000) % 3600;
        String email = "arc" + i + "@def.com";
        String password = "$Altcd12434";
        fillLoginRegistrationForm(email, password);
        submitRegistration();
        Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));
    }

    @Test
    public void regNegativeTest() {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(IncorrectEmail, CorrectPassword);
        submitRegistration();
    }

    @Test
    public void regNegativeTest2() {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(CorrectEmail, IncorrectPassword);
        submitRegistration();
    }

    @AfterMethod
    public void tearDown(){
   //     wd.quit();
    }
}
