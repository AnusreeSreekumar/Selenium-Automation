package CommonUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public Object[][] getappointmentdata() throws IOException {

		XSSFWorkbook workbook = null;
		InputStream excel = null;

		try {
			
			/* The excel file with data is placed inside src/main/resources folder in the mvn project and hence calling the file as such */
			
			excel = getClass().getClassLoader().getResourceAsStream("CuraHC_TestData.xlsx");  

			workbook = new XSSFWorkbook(excel);
			XSSFSheet sheet = workbook.getSheetAt(0);

			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			int cellcount = sheet.getRow(1).getLastCellNum();

			Object[][] regtrndata = new Object[rowCount][cellcount];

			for (int r = 0; r < rowCount; r++) {

				XSSFRow row = sheet.getRow(r + 1);
				for (int c = 0; c < cellcount; c++) {

					XSSFCell cell = row.getCell(c);
					if (cell != null) {

						switch (cell.getCellType()) {

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
				}
			}
			return regtrndata;
		} finally {

			if (excel == null) {
				throw new FileNotFoundException("Resource 'CuraHC_TestData.xlsx' not found");
			}

			if (workbook != null) {
				workbook.close();
			}
			if (excel != null) {
				excel.close();
			}
		}
	}

}
