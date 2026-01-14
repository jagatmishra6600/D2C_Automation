package com.automation.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.automation.models.CreateAccountData;
import com.automation.models.FSCreateAccountData;
import com.automation.models.ShippingAddressData;
import com.github.javafaker.Faker;

public class UserTestData {

    public static final String FIRST_NAME = "FirstName";
    public static final String LAST_NAME = "LastName";
    public static final String USERNAME = ConfigReader.getProperty("user.email");
    public static final String PASSWORD = ConfigReader.getProperty("user.password");
    public static final String FS_USERNAME = ConfigReader.getProperty("user.emailfamilystore");
    public static final String ZIPCODE = "40001";
    public static final String INVALID_CREDIT_CARD = "3782-822463-10005";
    public static final String INVALID_CREDIT_CARD_CVV = "1234";
    
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
    
    public static ShippingAddressData getRandomUSAddressData() {
    	Faker randomAddressData = new Faker(Locale.US);
    	return generateRandomAddress(randomAddressData);
    	
    }
    
    public static ShippingAddressData getRandomCanadaAddressData() {
    	Faker randomAddressData = new Faker(Locale.CANADA);
    	return generateRandomAddress(randomAddressData);
    }
    
    private static ShippingAddressData generateRandomAddress(Faker randomAddressData) {
    	return new ShippingAddressData(getDisposableMailDropEmailAddress()
    			,randomAddressData.name().firstName()
				,randomAddressData.name().lastName()
				,randomAddressData.address().buildingNumber()
				,randomAddressData.address().streetAddressNumber()
				,randomAddressData.address().city()
				,randomAddressData.address().state()
				,randomAddressData.address().zipCode()
				,randomAddressData.phoneNumber().phoneNumber());
    }
    
    public static List<String> getCreditCardDetailsList() {
        return new ArrayList<>(List.of(
        		INVALID_CREDIT_CARD, //card Number
                getFutureExpiryDate(), //Future Expiry Date in MM/YY
                INVALID_CREDIT_CARD_CVV, //CVV
                FIRST_NAME //Name On Card
        ));
    }
    
    private static String getFutureExpiryDate() {
    	return LocalDate.now()
        .plusMonths(6)                    
        .format(DateTimeFormatter.ofPattern("MM/yy"));
    }
}