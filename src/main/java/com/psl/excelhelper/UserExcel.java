package com.psl.excelhelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.web.multipart.MultipartFile;

import com.psl.entity.Role;
import com.psl.entity.User;

public class UserExcel{
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = { "userId", "userName", "phNumber", "password","email","status",
		  "category","purchaseLimitPerYear", "purchaseLimitPerMonth","roleId" };
  
  static String SHEET = "users"; 

  public  boolean hasExcelFormat(MultipartFile file) {
   
	if (!TYPE.equals(file.getContentType())) {
      return false;
    }
   
    return true;
  }

  public  List<User> excelToUsers(InputStream IS) {
    try {
      Workbook workbook = new XSSFWorkbook(IS);

      Sheet sheet = workbook.getSheet(SHEET);
      Iterator<Row> rows = sheet.iterator();

      System.out.println("At entry level ----------------");
      List<User> users = new ArrayList<User>();

      int rowNumber = 0;
      while (rows.hasNext()) {
    	System.out.println("while started ----------------");
        Row currentRow = rows.next();

        // skip header
        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }

        Iterator<Cell> cellsInRow = currentRow.iterator();

        User user = new User();

        int cellIdx = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();
          		System.out.println("2nd while-----------------------");
          switch(cellIdx) {
          
          case 0:
             user.setUserId( (int) currentCell.getNumericCellValue());
          break;

          case 1:
             user.setUserName(currentCell.getStringCellValue());
          break;

          case 2:
            user.setPhNumber( (long) currentCell.getNumericCellValue());
          break;

          case 3:
            user.setPassword(currentCell.getStringCellValue());
          break;

          case 4:
            user.setEmail(currentCell.getStringCellValue());
          break;
          
          case 5:
              user.setStatus(currentCell.getStringCellValue());
          break;   
          
          case 6:
              user.setCategory(currentCell.getStringCellValue());
            break;
            
          case 7:
              user.setPurchaseLimitPerMonth((int)currentCell.getNumericCellValue());
          break;  
          
          case 8:
              user.setPurchaseLimitPerYear((int)currentCell.getNumericCellValue());
          break; 
          
          case 9:
        	  Role role = new Role();
        	  
        	  int rid = (int)currentCell.getNumericCellValue();
        	  role.setRoleId(rid);
        	  if(rid == 1) {
      			  role.setRoleName("Admin");
      		  }
      		
      		  else if(rid == 2) {
      			  role.setRoleName("Aggregator");
      		  }
      		
      		  else if(rid == 3) {
      			  role.setRoleName("Customer");
      		  }
              
        	  user.setRole(role);
        	  
          break;
          
          default:
            break;
          }

          cellIdx++;
        }

        users.add(user);
        
        System.out.println(user);
      }

      workbook.close();
      System.out.println("----------------done -----------------");
      return users;
    }
    
      catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }
}