package utils.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import utils.reports.ExtentReportsClass;

import java.io.IOException;

public class ListenerTestNG extends BaseTest implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        //devuelve el nombre del test en la suite.
        System.out.println("Stating test: " + context.getName());
        //inicializa el report
        ExtentReportsClass.startReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        //devuelve el nombre del metodo
        System.out.println("Stating test method: " + result.getMethod().getMethodName());
        //inicializa el
        ExtentReportsClass.logger = ExtentReportsClass.extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //Si el test pasa, devuelve el nombre del metodo
        System.out.println("PASSED: " + result.getMethod().getMethodName());
        //devuelve pass en report y lo pinta de verde al nombre del metodo
        ExtentReportsClass.logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //si el test falla devuelve el nombre del metodo
        System.out.println("FAILED: " + result.getMethod().getMethodName());
        //devuelve fail en report y lo pinta de rojo al nombre del metodo
        ExtentReportsClass.logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
        //devuelve fail en report y lo pinta de rojo al error
        ExtentReportsClass.logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
        //agrega una screen shot donde falla el metodo
        String screenshotPath = getScreenShot(myDriver.getDriver(), result.getName());
        try {
            ExtentReportsClass.logger.fail("Test Case Failed Snapshot is below " + ExtentReportsClass.logger.addScreenCaptureFromPath(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //si el test no se ejecuta, devuelve el nombre del metodo
        System.out.println("SKIPPED: " + result.getMethod().getMethodName());
        //devuelve skipped en el report y lo pinta de naranja al nombre del metodo
        ExtentReportsClass.logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {}

    @Override
    public void onFinish(ITestContext context) {
        //cuando finaliza de correr el test, devuelve el nombre de la suite.
        System.out.println("Finished to run test: " + context.getName());
        //finaliza el reporte
        ExtentReportsClass.endReport();
    }
}

