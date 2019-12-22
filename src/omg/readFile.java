package omg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class readFile {

	 private static final String EXCEL_FILE_LOCATION = "C:\\Users\\sagar\\Music\\Test.xls.xlt";

	 public static void createfile(String filename,String content) throws IOException
	 {
		 File myObj = new File("C:\\Users\\sagar\\Desktop\\123\\"+filename+".txt"); 
		 myObj.createNewFile();
		 FileWriter myWriter = new FileWriter("C:\\Users\\sagar\\Desktop\\123\\"+filename+".txt");
		 // Writes this content into the specified file
		myWriter.write(content); 
		 
		// Closing is necessary to retrieve the resources allocated
		myWriter.close(); 
	 }
	    public static void main(String[] args) {
	    	int rowcount;
	        Workbook workbook = null;
	        try {

	            workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
	            
	            Sheet sheet = workbook.getSheet(0);
	            rowcount=sheet.getRows();
	            System.out.println(rowcount);
	            for(int i=1;i<rowcount;i++)
	            {
	            	Cell cell1 = sheet.getCell(0,i);
	            	System.out.println("filename");
	            	System.out.println(cell1.getContents());
	            	Cell cell2 = sheet.getCell(1,i);
	            	System.out.println("content");
	            	System.out.println(cell2.getContents());
	            createfile(cell1.getContents(), cell2.getContents());
	            }
	           
	          
	           

	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {

	            if (workbook != null) {
	                workbook.close();
	            }

	        }

	    

	}

}
