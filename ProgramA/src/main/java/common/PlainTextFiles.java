package common;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;


public class PlainTextFiles {
	private String str_filepath;
	
	public PlainTextFiles(String str_filepath) {
		this.str_filepath = str_filepath;
		File tmpdir = new File(str_filepath);
		if(!tmpdir.exists()) {
			try {
				tmpdir.createNewFile();
			}catch(IOException ioe) {
				System.out.println("Error while creating file" + ioe.getMessage());
			}			
		}
		
	}
	
	public String getStr_filepath() {
		return str_filepath;
	}

	public void setStr_filepath(String str_filepath) {
		this.str_filepath = str_filepath;
	}

	public void write(String str_text) {
		try {
			FileWriter fw = new FileWriter(str_filepath);
			fw.write(str_text);
			fw.close();			
		}catch(IOException ioe) {
			System.out.println("Error E/S" + ioe.getMessage());
		}		
	}
	
	

}
