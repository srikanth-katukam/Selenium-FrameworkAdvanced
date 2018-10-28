package com.salesforce.pages;

import com.salesforce.Waits;
import com.salesforce.factory.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * Created by Sunil Vanga on 10/28/2018.
 */
public class AccountPage extends BasePage {
    WebDriver ldriver;
    @FindBy(xpath="//a[text()='Accounts']")    WebElement AccountTab;
    @FindBy(id="fcf")    WebElement SelectAccount;
    @FindBy(xpath="//input[@name='go']")    WebElement Go;
    @FindBy(name="new")    WebElement NewAccount;
    @FindBy(xpath="//input[@name='acc2']")    WebElement AccountName;
    @FindBy(name="save")    WebElement Save;
    @FindBy(xpath="//a[@id='publisherAttachContentPost']")    WebElement fileUpload;
    @FindBy(id="chatterUploadFileAction")    WebElement clickToUpload;
    @FindBy(id="chatterFile")    WebElement chatterUpload;
    @FindBy(xpath="//img[@title='Expand Quick Access Menu']")    WebElement ExpandQuickAccessMenu;
    @FindBy(xpath="//a[text()='Edit App']")    WebElement EditApp;
    @FindBy(xpath="//select[@id='duel_select_0']/option[text()='Cases']")    WebElement avalableTab;
    @FindBy(xpath="//img[@title='Add']")    WebElement addTab;
    @FindBy(xpath="//select[@id='duel_select_1']/option[text()='Cases']")    WebElement selectedTab;
    @FindBy(id="publishersharebutton")    WebElement Share;

    @FindBy(xpath="//a/span[text()='Demo Account']")    WebElement EditAccount;
    public AccountPage() throws Exception{
        PageFactory.initElements(driver,this);
        ldriver=driver;

    }
    public void clickonAccount() throws Exception{
        Waits.waitForAnElement(ldriver,AccountTab);
        AccountTab.click();
    }
    public void selectView(String selectView){
        Select select=new Select(SelectAccount);
        Waits.waitForAnElement(ldriver,SelectAccount);
        select.selectByValue(selectView);
    }
    public void go() throws Exception{
        Waits.waitForAnElement(ldriver,Go);
        Go.click();
    }
    public void newAccount() throws Exception{
        Waits.waitForAnElement(ldriver,NewAccount);
        NewAccount.click();
    }
    public void editAccount() throws Exception{
        Waits.waitForAnElement(ldriver,EditAccount);
        EditAccount.click();
    }
    public void provideAccountName(String accountName) throws Exception{
        Waits.waitForAnElement(ldriver,AccountName);
        AccountName.sendKeys(accountName);
    }
    public void save() throws Exception{
        Waits.waitForAnElement(ldriver,Save);
        Save.click();
    }

    public void fileUpload() throws Exception {
        Waits.waitForAnElement(ldriver, fileUpload);
        fileUpload.click();

    }
    public void clickToUpload() throws Exception {
        Waits.waitForAnElement(ldriver, clickToUpload);
        clickToUpload.click();

    }

    public void upload() throws Exception {
        Waits.waitForAnElement(ldriver, chatterUpload);
        chatterUpload.click();
        StringSelection strSel = new StringSelection("D:\\ZenQAutomationFW\\src\\main\\resources\\Documents\\TextFile.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);

        //Create an object for robot class
        Robot robot = new Robot();
        //Control key in the keyboard
        //Ctrl+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        Share.click();
    }
    public void expandQuickAccessMenu() throws Exception {
        Waits.waitForAnElement(ldriver, ExpandQuickAccessMenu);
        ExpandQuickAccessMenu.click();

    }
    public void editApp() throws Exception {
        Waits.waitForAnElement(ldriver, EditApp);
        EditApp.click();
    }
    public void selectTab()throws Exception{
        Waits.waitForAnElement(ldriver, avalableTab);
        avalableTab.click();
        Waits.waitForAnElement(ldriver, addTab);
        addTab.click();
        Waits.waitForAnElement(ldriver, selectedTab);
        Assert.assertEquals(selectedTab.getText(),"Cases");
    }

}
