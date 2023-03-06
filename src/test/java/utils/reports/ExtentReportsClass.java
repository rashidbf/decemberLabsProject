package utils.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsClass {

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static String root = "src/test/java/utils/reports/extentConfig.xml";

    public static void startReport() {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
        sparkReporter.loadConfig(System.getProperty("user.dir") + root);
        // Create an object of Extent Reports
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Host Name", "DecemberLabs");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Rashid Bou Farah");
        sparkReporter.config().setDocumentTitle("Challenge QA Automation");
        // Name of the report
        sparkReporter.config().setReportName("Report");
        // Dark Theme
        sparkReporter.config().setTheme(Theme.DARK);
    }

    public static void endReport() {
        extent.flush();
    }
}