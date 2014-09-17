package com.acc.frame.util;

public class ExceptionUtil {
	public static IllegalArgumentException getIllegalArgumentException(
			String exceptionString) {
		return new IllegalArgumentException(exceptionString);
	}
}
