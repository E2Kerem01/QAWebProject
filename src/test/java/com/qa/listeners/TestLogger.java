package com.qa.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestLogger implements ITestListener {
    @Override public void onTestSuccess(ITestResult r){ Reporter.log("✅ PASS: " + r.getMethod().getMethodName(), true); }
    @Override public void onTestFailure(ITestResult r){ Reporter.log("❌ FAIL: " + r.getMethod().getMethodName(), true); }
    @Override public void onTestSkipped(ITestResult r){ Reporter.log("⏭️ SKIP: " + r.getMethod().getMethodName(), true); }
}