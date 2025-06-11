package com.mart.vibe.api.baseclass;

import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;

import com.mart.vibe.api.genericUtility.DataBaseUtility;
import com.mart.vibe.api.genericUtility.FileUtility;
import com.mart.vibe.api.genericUtility.JavaUtility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseAPIClass {

	public static  JavaUtility jLib = new JavaUtility();
	public static  DataBaseUtility dLib = new DataBaseUtility();
	public static FileUtility fLib = new FileUtility();
	public static RequestSpecification specReqObj;
	public static ResponseSpecification specRespObj;

	@BeforeSuite
	public void configBs() throws Throwable {
		dLib.getDbConnection();
		System.out.println("===Connect to DB===");

		RequestSpecBuilder reqspec = new RequestSpecBuilder();
		reqspec.setContentType(ContentType.JSON);
		reqspec.setBaseUri(fLib.getDataFromPropertiesFile("BaseUri"));
		specReqObj = reqspec.build();

		ResponseSpecBuilder resspec = new ResponseSpecBuilder();
		resspec.expectContentType(ContentType.JSON);
		specRespObj = resspec.build();

	}

	@AfterSuite
	public void configAs() throws Throwable {
		dLib.closeDbConnection();
		System.out.println("===Disconnect to DB===");
	}
}
