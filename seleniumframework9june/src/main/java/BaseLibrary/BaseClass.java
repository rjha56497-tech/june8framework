package BaseLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import utils.CommonUtils;
import utils.ExcelReader;
import utils.PropertyReader;

public class BaseClass implements PropertyReader,CommonUtils,ExcelReader{
	String path="F:\\seleniumframework9june\\src\\test\\resources\\TestData\\config.properties";
	protected WebDriver driver;
	WebDriverWait Wait;

	public void setUp(String browser,String env) throws IOException {

		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("edge")) {
			 driver=new EdgeDriver();
		}
		if(env.equals("qa")) {
			driver.get(getReadData(path,"QAURL"));
		}
		driver.manage().window().maximize();
	}
		
	
	
	
	
	
	
	
	
	
	











	@Override
	public String getReadData(String Path, String Key) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream abc=new FileInputStream(Path);
		Properties p=new Properties();
		p.load(abc);
		return p.getProperty(Key);
	}






















	@Override
	public void click(WebElement ele) {
		Wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		Wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		
	}






















	@Override
	public void enterValue(WebElement ele, String value) {
		Wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		Wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.sendKeys(value);
		
		
	}






















	@Override
	public String readDatafromExcel(String path, String sheetname, int row, int col) throws IOException {
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet(sheetname);
		return sh.getRow(row).getCell(col).getStringCellValue();
	}

}
