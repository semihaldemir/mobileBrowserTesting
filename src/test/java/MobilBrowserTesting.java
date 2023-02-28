import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class MobilBrowserTesting {

    @Test
    public void mobilBrowserTesti01() throws MalformedURLException {

        DesiredCapabilities dCap = new DesiredCapabilities();

        dCap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dCap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"6.0");
        dCap.setCapability(MobileCapabilityType.DEVICE_NAME,"HUAWEI VNS_L21");
        dCap.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        dCap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60000");
        dCap.setCapability("chromeDriverExecutable","C:\\Users\\semih aldemir\\IdeaProjects\\mobilBrowserTesting\\src\\driver\\chromedriver.exe");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http:localhost:4723/wd/hub"),dCap);

        // amazona gidilir
        driver.get("https://www.amazon.com.tr");

        //Applikasyonun hangi türleri olduğunu görmek içingetContextHandles() kullanıyoruz
        Set<String> butunTurler = driver.getContextHandles();
        for (String tur: butunTurler
             ) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")){
                driver.context(tur);
            }
        }

        System.out.println(driver.getContext()+" Anasayfaya Ulaşıldı");

        //logo görünüyor mu kontrol edilir
        MobileElement logo = driver.findElementByXPath("//a[@id='nav-logo-sprites']");
        Assert.assertTrue(logo.isEnabled());
        System.out.println("Anasayfaya ulaşıldı");

        //giris yap butonuna tıklanır
        MobileElement girisYapButton = driver.findElementByXPath("//a[@id='nav-logobar-greeting']");
        girisYapButton.click();
        System.out.println("giriş sayfasına ulaşıldı");

        MobileElement hosGeldinizTitle = driver.findElementByXPath("//h2");
        Assert.assertTrue(hosGeldinizTitle.isDisplayed());

        MobileElement hesapOlusturunLink  = driver.findElementByXPath("//span[text()='Hesap oluşturun']");
        hesapOlusturunLink.click();

        driver.closeApp();





    }
}
