package com.yao.util;

import java.util.Random;

public class NumberUtil {
	public static final Random RND = new Random();
	public static int random(int num){
		return RND.nextInt(num);
	}
	
	public static void main(String[] args){
		System.out.println(random(100));
	}
}
