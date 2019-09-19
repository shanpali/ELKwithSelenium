package core;

import org.testng.IExecutionListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static java.time.LocalDateTime.*;

public class ExecutionListener implements ITestListener {

  private TestStatus testStatus;

  public void onTestStart(ITestResult iTestResult) {
    this.testStatus = new TestStatus();
  }

  public void onTestSuccess(ITestResult iTestResult) {
    this.sendStatus(iTestResult, "PASS");
  }

  public void onTestFailure(ITestResult iTestResult) {
    this.sendStatus(iTestResult, "FAIL");
  }

  public void onTestSkipped(ITestResult iTestResult) {
    this.sendStatus(iTestResult, "SKIPPED");
  }

  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    // skip
  }

  public void onStart(ITestContext iTestContext) {
    // skip
  }

  public void onFinish(ITestContext iTestContext) {
    // skip
  }

  private void sendStatus(ITestResult iTestResult, String status) {
    this.testStatus.setTestClass(iTestResult.getTestClass().getName());
    this.testStatus.setDescription(iTestResult.getMethod().getDescription());
    this.testStatus.setStatus(status);
    this.testStatus.setExecutionDate(now().toString());
    new ResultSender().send(this.testStatus);
  }
}
