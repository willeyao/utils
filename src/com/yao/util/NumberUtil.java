package com.yao.util;

import java.util.Random;

public class NumberUtil {
	public static final Random RND = new Random();

	/**
	 *
	 * @param num
	 * @return
	 */
	public static int random(int num){
		return RND.nextInt(num);
	}
	
	public static void main(String[] args){
		System.out.println(random(100));
	}
	
     /**
       * 经纬度小数点要保留的长度
       */
       public final static Integer LNGLAT_PRECISION = 6;

       public static String toString(Integer num){
          return num == null ? null : num.toString();
       }

       public static Double keepLngLatDecimal(Double num){
          return keepDecimal(num, LNGLAT_PRECISION);
       }
       public static Double keepDecimal(Double num, Integer precision){
          if (num == null) {
              return null;
          }
          BigDecimal b = new BigDecimal(num);
          num = b.setScale(precision, BigDecimal.ROUND_HALF_UP).doubleValue();
          return num;
      }
}
