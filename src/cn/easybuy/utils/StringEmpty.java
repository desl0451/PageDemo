package cn.easybuy.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringEmpty {
	public static boolean isNum(String str) {
		Pattern pattern = Pattern.compile("[1-9]{1}\\d*");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
}
