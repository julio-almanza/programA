package common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileName {

	private String str_base;
	private static final DateFormat sdf_00 = new SimpleDateFormat("yy-MM-dd HHmmss");
	private static final DateFormat sdf_01 = new SimpleDateFormat("yy-MM-dd");
	private static final String str_pattern ="([a-zA-Z]:)?(\\\\\\\\[a-zA-Z0-9_.-]+)+\\\\\\\\?";
	
	public FileName() {
		this.str_base  = "log_";
	}
	
	public String createRandomName() {
		String str_random;
		Date date = new Date();
		//str_random = sdf.format(date).replace(":", "");
		str_random = str_base + sdf_00.format(date);		
		return str_random;
	}
	
	public String createRandomName(String str_extensionfile) {
		String str_random;
		Date date = new Date();
		//str_random = sdf.format(date).replace(":", "");
		if(str_extensionfile.contains(".")) {
			str_random = str_base + sdf_01.format(date)  + str_extensionfile ;		
			return str_random;
		}
		else{
			str_random = str_base + sdf_01.format(date) + "." + str_extensionfile ;		
			return str_random;
		}		
	}	
}
