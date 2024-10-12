package com.Test;

import org.testng.annotations.Test;

import com.WebPages.LoginPage;
import com.baseMethods.BaseClass;
import com.testdata.PropertyFile;

public class LoginTest  extends BaseClass
{
	LoginPage login = new LoginPage();
	
	 

	@Test
	public void login()
	{   
		Driverinit(PropertyFile.getproperty("Browser"));
		
		login.applicationLaunch();
	    login.enteritemName("Soaps");
	}

}
