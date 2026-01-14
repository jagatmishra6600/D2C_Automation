package com.automation.models;

public record ShippingAddressData(
		String emailAddress
		,String firstName
		,String lastName
		,String addressLine1
		,String addressLine2
		,String city
		,String state
		,String zipCode
		,String phoneNumber) {

}
