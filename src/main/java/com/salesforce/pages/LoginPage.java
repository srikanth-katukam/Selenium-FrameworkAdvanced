package com.salesforce.pages;

import com.salesforce.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.UnableToCreateProfileException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Sunil Vanga on 10/28/2018.
 */
public class LoginPage extends BasePage {
WebDriver ldriver;
    @FindBy(id="username")
    WebElement UserName;
    @FindBy(id="password") WebElement password;
    @FindBy(id="Login") WebElement Login;
    @FindBy(xpath="//div[@aria-label='Login']/a") WebElement LoginLink;
    public LoginPage() throws IOException {
        PageFactory.initElements(driver, this);
        ldriver=driver;
    }
    public void loginLink(){
        Waits.waitForAnElement(ldriver,LoginLink);
        LoginLink.click();
    }
    public void login(String UName,String Pwd) throws Exception{
        Waits.waitForAnElement(ldriver,UserName);
        UserName.sendKeys(UName);
        Waits.waitForAnElement(ldriver,password);
        password.sendKeys(Pwd);
        Waits.waitForAnElement(ldriver,Login);
        Login.click();
        Thread.sleep(10000);

    }
}
