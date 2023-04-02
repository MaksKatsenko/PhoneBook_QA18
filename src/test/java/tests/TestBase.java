package tests;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {


    Logger logger = LoggerFactory.getLogger(TestBase.class);
//    WebDriver wd;
    public static ApplicationManager app = new ApplicationManager();
    @BeforeSuite
    public void setUp(){
        app.init();
    }
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }

    @AfterSuite
    public void tearDown(){
        //     wd.quit();
        app.stop();
    }
//   public void logout(){
//        click(By.xpath("//button[.='Sign Out']"));
//   }
//
//    public boolean isLogged(){
//        return isElementPresent(By.xpath("//button[.='Sign Out']"));
//    }
//    public boolean isElementPresent(By locator){
//        return (wd.findElements(locator).size() > 0);
//    }
//
//    public void openLoginRegistrationForm() {
//        click(By.xpath("//a[@href='/login']"));
//    }

//    public void fillLoginRegistrationForm(String email, String password){
//        type(By.xpath("//input[1]"), email);
//        type(By.xpath("//input[2]"), password);
//    }

//    public void submitLogin(){
//        click(By.xpath("//button[1]"));
//    }
//
//    public void submitRegistration(){
//        click(By.xpath("//button[2]"));
//    }
//    public void click(By locator){
//        wd.findElement(locator).click();
//    }
//
//    public void type(By locator, String text){
//        if(text != null){
//            WebElement element = wd.findElement(locator);
//            element.click();
//            element.clear();
//            element.sendKeys(text);
//        }
//    }
//    public void pause(int time){
//        try {
//            Thread.sleep(time);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

}
