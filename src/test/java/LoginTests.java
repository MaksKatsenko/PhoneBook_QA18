import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    String correctEmail = "Telran2022@gmail.com";
    String correctPassword = "Ads$gf1288";
    String IncorrectEmail = "ran2018mail.com";
    String IncorrectPassword = "ds1288";

     @Test
    public void loginPositiveTest(){
         openLoginRegistrationForm();
         fillLoginRegistrationForm(correctEmail, correctPassword);
         submitLogin();
         Assert.assertTrue(isLogged());
     }

    @Test
    public void loginNegativeTest1(){
        openLoginRegistrationForm();
        fillLoginRegistrationForm(IncorrectEmail, correctPassword);
        submitLogin();
    }

    @Test
    public void loginNegativeTest2(){
        openLoginRegistrationForm();
        fillLoginRegistrationForm(correctEmail, IncorrectPassword);
        submitLogin();
    }

}
