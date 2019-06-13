package test;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import common.Driver;
import common.Excel;
import pageobjectclasses.Google;

public class Testcase {

	public static void main(String args[]) throws IOException {
		
		String str_filepath;
		HashMap<Integer, String> hmap_00 = new HashMap<Integer, String>(), hmap_01 = new HashMap<Integer, String>();
		Properties p = new Properties();
		Google g = new Google();
		FileReader fr = new FileReader("TestData/config.properties");
		Excel xl = null;
		p.load(fr);	
		
		
		Driver.openBrowser("Chrome");
		Driver.openWebSite("http://www.google.com.mx");		
		g.setSearchParameter("Selenium");		
		hmap_00 = g.getTitles();		
		System.out.println("filepath : " + p.getProperty("filepath"));
		str_filepath = p.getProperty("filepath");
		xl = new Excel(str_filepath, "Sheet1");
		for(int i = 0 ; i < 5; i ++) {

			System.out.println("The key is " +  i + " The value is " + hmap_00.get(i));
			xl.addValue(hmap_00.get(i));
		}
		
		
		Driver.openWebSite("http://www.google.com");
		g.setSearchParameter("Selenium");
		hmap_01 = g.getTitles();	
		xl.setInt_currentrow(0);
		xl.setInt_currentcolumn(1);
		for(int i = 0 ; i < 5; i ++) {

			System.out.println("The key is " +  i + " The value is " + hmap_01.get(i));
			xl.addValue(hmap_01.get(i));
		}
		
		xl.setInt_currentrow(0);
		xl.setInt_currentcolumn(2);
		for(int i = 0; i < 5; i ++) {
			if(hmap_00.get(i).equals(hmap_01.get(i))) {
				xl.addValue("Equals");
			}
			else {
				xl.addValue("Not Equals");
			}
		}
		
		xl.saveWorkbook();			
		Driver.close();
		
	}

}
