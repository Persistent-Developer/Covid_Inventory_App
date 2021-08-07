package com.psl.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.psl.entity.Inventory;
import com.psl.entity.Store;

public class ExcelUtils {

	public static ByteArrayInputStream inventorysToExcel(List<Inventory> inventorys) throws IOException {
		String[] COLUMNs = {"product_id", "product_name", "price", "stock","product_group","category","low_stock_indicator","in_stock","item_type","monthly_quota_per_user","yearly_quota_per_user"};
		try(
				Workbook workbook = new XSSFWorkbook();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
		){
			CreationHelper createHelper = workbook.getCreationHelper();
	 
			Sheet sheet = workbook.createSheet("Inventory");
	 
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
	 
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
	 
			// Row for Header
			Row headerRow = sheet.createRow(0);
	 
			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}
	 
			// CellStyle for Age
//			CellStyle ageCellStyle = workbook.createCellStyle();
//			ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
	 
			int rowIdx = 1;
			for (Inventory inventory : inventorys) {
				Row row = sheet.createRow(rowIdx++);
	 
				row.createCell(0).setCellValue(inventory.getProduct_id());
				row.createCell(1).setCellValue(inventory.getProduct_name());
				row.createCell(2).setCellValue(inventory.getPrice());
				row.createCell(2).setCellValue(inventory.getStock());
				row.createCell(2).setCellValue(inventory.getProduct_group());
				row.createCell(2).setCellValue(inventory.getCategory());
				row.createCell(2).setCellValue(inventory.getLow_stock_indicator());
				row.createCell(2).setCellValue(inventory.getIn_stock());
				row.createCell(2).setCellValue(inventory.getItem_type());
				row.createCell(2).setCellValue(inventory.getMonthly_quota_per_user());
				row.createCell(2).setCellValue(inventory.getYearly_quota_per_user());
				
			}
	 
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
	
	public static List<Inventory> parseExcelFile(InputStream is) {
		try {
    		Workbook workbook = new XSSFWorkbook(is);
    		
     
    		Sheet sheet = workbook.getSheet("Inventory");
    		//System.out.println("**");
    		System.out.println("Sheet is present or not : " + sheet.getSheetName());
    		Iterator<Row> rows = sheet.iterator();
    		
    		List<Inventory> lstInventorys = new ArrayList<Inventory>();
    		
    		int rowNumber = 0;
    		while (rows.hasNext()) {
    			Row currentRow = rows.next();
    			
    			// skip header
    			if(rowNumber == 0) {
    				rowNumber++;
    				continue;
    			}
    			
    			Iterator<Cell> cellsInRow = currentRow.iterator();

    			Inventory invt = new Inventory();
    			Store st = new Store();
    			
    			int cellIndex = 0;
    			while (cellsInRow.hasNext()) {
    				Cell currentCell = cellsInRow.next();
    			
    				if(cellIndex==0) { // ID
    					System.out.println(currentCell.getNumericCellValue());
    					invt.setProduct_id((int) currentCell.getNumericCellValue());
    				} else if(cellIndex==1) { // Name
    					System.out.println(currentCell.getStringCellValue());
    					invt.setProduct_name(currentCell.getStringCellValue());
    				} else if(cellIndex==2) { // Address
    					System.out.println(currentCell.getNumericCellValue());
    					invt.setPrice((double)currentCell.getNumericCellValue());
    				} else if(cellIndex==3) { // Age
    					System.out.println(currentCell.getNumericCellValue());
    					invt.setStock((int) currentCell.getNumericCellValue());
    				} else if(cellIndex==4) { // Name
    					System.out.println(currentCell.getStringCellValue());
    					invt.setProduct_group(currentCell.getStringCellValue());
    				}else if(cellIndex==5) { // Name
    					System.out.println(currentCell.getStringCellValue());
    					invt.setCategory(currentCell.getStringCellValue());
    				} else if(cellIndex==6) { // ID
    					System.out.println(currentCell.getNumericCellValue());
    					invt.setLow_stock_indicator((int) currentCell.getNumericCellValue());
    				} else if(cellIndex==7) { // Name
    					System.out.println(currentCell.getStringCellValue());
    					invt.setIn_stock(currentCell.getStringCellValue());
    				} else if(cellIndex==8) { // Name
    					System.out.println(currentCell.getStringCellValue());
    					invt.setItem_type(currentCell.getStringCellValue());
    				} else if(cellIndex==9) { // Name
    					System.out.println(currentCell.getNumericCellValue());
    					String temp = (Integer.valueOf((int) currentCell.getNumericCellValue())).toString();
    					invt.setMonthly_quota_per_user(temp);
    				} else if(cellIndex==10) { // Name
    					switch(currentCell.getCellType()) {
    					case Cell.CELL_TYPE_NUMERIC: 
        					System.out.println(currentCell.getNumericCellValue());
        					String temp = (Integer.valueOf((int) currentCell.getNumericCellValue())).toString();
        					invt.setYearly_quota_per_user(currentCell.getStringCellValue());
        					break;
    					case Cell.CELL_TYPE_STRING:
    						System.out.println(currentCell.getStringCellValue());
    						invt.setYearly_quota_per_user(currentCell.getStringCellValue());
    						break;
    					

    					}
    					
    				} else if(cellIndex==11) { // Name
    					System.out.println(currentCell.getNumericCellValue());
    					
    					st.setId((int)currentCell.getNumericCellValue());
    				}
    				
    				cellIndex++;
    			}
    			
    			lstInventorys.add(invt);
    		}
    		
    		// Close WorkBook
    		workbook.close();
    		
    		return lstInventorys;
        } catch (IOException e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
	}
}
