package CommonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {

	public static void main(String[] args) throws IOException {
		File excel = new File("./src/test/resources/SwagLabs_InputData.xls");
		//System.out.println(excel.exists());
		FileInputStream excelfile = new FileInputStream(excel);
		HSSFWorkbook workbook = new HSSFWorkbook(excelfile);
		HSSFSheet sheet = workbook.getSheetAt(1);
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowcount-1][colcount];
		for(int i=0; i<rowcount-1; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
			
		}
		workbook.close();
		excelfile.close();
		
	}

}
