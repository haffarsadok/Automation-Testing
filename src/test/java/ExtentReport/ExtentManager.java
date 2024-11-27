package ExtentReport;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;
    private static SimpleDateFormat dateFormat;
    private static String  daterapport;
    private static String reportPath;
    private static ExtentSparkReporter reporter;
        public static synchronized ExtentReports getInstance() {
            if (extent == null) {
                dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
            daterapport = dateFormat.format(new Date());
            reportPath = "target/extent-reports/RepportTestRun" + daterapport + ".html";
            reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setTheme(Theme.DARK);
            reporter.config().setDocumentTitle("Test Report");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}