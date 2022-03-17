package dataDrivenTesting;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;



public class ExcelRead {
	

	@DataProvider(name="loginData")
	
	public static Object[][] getData() {
		
		XSSFWorkbook ExcelWBook;
		XSSFSheet ExcelWSheet;
		XSSFCell Cell;
		
		// Location of the file
		String path = "/Users/monicasanchez/Downloads/Tests.xlsx";
		String sheetName = "Sheet1";
	
		try {
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			
			// initialize result array
			int totalRows = ExcelWSheet.getLastRowNum();
			String[][] result = new String[totalRows][2];
			System.out.println(totalRows);
			
			for(int i = ExcelWSheet.getFirstRowNum(); i < totalRows; i++) {
				for(int j=0; j<2; j++) {
					result[i][j] = ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
			
			//Cell = ExcelWSheet.getRow(1).getCell(1);
			//String cellData = Cell.getStringCellValue();
			//System.out.println("Cell Data: " + cellData);
			
			return result;
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
