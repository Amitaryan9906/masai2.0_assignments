package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    static ExtentReports extent;

    public static ExtentReports getReport() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/AmazonExtentReport.html");
            reporter.config().setDocumentTitle("Automation Report");
            reporter.config().setReportName("Amazon Search Tests");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Amit Kumar");
        }
        return extent;
    }
}
