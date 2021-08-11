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
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.psl.dao.IInventoryDao;
import com.psl.entity.Inventory;
import com.psl.entity.Role;
import com.psl.entity.Store;
import com.psl.entity.User;
import com.psl.service.InventoryService;

public class ExcelUtils {
	
//	@Autowired
//	private InventoryService service;

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
				row.createCell(2).setCellValue(inventory.getlow_stock_indicator());
				row.createCell(2).setCellValue(inventory.getIn_stock());
				row.createCell(2).setCellValue(inventory.getItem_type());
				row.createCell(2).setCellValue(inventory.getMonthly_quota_per_user());
				row.createCell(2).setCellValue(inventory.getYearly_quota_per_user());
				
			}
	 
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
	
	public  List<Inventory> parseInventoryExcelFile(InputStream is) {
		try {
    		Workbook workbook = new XSSFWorkbook(is);
    		
     
    		Sheet sheet = workbook.getSheet("Inventory");
    		//System.out.println("**");
    		System.out.println("Sheet is present or not : " + sheet.getSheetName());
    		Iterator<Row> rows = sheet.iterator();
    		
    		List<Inventory> lstInventorys = new ArrayList<Inventory>();
    		
			
    		
    		int rowNumber = 0;
    		while (rows.hasNext()) {
    			System.out.println("**");
    			Row currentRow = rows.next();
    			
    			// skip header
    			if(rowNumber == 0) {
    				rowNumber++;
    				continue;
    			}
    			
    			Iterator<Cell> cellsInRow = currentRow.iterator();

    			Inventory invt = new Inventory();
    			//Store st = new Store();
    			
    			int cellIndex = 0;
    			while (cellsInRow.hasNext()) {
    				Cell currentCell = cellsInRow.next();
    			
    				if(cellIndex==0) { 
    					//System.out.println("***");
    					try {
    						
    						System.out.println("--");
    						String code = currentCell.getStringCellValue();
    						System.out.println("code = " + code);
    						InventoryService service = new InventoryService();
	    					Inventory i = service.getProducts(code);
	    					System.out.println("Name = " + i.getProduct_id());
	    					break;
//	    					if(i!=null) {
//	    						cellIndex = 3;
//	    						//System.out.println("ac");
//	    						
//	    						int updateStock = (int) (i.getStock() + currentCell.getNumericCellValue());
//	    						i.setStock(updateStock);
//	    						dao.save(i);
//	    						break;
//	    					}
    					} catch(Exception e) {
    						
    					}
    					
    					System.out.println(currentCell.getStringCellValue());
    					invt.setProduct_code(currentCell.getStringCellValue());
    				} else if(cellIndex==1) { 
    					System.out.println(currentCell.getStringCellValue());
    					invt.setProduct_name(currentCell.getStringCellValue());
    				} else if(cellIndex==2) { 
    					System.out.println(currentCell.getNumericCellValue());
    					invt.setPrice((double)currentCell.getNumericCellValue());
    				} else if(cellIndex==3) { 
    					System.out.println(currentCell.getNumericCellValue());
    					invt.setStock((int) currentCell.getNumericCellValue());
    				} else if(cellIndex==4) { 
    					System.out.println(currentCell.getStringCellValue());
    					invt.setProduct_group(currentCell.getStringCellValue());
    				}else if(cellIndex==5) {
    					System.out.println(currentCell.getStringCellValue());
    					invt.setCategory(currentCell.getStringCellValue());
    				} else if(cellIndex==6) { 
    					System.out.println(currentCell.getNumericCellValue());
    					invt.setlow_stock_indicator((int) currentCell.getNumericCellValue());
    				} else if(cellIndex==7) { 
    					System.out.println(currentCell.getStringCellValue());
    					invt.setIn_stock(currentCell.getStringCellValue());
    				} else if(cellIndex==8) { 
    					System.out.println(currentCell.getStringCellValue());
    					invt.setItem_type(currentCell.getStringCellValue());
    				} else if(cellIndex==9) { 
    					System.out.println(currentCell.getNumericCellValue());
    					String temp = (Integer.valueOf((int) currentCell.getNumericCellValue())).toString();
    					invt.setMonthly_quota_per_user(temp);
    				} else if(cellIndex==10) { 
    					switch(currentCell.getCellType()) {
    					case NUMERIC: 
        					System.out.println(currentCell.getNumericCellValue());
        					//String temp = (Integer.valueOf((int) currentCell.getNumericCellValue())).toString();
        					invt.setYearly_quota_per_user(Integer.toString((int) currentCell.getNumericCellValue()));
        					break;
    					case STRING:
    						System.out.println(currentCell.getStringCellValue());
    						invt.setYearly_quota_per_user(currentCell.getStringCellValue());
    						break;
    					

    					}
    					
    				} else if(cellIndex==11) { // Name
    					System.out.println(currentCell.getNumericCellValue());
    					Store st = new Store();
    					st.setId((int)currentCell.getNumericCellValue());
    					invt.setstore(st);
    				}
    				
    				cellIndex++;
    			}
    			
    			lstInventorys.add(invt);
    		}
    		
//    		for(Inventory inv : lstInventorys) {
//    			System.out.println(inv.getProduct_id());
//    		}
    		// Close WorkBook
    		workbook.close();
    		
    		return lstInventorys;
        } catch (IOException e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
	}
	
	public static List<User> parseUserExcelFile(InputStream is) {
		try {
    		Workbook workbook = new XSSFWorkbook(is);
    		
    			
    		Sheet sheet = workbook.getSheet("Sheet1");
    		//System.out.println("**");
    		System.out.println("Sheet is present or not : " + sheet.getSheetName());
    		Iterator<Row> rows = sheet.iterator();
    		
    		List<User> lstUsers = new ArrayList<User>();
    		
    		int rowNumber = 0;
    		while (rows.hasNext()) {
    			System.out.println("**");
    			Row currentRow = rows.next();
    			
    			// skip header
    			if(rowNumber == 0) {
    				rowNumber++;
    				continue;
    			}
    			
    			Iterator<Cell> cellsInRow = currentRow.iterator();

    			User usr = new User();
    			//Store st = new Store();
    			
    			int cellIndex = 0;
    			while (cellsInRow.hasNext()) {
    				Cell currentCell = cellsInRow.next();
    			
    				if(cellIndex==0) { 
    					//System.out.println("***");
    					System.out.println(currentCell.getStringCellValue());
    					usr.setPhNumber(currentCell.getStringCellValue());
    				} else if(cellIndex==1) { 
    					System.out.println(currentCell.getStringCellValue());
    					usr.setUserName(currentCell.getStringCellValue());
    				} else if(cellIndex==2) { 
    					System.out.println(currentCell.getNumericCellValue());
    					Role role = new Role();
    					role.setRoleId((int)currentCell.getNumericCellValue());
    					usr.setRole(role);
    				} else if(cellIndex==3) { 
    					System.out.println(currentCell.getStringCellValue());
    					usr.setStatus(currentCell.getStringCellValue());
    				} else if(cellIndex==4) { 
    					System.out.println(currentCell.getStringCellValue());
    					usr.setCategory(currentCell.getStringCellValue());
    				}else if(cellIndex==5) {
    					System.out.println(currentCell.getNumericCellValue());
    					usr.setPurchaseLimitPerYear((int)currentCell.getNumericCellValue());
    				} else if(cellIndex==6) { 
    					System.out.println(currentCell.getNumericCellValue());
    					usr.setPurchaseLimitPerMonth((int) currentCell.getNumericCellValue());
    				} else if(cellIndex==7) { 
    					System.out.println(currentCell.getStringCellValue());
    					usr.setEmail(currentCell.getStringCellValue());
    				} else if(cellIndex==8) { 
    					System.out.println(currentCell.getStringCellValue());
    					usr.setPassword(currentCell.getStringCellValue());
    				}
    				
    				cellIndex++;
    			}
    			
    			lstUsers.add(usr);
    		}
    		
//    		for(Inventory inv : lstInventorys) {
//    			System.out.println(inv.getProduct_id());
//    		}
    		// Close WorkBook
    		workbook.close();
    		
    		return lstUsers;
        } catch (IOException e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
	}
}
