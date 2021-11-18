import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class workingTest extends lcwLocators
{
    @Test
    public void test() throws InterruptedException, IOException
    {
        System.setProperty("webdriver.chrome.driver", "D:\\Docs\\Drivers\\chromedriver.exe");
        DesiredCapabilities chDCap = DesiredCapabilities.chrome();
        chDCap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        chDCap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        WebDriver lcwDriver = new ChromeDriver();


        Logger lcwLog = Logger.getLogger("lcwLog");
        FileHandler fileH;
        fileH = new FileHandler("C:\\Users\\Hidalgo\\Desktop\\signUpLog.log");
        lcwLog.addHandler(fileH);
        SimpleFormatter smpFormatter = new SimpleFormatter();
        WebDriverWait expWait = new WebDriverWait(lcwDriver, 30);
        Actions lcwAct = new Actions(lcwDriver);
        JavascriptExecutor js = (JavascriptExecutor) lcwDriver;

        lcwDriver.get(url);                                                                                                 //Open URL
        lcwDriver.manage().window().maximize();
        Assertions.assertEquals(url, lcwDriver.getCurrentUrl());                                                            //Check Url is correctly opened
        lcwLog.info("Url Opened and working.");


        expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class='cookie__button'] button")));   //Ok cookies.
        lcwDriver.findElement(By.cssSelector("p[class='cookie__button'] button")).click();
        Thread.sleep(1000);
        //lcwDriver.switchTo().alert().dismiss();

        lcwAct.moveToElement(lcwDriver.findElement(By.className("dropdown-toggle"))).build().perform();                     //Mouse hover
        WebElement crsMove = lcwDriver.findElement(By.className("dropdown-toggle"));                                        //Move cursor
        lcwAct.moveToElement(lcwDriver.findElement(By.xpath("//a[@class='action-btn btn-block bg-blue']"))).click().build().perform();              //Click 'Giriş Yap'

        expWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ul-title")));
        String loginSccCheck = lcwDriver.findElement(By.className("header-icon-label")).getText();                          //For login check Text = Giriş Yap
        lcwDriver.findElement(By.xpath(mail)).sendKeys("@gmail.com");
        lcwDriver.findElement(By.xpath(pass)).sendKeys("");
        lcwDriver.findElement(By.xpath("//a[@id='loginLink']")).click();

        Thread.sleep(1500);
        String loginSccCheck2 = lcwDriver.findElement(By.className("dropdown-label")).getText();                            //For login check Text = Hesabım
        Assertions.assertNotEquals(loginSccCheck, loginSccCheck2);
        lcwLog.info("Successfully login");

        lcwDriver.findElement(By.xpath("//input[@id='search_input']")).clear();                                             //Clear textbox
        lcwDriver.findElement(By.xpath("//input[@id='search_input']")).sendKeys(searchTxt);
        lcwDriver.findElement(By.className(searchBTN)).click();
        lcwLog.info("Successfully 'Pantolon searched.'");

        js.executeScript("window.scrollTo(0,9000)");                                                                     //Scroll down.
        expWait.until(ExpectedConditions.elementToBeClickable(By.className(loadMoreBTN)));
        lcwDriver.findElement(By.className(loadMoreBTN)).click();                                                           //Click 'Daha Fazla Ürün Gör'
        expWait.until(ExpectedConditions.urlContains("2"));
        lcwLog.info("Successfully opened Next Page");

        //expWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        Thread.sleep(1000);
        Random rand = new Random();
        List<WebElement> allPants = lcwDriver.findElements(By.cssSelector(randItem));                                         //Listing items by selecting 'title'
        allPants.get(rand.nextInt(allPants.size())).click();
        lcwLog.info("Successfully random item selected.");

        expWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hidden-xs")));                              //Waiting item's page opening
        lcwDriver.findElement(By.xpath("//body/div[5]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[3]/a[1]")).click();   //Select size
        String priceCheck1 = lcwDriver.findElement(By.xpath(pCheck1)).getText();                                              //Taking price tag for compare with basket price
        String priceCheck2 = lcwDriver.findElement(By.xpath(pCheck2)).getText();
        Assertions.assertEquals(priceCheck1, priceCheck2);
        lcwLog.info("Prices are same.");

        lcwDriver.findElement(By.id("pd_add_to_cart")).click();                                                               //Click add to cart
        lcwLog.info("Successfully item added.");
        Thread.sleep(1000);
        lcwDriver.findElement(By.className("header-cart")).click();                                                           //Opening basket page

        //expWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Sepetim (1 Ürün)')]")));
        Thread.sleep(1500);



        lcwDriver.findElement(By.cssSelector(addOne)).click();                                                            //Increase item piece
        Thread.sleep(1000);
        //String piece = lcwDriver.findElement(By.xpath("//body/div[3]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).getText();
        String twoCheck = lcwDriver.findElement(By.xpath("//span[contains(text(),'Sepetim (2 Ürün)')]")).getText();
        twoCheck.contains("2");
        lcwLog.info("Cart have a two item.");
        //Assertions.assertEquals(twoCheck,2);
        lcwLog.info("Successfully item pierce increased to two.");

        lcwDriver.findElement(By.xpath(delCart)).click();  //Item deleted
        Thread.sleep(1000);
        lcwDriver.findElement(By.className(confirmDel)).click();                         //Delete confirmed.
        expWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart-empty-title")));                                     //Cart is empty condition. If this text is visible which means cart is empty.
        lcwLog.info("Cart cleared.");
        //lcwDriver.switchTo().alert().dismiss();
    }
}
