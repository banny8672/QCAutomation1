package com.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

public class TagStripperText 
{

//	private static final Pattern pattern = Pattern.compile("Title\\>(.+?)\\</Title");
//	private static final Pattern TAG_REGEX_TITLE = Pattern.compile("<Title>(.+?)</Title>");
//	private static final Pattern TAG_REGEX_GOAL = Pattern.compile("<Goal>(.+?)</Goal>");
//	private static final Pattern TAG_REGEX_PURPOSE = Pattern.compile("<Purpose>(.+?)</Purpose>");
//	private static final Pattern TAG_REGEX_PRE_REQ = Pattern.compile("<Pre-Requisite>(.+?)</Pre-Requisite>");
	
	public static void main(String[] args) throws IOException 
	{
		final String str =  new String(Files.readAllBytes(Paths.get("D:\\A360\\ASHA\\CO123_107002_HLR_TC001\\FCO123_107002_HLR_TC001_1.ctl")));
	   // final String str = FileUtils.readFileToString(new File("D:\\A360\\ASHA\\CO123_107002_HLR_TC001\\FCO123_107002_HLR_TC001_1.ctl"));
	    
	    //System.out.println(str);
	    
	    String title = StringUtils.substringBetween(str, "<Title>", "</Title>");
	    String goal = StringUtils.substringBetween(str, "<Goal>", "</Goal>");
	    String purpose = StringUtils.substringBetween(str, "<Purpose>", "</Purpose>");
	    String perReq = StringUtils.substringBetween(str, "<Pre-Requisite>", "</Pre-Requisite>");
	    
	    System.out.println(title);
	    System.out.println();
	    System.out.println(goal);
	    System.out.println();
	    System.out.println(purpose);
	    System.out.println();
	    System.out.println(perReq);
	    
//	    final Matcher matcher1 = pattern.matcher(str);
//	    while (matcher1.find()) {	        
//	    	System.out.println("Match found");
//	        System.out.println(matcher1.group(0));
//	        System.out.println(matcher1.toString());
//	    }
//	    
//	    System.out.println();
//	    
//	    final Matcher matcher2 = TAG_REGEX_GOAL.matcher(str);
//	    while (matcher2.find()) {	        
//	        System.out.println(matcher2.group(0));
//	    }
//	    
//	    System.out.println();
	    
	}	
}
