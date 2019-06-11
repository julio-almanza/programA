package test;
import common.Driver;
import common.FileName;
import common.PlainTextFiles;
import pageclasses.Google;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;


public class TestCases {
	
	public static void main(String args[]) throws IOException {
		String str_filename;
		
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		Properties p = new Properties();
		Google g = new Google();
		FileName f = new FileName();
		PlainTextFiles txt;
		FileReader fr = new FileReader("TestData/config.properties");
		
		p.load(fr);	
		
		
		Driver.openBrowser("Chrome");
		Driver.openWebSite("http://www.google.com.mx");		
		g.setSearchParameter("Selenium");		
		str_filename = f.createRandomName();
		hmap = g.getTitles();
		for(int i = 0 ; i < 5; i ++) {
			System.out.println("The key is " +  i + " The value is " + hmap.get(i));
		}
		System.out.println("filepath : " + p.getProperty("filepath"));
		txt = new PlainTextFiles(p.getProperty("filepath") + str_filename + ".txt");
		txt.write(hmap.toString());
		
		Driver.close();
		
	}
}
