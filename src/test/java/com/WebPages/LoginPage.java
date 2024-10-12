package com.WebPages;

import org.openqa.selenium.By;

import com.baseMethods.BaseClass;
import com.testdata.PropertyFile;



public class LoginPage extends BaseClass
{
	private By search_Bar = By.xpath("(.//*[@id='inputValEnter'or @name='keyword'])[1]");
	private By seach_button = By.xpath("//span[@class='searchTextSpan']");
	public void applicationLaunch()
	{
		launchURL(PropertyFile.getproperty("URL"));
	}
	
	public void enteritemName(String name)
	{
		sendInput(search_Bar, name);
		waitClick(seach_button);
	}
	

}
