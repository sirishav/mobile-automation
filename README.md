# QA Automation(Mobile)
This project is a sample automation framework for testing Android applications using Java 11, Appium, Android SDK, Selenium, TestNG and Maven.

## Prerequisites
- Java 11 or higher installed and configured on your system. You can check your Java version by running `java -version` in the command line.
- Appium installed and running on your system. You can download Appium from https://appium.io/ and follow the installation instructions.
- Android SDK installed and configured on your system. You can download Android SDK from https://developer.android.com/studio and follow the installation instructions. Make sure to set the `ANDROID_HOME` environment variable to point to the SDK location and add the `platform-tools` folder to your `PATH` variable.
- Maven installed and configured on your system. You can download Maven from https://maven.apache.org/download.cgi and follow the installation instructions. Make sure to set the `M2_HOME` environment variable to point to the Maven location and add the `bin` folder to your `PATH` variable.
- An Android device or emulator connected to your system. You can use the Android Studio emulator or any other emulator of your choice. Make sure to enable USB debugging on your device or emulator.

## Setup
- Clone this repository or download it as a zip file and extract it to a folder of your choice.
- Open the project in your preferred IDE (such as Eclipse or IntelliJ IDEA) and import it as a Maven project.
- Update the `src/test/java/mobile_automation/exercise/BaseTest.java` file with the following information:
    - `deviceName`: The name of your device or emulator (you can get it by running `adb devices` in the command line).
    - `platformName`: The name of the platform you are testing on (Android). 
    - `platformVersion`: The version of the platform you are testing on (such as 10 or 11).
    - `appPackage`: The package name of the application you are testing (such as com.example.app).
    - `appActivity`: The main activity name of the application you are testing (such as com.example.app.MainActivity).
    - `appPath`: The path to the APK file of the application you are testing (such as C:\Users\user\Downloads\app.apk).
  
## To add new tests
- Make sure you have the above prerequisites installed and configured on your machine. 
- Install Appium Inspector from https://appiumpro.com/inspector. This is a tool that allows you to inspect and interact with your app’s elements and attributes on various devices and platforms.
- Connect your device or emulator to your machine and launch the app that you want to test.
- Launch Appium Inspector and select the device or emulator that you want to use. You should see a screenshot of your app on the inspector window.
- Use the inspector’s features such as select element, record actions, view source tree, etc. to find the locators of the elements that you want to interact with in your tests. You can use different locator strategies such as id, name, class name, xpath, etc. depending on what works best for your app.
- Copy the locators from the inspector window and paste them in your test code. You can use methods such as driver.findElement(By.id(“locator”)) or driver.findElements(By.xpath(“locator”)) to locate and manipulate the elements in your tests.
- Write your test logic using TestNG annotations such as @Test, @BeforeMethod, @AfterMethod, etc. You can also use assertions and reporting features provided by TestNG framework.
- Save your test code in a file with a name ending with Test.java under src/test/java/mobile_automation/exercise folder in the project directory. For example: SearchTest.java

## Running Tests
- To run all tests, execute `mvn test` in the command line from the project root folder.
- To run tests using a testng.xml file, execute `mvn test -DsuiteXmlFile=testng.xml` in the command line from the project root folder.
- To run a specific test class, execute `mvn test -Dtest=TestClassName` in the command line from the project root folder.
- To run a specific test, execute `mvn test -DTestClassName#TestMethodName` in the command line from the project root folder


## Test Reports
- After running tests, you can find HTML reports in the `target/surefire-reports` folder. Open any of them with a browser to view test results and details.

## Test Specifications
- Link here - TestSpecification.md
