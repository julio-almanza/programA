package common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileName {

	private String str_base;
	private static final DateFormat sdf = new SimpleDateFormat("yy-MM-dd HHmmss");
	
	public FileName() {
		this.str_base  = "log_";
	}
	
	public String createRandomName() {
		String str_random;
		Date date = new Date();
		//str_random = sdf.format(date).replace(":", "");
		str_random = str_base + sdf.format(date);		
		return str_random;
	}
	
}
