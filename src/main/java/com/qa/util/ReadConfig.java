package com.qa.util;

import java.io.FileInputStream;

import java.util.Properties;

/* Utility file to read data of Config.properties file. */

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\razda\\eclipse-workspace\\Projects\\Project1\\src\\main\\java\\com\\qa\\config\\config.properties");

			pro = new Properties();

			pro.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is :" + e.getMessage());
		}

	}

	public String getApplicationUrl() {
		return pro.getProperty("baseurl");
	}

	public String getBrowserName() {
		return pro.getProperty("browser");
	}

	public String getEnvironementName() {
		return pro.getProperty("environmentName");
	}

	public String getprojectName() {
		return pro.getProperty("projectName");
	}

	public String getTestDataFilePath() {
		return pro.getProperty("testDataXL");
	}

}
