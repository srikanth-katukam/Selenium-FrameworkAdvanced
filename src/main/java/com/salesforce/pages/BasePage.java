package com.salesforce.pages;

import com.salesforce.dataprovider.ConfigurationDataProvider;
import com.salesforce.factory.BrowserFactory;
import com.salesforce.factory.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Sunil Vanga on 10/28/2018.
 */
public class BasePage extends ConfigurationDataProvider {
    static WebDriver driver;
    public static Properties prop;
    ConfigurationDataProvider provider;
    public  BasePage() throws IOException {
        super();
    }
    public void initialization(){
        driver = BrowserFactory.getBrowser("firefox");
        provider = new ConfigurationDataProvider();
        driver.get(provider.applicationURL());
    }
public static void quit(){
    driver.close();
}
}
