package com.yao.util;

/**
 * util of String
 * @author yao
 *
 */
public class StringUtil {
	/**
	 * check if a String is null or empty
	 * @param arg the String
	 * @return true:is null or empty
	 */
	public static boolean isEmpty(String arg){
		return arg==null || "".equals(arg) || arg.trim().equals("");
	}
}