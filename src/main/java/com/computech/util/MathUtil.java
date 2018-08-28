package com.computech.util;

public class MathUtil {

	/**
	 * 2整数向上取整
	 * @param arg1 被除数
	 * @param arg2 除数
	 * @return
	 */
	public static long ceil(long arg1,long arg2) {
		long result = arg1/arg2;
		if(arg1%arg2 != 0) {
			result++;
		}
		return result;
	}
}
