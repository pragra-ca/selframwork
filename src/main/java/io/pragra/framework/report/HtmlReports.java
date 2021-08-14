package io.pragra.framework.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentAventReporter;

import io.pragra.framework.conf.Config;


import java.io.IOException;

public class HtmlReports {
    private static HtmlReports htmlReports;
    private ExtentReports reports;

    private HtmlReports() {
        reports = new ExtentReports();
        ExtentAventReporter htmlReporter = null;
        try {
            htmlReporter = new ExtentAventReporter(Config.getProperty("report.dir"));
            reports.attachReporter(htmlReporter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        reports.attachReporter(htmlReporter);
    }

    public static ExtentTest getTest(String name){
        if(htmlReports == null) {
            htmlReports = new HtmlReports();
        }
        return htmlReports.reports.createTest(name);
    }

    public static void flush(){
        if(htmlReports != null) {
            htmlReports.reports.flush();
        }
    }
}
