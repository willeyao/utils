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
	/** 数字模版 */
    	private static final Pattern NUMBER_PATTERN = Pattern.compile("^[-\\+]?[\\d]+[.]?[\\d]*$");

    	/**
     	  * 判断字符串是不是数字
     	  * @param str
     	  * @return
     	  */
    	public static final boolean isNumeric(String str){
        	if(isEmpty(str)){
            		return false;
        	}
        	return NUMBER_PATTERN.matcher(str).matches();
    	}

	    /** 中文模版 */
	    private static final Pattern CHINESE_PATTERN = Pattern.compile("^[\\u4E00-\\u9FA5]+$");

	    /**
	     * 判断字符串是不是只包含中文
	     * @param str
	     * @return
	     */
	    public static final boolean isChinese(String str){
		return matchStr(CHINESE_PATTERN, str);
	    }

	    /** 英文模版 */
	    private static final Pattern ENGLISH_PATTERN = Pattern.compile("[a-zA-Z]+");

	    /**
	     * 判断字符串是不是英文
	     * @param str
	     * @return
	     */
	    public static final boolean isEnglish(String str){
		return matchStr(ENGLISH_PATTERN, str);
	    }

	    /** 只含中英文和数字 */
	    private static final Pattern NO_SPECIAL_CHAR_PATTERN = Pattern.compile("^[a-zA-Z0-9\\u4E00-\\u9FA5]+$");

	    /**
	     * 判断字符串是否不包含特殊字符，即只含中英文和数字
	     * @param str
	     * @return
	     */
	    public static final boolean isNoSpecialChar(String str) {
		return matchStr(NO_SPECIAL_CHAR_PATTERN, str);
	    }

}
