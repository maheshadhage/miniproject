package com.miniproject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {
		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getusername() {
		String username = pro.getProperty("username");
		return username;
	}

	public String getpassword() {
		String pwd = pro.getProperty("password");
		return pwd;
	}

	public String getchromepath() {
		String cpath = pro.getProperty("chromepath");
		return cpath;
	}

	public String getfirefoxpath() {
		String ffpath = pro.getProperty("firefoxpath");
		return ffpath;
	}
}
