package utils;

import java.io.IOException;

public interface ExcelReader {
	public String readDatafromExcel(String path,String sheetname,int row,int col) throws IOException;

}
    