package com.automation.utils;

import com.automation.models.CreateAccountData;

public class UserTestData {

    public static final String FIRST_NAME = "FirstName";
    public static final String LAST_NAME = "LastName";
    public static final String USERNAME = ConfigReader.getProperty("user.email");
    public static final String PASSWORD = ConfigReader.getProperty("user.password");
    public static final String FS_USERNAME = ConfigReader.getProperty("user.emailfamilystore");

    // Generate a new email EVERY TIME someone calls the method
    public static String getDisposableYopmailEmailAddress() {
        var number = WebElementUtil.getRandomNumber(10000);
        return "automationTestEngineer_" + number + "@yopmail.com";
    }
    
    public static String getDisposableMailDropEmailAddress() {
        var number = WebElementUtil.getRandomNumber(10000);
        return "automationTestEngineer_" + number + "@maildrop.cc";
    }
    
    public static CreateAccountData getCreateAccountData() {
    	return new CreateAccountData(getDisposableMailDropEmailAddress()
    			,FIRST_NAME,LAST_NAME,PASSWORD);
    }
}