package core.allure;

import core.driver.DriverSession;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(final ITestResult result) {
        takeScreenshot();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        WebDriver driver = DriverSession.getDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
