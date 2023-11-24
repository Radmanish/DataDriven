package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	 public static String[][] getData(String fileName, String sheetName) {
	        try {
	        	File file = new File(fileName);
	            FileInputStream inputStream = new FileInputStream(file);
	            Workbook workbook = new XSSFWorkbook(inputStream);

	            // Get the specified sheet
	            Sheet sheet = workbook.getSheet(sheetName);

	            // Get the number of rows and columns
	            int rows = sheet.getPhysicalNumberOfRows();
	            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

	            // Create a 2D array to store the data
	            String[][] data = new String[rows][cols];

	            // Create a DataFormatter to format and read the cell values
	            DataFormatter dataFormatter = new DataFormatter();

	            // Iterate through each row
	            for (int i = 0; i < rows; i++) {
	                // Iterate through each cell in the row
	                Row row = sheet.getRow(i);
	                for (int j = 0; j < cols; j++) {
	                    // Use DataFormatter to get the formatted cell value as a String
	                    data[i][j] = dataFormatter.formatCellValue(row.getCell(j));
	                }
	            }

	            // Close the workbook and input stream
	            workbook.close();
	            inputStream.close();

	            return data;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null; // Handle the exception appropriately in your application
	        }
	    }

}
