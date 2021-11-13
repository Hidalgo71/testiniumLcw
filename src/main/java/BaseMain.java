/*I tried to use this coding style but I got an error.

   "Test ignored.

org.junit.jupiter.api.extension.ParameterResolutionException: No ParameterResolver registered for parameter [org.openqa.selenium.WebDriver arg0]
 in constructor [public BaseTest(org.openqa.selenium.WebDriver)]."
 Unfortunately I changed my method, but I'm not delete this, I'll try to solve this later.

 */
//=============================================================================================
/*import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseMain
{
    public WebDriver lcwDriver;
    public WebDriverWait wait;

    public BaseMain(WebDriver lcwDriver)
    {
        this.lcwDriver = lcwDriver;
        this.wait = new WebDriverWait(lcwDriver, 5);
    }
    BaseMain baseMain;

    @BeforeAll
    public void setup()
    {
        DesiredCapabilities chDCap = DesiredCapabilities.chrome();
        chDCap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        chDCap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        System.setProperty("webdriver.chrome.driver", "D:\\Docs\\Drivers\\chromedriver.exe");
        lcwDriver = new ChromeDriver();
        lcwDriver.get("https://www.lcwaikiki.com/tr-TR/TR");
        lcwDriver.manage().window().maximize();
        WebDriverWait expWait = new WebDriverWait(lcwDriver, 3);
        Logger lcwLog = Logger.getLogger("lcwLog");
        SimpleFormatter smpFormatter = new SimpleFormatter();
    }

    public void openUrl()
    {
        baseMain.openUrl();
    }

    @AfterAll
    public void tearDown()
    {
        lcwDriver.quit();
    }
}
*/