package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagStripper2 {

	
	public static void main(String[] args) {
	    final String str = "asdjkzxhvzxhljvlxck "+" \n "+" <tag>apple</tag>" +"\n"+ " fdghdhdh fuig <tag>orange "+ "\n " + "</tag>";
	    System.out.println(Arrays.toString(getTagValues(str).toArray())); // Prints [apple, orange, pear]
	}

	//private static final Pattern TAG_REGEX = Pattern.compile("<tag>(.+?)</tag>");
	private static final Pattern TAG_REGEX = Pattern.compile("<([a-zA-Z]+).*?>(.*?)</\\1>");
	
	private static List<String> getTagValues(final String str) {
	    final List<String> tagValues = new ArrayList<String>();
	    final Matcher matcher = TAG_REGEX.matcher(str);
	    while (matcher.find()) {
	        tagValues.add(matcher.group(1));
	    }
	    return tagValues;
	}
	
}
