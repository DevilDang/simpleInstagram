package simpleInstagram;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class extracthashtag {
	
	@Test
	public void gethashtag(){
		String str="#important thing in #any programming #7#& ";
		System.out.println(str.replace("#important", "a"));
		Pattern MY_PATTERN = Pattern.compile("#(\\S+)");
		Matcher matcher = MY_PATTERN.matcher(str);
		
		while (matcher.find()) {
		  String tag = matcher.group(0);
		  String tag1 = matcher.group(1);
		  System.out.println(tag);
		  System.out.println(tag1);
		  str = str.replace(tag, "<a hrf=\"linktosomehting\">"+tag1+"</a>");
		  
		}
		
		System.out.println(str);
	}

}
