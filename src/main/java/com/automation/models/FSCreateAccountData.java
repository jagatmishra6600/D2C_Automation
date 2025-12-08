package com.automation.models;

public record FSCreateAccountData(
	String emailAddress
	,String firstName
	,String lastName
	,String password
	,String invitationCode
	,String zipCode
) {}

