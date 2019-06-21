package common;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Excel {
	private XSSFWorkbook workbook = null;
	private XSSFSheet  sheet = null;
	private File tmpdir = null;
	private int int_currentrow;
	private int int_currentcolumn;
	private Row row = null;
	private Cell cell = null;	
	private String str_filepath;
	private static final String str_defaultpath ="C:\\Test0\\AutozoneTraining\\";
	private static final String str_extensionfile = ".xls";
	private static FileName fn = null;
		
	
	public Excel(String str_filepath, String str_sheet) throws IOException {
		String str_filename  = "";
		
		tmpdir = new File(str_filepath);
		if(tmpdir.getName().length() > 0) {
			if(tmpdir.exists()) {
				File file = new File(str_filepath);
				FileInputStream fis = new FileInputStream(file);
				
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheet(str_sheet);
				int_currentrow = 0;
				int_currentcolumn = 0;
				this.str_filepath = str_filepath;				
			}
			else{
				try {
					tmpdir.createNewFile();
					workbook = new XSSFWorkbook();
					sheet = workbook.createSheet(str_sheet);
					int_currentrow = 0;
					int_currentcolumn = 0;
					this.str_filepath = str_filepath;
					
				}catch(IOException ioe) {
					System.out.println("Error while creating file" + ioe.getMessage());
				}		
			}	
		}
		else {
			fn = new FileName();
			str_filename = fn.createRandomName(str_extensionfile);
			str_filepath = str_filepath +  str_filename;
			tmpdir = new File(str_filepath);
			if(tmpdir.exists()){
				File file = new File(str_filepath);
				FileInputStream fis = new FileInputStream(file);
				
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheet(str_sheet);
				int_currentrow = 0;
				int_currentcolumn = 0;
				this.str_filepath = str_filepath;				
			}
			else{
				try {
					tmpdir.createNewFile();
					workbook = new XSSFWorkbook();
					sheet = workbook.createSheet(str_sheet);
					int_currentrow = 0;
					int_currentcolumn = 0;
					this.str_filepath = str_filepath;
					
				}catch(IOException ioe) {
					System.out.println("Error while creating file" + ioe.getMessage());
				}		
			}	
			
		}
		
		
		
		
	}
	
	public int getInt_currentrow() {
		return int_currentrow;
	}

	public void setInt_currentrow(int int_currentrow) {
		this.int_currentrow = int_currentrow;
	}

	public int getInt_currentcolumn() {
		return int_currentcolumn;
	}

	public void setInt_currentcolumn(int int_currentcolumn) {
		this.int_currentcolumn = int_currentcolumn;
	}

	public void addValue(String str_value) {		

		int int_tmp;
		
		System.out.println("before int_currentrow: " + int_currentrow);		
		int_tmp = getLastRow();
		int_currentrow = int_tmp;
		System.out.println("after int_currentrow: " + int_currentrow);
		if(sheet.getRow(int_currentrow) != null) {
			row = sheet.getRow(int_currentrow);
			cell = row.createCell(int_currentcolumn);
			cell.setCellValue(str_value);	
		}
		else {
			row = sheet.createRow(int_currentrow);
			cell = row.createCell(int_currentcolumn);
			cell.setCellValue(str_value);	
		}
	}
	
	private int getLastRow() {
		int int_row = int_currentrow;
		Row rw;
		rw  = sheet.getRow(int_row);		
		try {
			while(rw.getCell(int_currentcolumn).getStringCellValue().length() > 1) {
				System.out.println("Value : " + rw.getCell(int_currentcolumn).getStringCellValue());
				int_row ++;
				rw = sheet.getRow(int_row);				
			}			
		}catch(NullPointerException e) {
			System.out.println("");
		}	
		
		return int_row;
	}
	
	public void saveWorkbook() throws IOException {
		try (FileOutputStream outputStream = new FileOutputStream(str_filepath)) {
            workbook.write(outputStream);
        }
		catch(IOException ioe) {
			System.out.println("Error while creating file " + ioe.getMessage());
		}
		finally {
			workbook.close();
		}
	}

}
