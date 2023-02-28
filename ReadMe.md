# Mobile Browser Testing

## Setup
1. Create a JAVA-MAVEN project 
2. Add the dependencies to the pom.xml like this
````java
 <dependencies>
        <!-- https://mvnrepository.com/artifact/io.appium/java-client -->
        <dependency>
            <groupId>io.appium</groupId>
            <artifactId>java-client</artifactId>
            <version>7.4.1</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.testng/testng -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.6.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
````
3. Create a Class under JAVA
4. Create a Test Annotation in the class like this
````java
 @Test
    public void mobilBrowserTesti01() throws MalformedURLException {

        DesiredCapabilities dCap = new DesiredCapabilities();

        dCap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dCap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"6.0");
        dCap.setCapability(MobileCapabilityType.DEVICE_NAME,"HUAWEI VNS_L21");
        dCap.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        dCap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60000");
        dCap.setCapability("chromeDriverExecutable","");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http:localhost:4723/wd/hub"),dCap);

        driver.get("https://www.amazon.com.tr");
````
5. Start Appium Server
6. Start and connect with VYSOR to the phone
7. Run the test
8. You must see it's failed, Read the error message like the picture below. Or look at chrome's version from the phone.  
![](F:\TESTER\14_PROJECTS\IdeaProjects\appium\mobilBrowserTesting\\screenShot1.png "The error message")  
9. Go to the link below and download the chrome version which you read at step 8
    * [Chrome Download Link](https://chromedriver.chromium.org/downloads)
10. Create a driver directory under the src. Then drag and drop 'chromedriver.exe'<br> to he 'driver' directory
11. Copy absolute path from chromedriver.exe and past as the 'chromeDriverExecutable' value
12. Run the test and if it's not passed past the absolute path of chromedriver.exe to the Appium server the part which is seen below. Then start server.
   ![](F:\\TESTER\\14_PROJECTS\\IdeaProjects\\appium\\mobilBrowserTesting\\screenShot2.png)
13. to handle the pages write this code
````java
 Set<String> butunTurler = driver.getContextHandles();
        for (String tur: butunTurler
             ) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")){
                driver.context(tur);
            }
        }
````
## Locate
### Method 1
14. Go to the Chrome Web browser and write this: <br> 
 * chrome://inspect/#devices
15. When browser opened on the emulator or phone, it'll seen like below. Write url press open and click the 'inspect' button,<br>then start to locate androidElements  
   ![](F:\\TESTER\\14_PROJECTS\\IdeaProjects\\appium\\mobilBrowserTesting\\screenShot3.png)
### Method 2
16. Open the chrome browser. Then click the 3 dots from upper and right.<br> 
![](F:\\TESTER\\14_PROJECTS\\IdeaProjects\\appium\\mobilBrowserTesting\\screenShot4.png)
17. Then click 'new Incognico Window'. Write Url, Click right click anp press inspect. Then start to locate