package base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String runFolderPath;

    public static void setUp() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Initialize the screenshot folder path (folder will only be created when needed)
            if (runFolderPath == null) {
                String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
                runFolderPath = "target/screenshots/HaffarTestRun_" + timestamp;
            }
        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String captureScreenshot(String scenarioName, boolean isFailed, String exampleDetails) {
        try {
            // Delay folder creation until a screenshot is actually taken
            if (!new File(runFolderPath).exists()) {
                new File(runFolderPath).mkdirs();
            }

            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);

            // Add timestamp to ensure unique screenshot names
            String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
            String status = isFailed ? "FAILED" : "PASSED";
            String filePath = runFolderPath + "/" + status + "_" + scenarioName.replace(" ", "_") + "_" + exampleDetails + "_" + timestamp + ".png";

            File destFile = new File(filePath);
            FileUtils.copyFile(screenshotFile, destFile);

            System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());
            return destFile.getAbsolutePath();
        } catch (Exception e) {
            System.out.println("Error capturing screenshot: " + e.getMessage());
            return "";
        }
    }
}
