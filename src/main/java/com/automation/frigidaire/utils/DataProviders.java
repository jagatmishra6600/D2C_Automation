package com.automation.frigidaire.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "kitchenProductData")
    public Object[][] getKitchenProductData() {
        return new Object[][]{
                {"Kitchen", "French Door",
                        "22 Cu. Ft. Counter-Depth 4-Door Refrigerator with Free Additional Filter Kit",
                        "French Door Refrigerators"},
        };
    }

    @DataProvider(name = "airConditionersProductData")
    public Object[][] getAirConditionersProductData() {
        return new Object[][]{
                {"Air Care", "Window Mounted AC", "6,000 BTU Window Room Air Conditioner", "Window Mounted Air Conditioners"},
                {"Air Care", "Window Mounted AC", "10,000 BTU Window Room Air Conditioner with Wi-Fi", "Window Mounted Air Conditioners"},
        };
    }

}
