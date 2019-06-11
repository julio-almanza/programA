package pageclasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.apache.commons.*;

import common.Driver;


public class Google {
	
	private WebElement element;
	By txt_search = By.name("q");
	By hlnks_list = By.tagName("a");
	static String str_attribute = "href";
	String str_tmp = null;
	
	
	//Set selenium in search text box
	public void setSearchParameter(String str_SearchParameter) {
		element = Driver.findElement(txt_search);
		element.sendKeys(str_SearchParameter);
		element.submit();	
	}
	
	public HashMap<Integer, String> getTitles() {
		HashMap<Integer, String> hmaplinks = new HashMap<Integer, String>();
		List<WebElement> lst_webelements = Driver.findElements(hlnks_list);		
		
		lst_webelements.removeIf(element -> element.getAttribute("class").length() > 0);
		
		for(WebElement e : lst_webelements) {
			if(e.getAttribute("class").length() < 1) {
				System.out.println("CLASS " + e.getAttribute("class"));	
				System.out.println("HREF " + e.getAttribute(str_attribute));
					System.out.println("-------------------------------------------");	
			}				
		}
		
		ArrayList<String> lst_links = new ArrayList<String>();	
		
		lst_links = clean(lst_webelements);
		
		for(int i = 0; i < lst_links.size(); i ++) {
			System.out.println("LINK: " + lst_links.get(i));
		}
		
		for(int i = 0; i < 5; i++) {
				
			Driver.openWebSite(lst_links.get(i));			
			hmaplinks.put(i, Driver.getNameTitle());
			Driver.getBack();				
		}		
		return hmaplinks;
	}
	
	private static ArrayList<String> clean(List<WebElement> lst_webelements){
		ArrayList<String> lst_links = new ArrayList<String>();
		
		
		for(int i =0; i < lst_webelements.size(); i ++) {
			if(lst_webelements.get(i).getAttribute(str_attribute) != null || lst_webelements.get(i).getAttribute(str_attribute) != "") {
				lst_links.add(lst_webelements.get(i).getAttribute(str_attribute));
			}
		}
		
		lst_links.removeAll(Collections.singleton(null));
		
		lst_links.removeIf(s -> s.contains("google"));
		
		lst_links.removeIf(s -> s.contains("youtube"));
		
		return lst_links;
	}
	
	
}
