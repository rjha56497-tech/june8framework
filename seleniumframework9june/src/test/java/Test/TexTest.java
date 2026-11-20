package Test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLibrary.BaseClass;
import POMRepository.PracticeForm;
import POMRepository.TextboxPage;

public class TexTest extends BaseClass {
	
	String path="F:\\seleniumframework9june\\src\\test\\resources\\TestData\\june8.xlsx";
	PracticeForm pf;
	TextboxPage tp;
	
	@Parameters({"browser","env"})
	@BeforeClass	
	public void initialize(String browser, String env) throws IOException {
		setUp(browser,env);
		pf=new PracticeForm(driver);
		tp=new TextboxPage(driver);
	}
	@Test 
	public void validateTextBox() throws IOException {
		pf.clickOnElements();
		pf.clickOntxtBtn();
		tp.enterfullname(readDatafromExcel(path, "sheet1", 1, 0));
		tp.enteremail(readDatafromExcel(path, "sheet1", 1, 1));
	}
}
