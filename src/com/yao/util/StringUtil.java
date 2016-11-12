package com.yao.util;

/**
 * Util of String
 */
public class StringUtil {
	/**
	 * Check if String is null or empty
	 * @param str the String
	 * @return true:is empty
	 */
	public static boolean isEmpty(String str){
		return str==null || str.trim().equals("");
	}

	/**
	 * Check if String is not null or empty
	 * @param str
	 * @return true:is not empty
	 */
	public static boolean isNotEmpty(String str){
		return str != null && !str.trim().equals("");
	}
}