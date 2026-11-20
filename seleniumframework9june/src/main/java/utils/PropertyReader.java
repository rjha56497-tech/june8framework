package utils;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public interface PropertyReader {
	
	public String getReadData(String Path,String Key) throws IOException;

	

}
