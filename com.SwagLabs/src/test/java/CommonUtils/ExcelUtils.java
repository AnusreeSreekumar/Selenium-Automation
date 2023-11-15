package CommonUtils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {

	String[][] data = null;
	String[][] testdata = null;
	
	public String[][] getlogindata() throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream excel = classLoader.getResourceAsStream("TestData/InputData.xls");

		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(excel);
		HSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int cellcount = sheet.getRow(1).getLastCellNum();
		String logindata[][] = new String[rowCount][cellcount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < cellcount; j++) {
				logindata[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
			}
		}
		return logindata;
	}

	public String[][] getpurchasedata() throws IOException {

		ClassLoader classLoader = getClass().getClassLoader();
		InputStream excel = classLoader.getResourceAsStream("TestData/InputData.xls");
//		FileInputStream excel = new FileInputStream("TestData.InputData.xls");

		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(excel);
		HSSFSheet sheet = workbook.getSheetAt(1);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int cellcount = sheet.getRow(1).getLastCellNum();
		String purchasedata[][] = new String[rowCount][cellcount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < cellcount; j++) {
				purchasedata[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
			}
		}
		return purchasedata;
	}
	
	public String[][] getproblemuser() throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream excel = classLoader.getResourceAsStream("TestData/InputData.xls");
//		FileInputStream excel = new FileInputStream("TestData.InputData.xls");

		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(excel);
		HSSFSheet sheet = workbook.getSheetAt(2);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int cellcount = sheet.getRow(1).getLastCellNum();
		String logindata[][] = new String[rowCount][cellcount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < cellcount; j++) {
				logindata[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
			}
		}
		return logindata;
	}

	
	//@SuppressWarnings("resource")
//	private static void writeDataToExcel(String prdtname, String message1, String message2) {
//		try {
//			String excelFilePath = "src/test/resources/TestData";
//			 HSSFWorkbook workbook;
//		     HSSFSheet sheet;
//
//			File file = new File(excelFilePath);
//
//			if (file.exists()) {
//				FileInputStream inputStream = new FileInputStream(file);
//				workbook = new HSSFWorkbook(inputStream);
//				sheet = workbook.getSheetAt(0);
//			} else {
//				workbook = new HSSFWorkbook();
//				sheet = workbook.createSheet();
//				createHeaderRow(sheet);
//			}
//
//			int lastRowNum = sheet.getLastRowNum();
//			int newRowNum = lastRowNum + 1;
//
//			HSSFRow row = sheet.createRow(newRowNum);
//			row.createCell(0).setCellValue(prdtname);
//			row.createCell(1).setCellValue(message1);
//			row.createCell(2).setCellValue(message2);
//
//			try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
//				workbook.write(outputStream);
//				System.out.println("Excel file updated successfully.");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void createHeaderRow(HSSFSheet sheet) {
//		HSSFRow headerRow = sheet.createRow(0);
//		headerRow.createCell(0).setCellValue("Product Name");
//		headerRow.createCell(1).setCellValue("ThankYou Note");
//		headerRow.createCell(2).setCellValue("Confirmation");
//	}
}
