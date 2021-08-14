package io.pragra.framework.test.conf;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.pragra.framework.data.ExcelReader;
import io.pragra.framework.report.HtmlReports;
import io.pragra.framework.util.Utils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

public class ExcelTest {


    @Test
    public void testName() {
        ExtentTest test = HtmlReports.getTest("SanityTest");
        test.log(Status.PASS, "ALL GOOOD");
        System.out.println(Utils.getReportFile());
        HtmlReports.flush();

    }

    @DataProvider
    public Iterator<Object[]>  excelData() {
        ExcelReader reader = new ExcelReader();
       return reader.getExcelData(true).iterator();
    }
}
