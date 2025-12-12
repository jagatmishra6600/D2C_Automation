package com.automation.utils;

import com.automation.models.CreateAccountData;
import com.automation.models.FSCreateAccountData;

public class UserTestData {

    public static final String FIRST_NAME = "FirstName";
    public static final String LAST_NAME = "LastName";
    public static final String USERNAME = ConfigReader.getProperty("user.email");
    public static final String PASSWORD = ConfigReader.getProperty("user.password");
    public static final String FS_USERNAME = ConfigReader.getProperty("user.emailfamilystore");
    public static final String ZIPCODE = "40001";
    
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
    
    public static String getUserName() {
    	var brand = ConfigReader.getBrand();
    	if(brand.equalsIgnoreCase("elux") || brand.equalsIgnoreCase("electrolux")	
    			||brand.equalsIgnoreCase("frigidaire")) {
    		return USERNAME;
    	}
    	else if(brand.equalsIgnoreCase("fsus")|| brand.equalsIgnoreCase("familystoreus")) {
    		return FS_USERNAME;
    	}
    	return USERNAME;
    }
    
    public static String getPassword() {
    	return PASSWORD;
    }
    
    public static CreateAccountData getInviteUserData(String emailAddress) {
    	return new CreateAccountData(emailAddress
    			,FIRST_NAME,LAST_NAME,PASSWORD);
    }
    
    public static FSCreateAccountData getFSCreateAccountData(String emailAddress, String invitationCode) {
    	return 	new FSCreateAccountData(emailAddress
    				,FIRST_NAME,LAST_NAME,PASSWORD,invitationCode,ZIPCODE);
    }
    
    public static String generateRandomPassword() {
    	return "Test@1234_"+generateRandomNumber();
    }
    
    private static int generateRandomNumber() {
    	return WebElementUtil.getRandomNumber(10000);
    }
}