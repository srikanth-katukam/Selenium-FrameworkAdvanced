package com.salesforce.testcases;

import com.salesforce.Waits;
import com.salesforce.factory.DataProvider;
import com.salesforce.pages.AccountPage;
import com.salesforce.pages.BasePage;
import com.salesforce.pages.LoginPage;
import javafx.scene.layout.Priority;
import org.junit.Before;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.misc.BASE64Decoder;

import java.io.IOException;

/**
 * Created by Sunil Vanga on 10/28/2018.
 */
public class AccountTest extends BasePage {
    AccountPage accountPage;
    LoginPage loginPage;

    public AccountTest() throws Exception {
        super();
    }

    @BeforeMethod
    public void init() throws Exception {
        initialization();
        loginPage = new LoginPage();
        loginPage.loginLink();
        loginPage.login(DataProvider.getExcel().getData(1, 1, 0), DataProvider.getExcel().getData(1, 1, 1));
    }

    @Test(priority = 1)
    public void createaccount() throws Exception {
        accountPage = new AccountPage();
        accountPage.clickonAccount();
        accountPage.go();
        accountPage.newAccount();
        accountPage.provideAccountName(DataProvider.getExcel().getData(0, 1, 1));
        accountPage.save();
    }

    @Test(priority = 2)
    public void fileUpload() throws Exception {
        accountPage = new AccountPage();
        accountPage.fileUpload();
        accountPage.clickToUpload();
        accountPage.upload();

    }

    @Test(priority = 3)
    public void selectTabs() throws Exception {
        accountPage = new AccountPage();
        accountPage.clickonAccount();
        accountPage.go();
        accountPage.editAccount();
        accountPage.expandQuickAccessMenu();
        accountPage.editApp();
        accountPage.selectTab();
    }

    @AfterMethod
    public void tear() {
        quit();
    }

}

