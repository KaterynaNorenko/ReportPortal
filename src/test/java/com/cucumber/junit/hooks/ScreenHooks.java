package com.cucumber.junit.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.cucumber.junit.driver.DriverManager;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenHooks {
    @After
    public void getScreenshot(Scenario scenario) throws IOException {
        Date currentDate = new Date();
        String ssFileName = currentDate.toString();
        File ssFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

        if (scenario.isFailed()){
            FileUtils.copyFile(ssFile, new File(".//screenshot//"+ssFileName+".png"));
        }
        DriverManager.getDriver().quit();
    }
}

