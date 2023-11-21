package CommonUtils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class ExcelRead_Purchase {
	
String[][] data = null;
	
	public String[][] getpurchasedetails() throws IOException {
				
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream excel = classLoader.getResourceAsStream("TestData/InputData.xls");

		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(excel);
		HSSFSheet sheet = workbook.getSheetAt(2);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellcount = sheet.getRow(0).getPhysicalNumberOfCells();
		String purchasedata[][] = new String[rowCount-1][cellcount];
		for (int i = 1; i < rowCount; i++) { // Start from 1 to skip the header row
		    Row row = sheet.getRow(i);
		    for (int j = 0; j < cellcount; j++) {
		        Cell cell = row.getCell(j);
		        if (cell != null) {
		            if (cell.getCellType() == CellType.NUMERIC) {
		                // Handle numeric cell
		            	purchasedata[i - 1][j] = String.valueOf(cell.getNumericCellValue());
		            } else if (cell.getCellType() == CellType.STRING) {
		                // Handle string cell
		            	purchasedata[i - 1][j] = cell.getStringCellValue();
		            }
		        }
		    }
		}
		return purchasedata;
	}
}
