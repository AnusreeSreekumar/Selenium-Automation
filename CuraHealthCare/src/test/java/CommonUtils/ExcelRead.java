package CommonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	
//	@Test(dataProvider = "InputData")
//	public void InputData(String facility, String facilitytxt,  String readmsn, String prgm, String monthyear, int date) throws IOException {
//		
////		getappointmentdata();
//		System.out.println(facility + facilitytxt + readmsn + prgm + monthyear + date);
//	}
//	
//	@DataProvider(name = "InputData")
	public Object[][] getappointmentdata() throws IOException {
		
//		ClassLoader classLoader = getClass().getClassLoader();
//		InputStream excel = classLoader.getResourceAsStream("E:\\Anusree\\Automation\\Selenium\\TestData\\CuraHC_TestData.xlsx");
		
		File f1 = new File("E:\\Anusree\\Automation\\Selenium\\TestData\\CuraHC_TestData.xlsx");
		FileInputStream excel = new FileInputStream(f1);
		
		@SuppressWarnings("resource")
		
		XSSFWorkbook workbook = new XSSFWorkbook(excel);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int cellcount = sheet.getRow(1).getLastCellNum();
		
		Object[][] regtrndata = new Object[rowCount][cellcount];
		
		for (int r = 0; r < rowCount; r++) {
			
			XSSFRow row = sheet.getRow(r+1);
			for (int c = 0; c < cellcount; c++) {
				
				XSSFCell cell = row.getCell(c);
				if(cell != null) {
					
					switch(cell.getCellType()) {
					
						case STRING:
							regtrndata[r][c] = cell.getStringCellValue();
							break;
						case NUMERIC:
							regtrndata[r][c] = Integer.toString((int) cell.getNumericCellValue());
							break;
					default:
						break;
					}
					
				}
//				regtrndata[r][c] = sheet.getRow(r + 1).getCell(c).getStringCellValue();
			}
		}
//		System.out.println(regtrndata);
		return regtrndata;
	}

}
