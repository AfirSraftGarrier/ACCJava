/**
 * 
 * ACCFrame - ACC Java Development Platform
 * Copyright (c) 2014, AfirSraftGarrier, afirsraftgarrier@qq.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package com.acc.java.util;

public class StringUtil {
	public static boolean isEmpty(String string) {
		return string == null || "".equals(string.trim());
	}

	// public static String getNotNullString(String string, String
	// defaultString) {
	// return string == null ? defaultString : string;
	// }

	public static String getNotNullString(Object stringObject,
			String defaultString) {
		return stringObject == null ? defaultString : stringObject.toString();
	}

	// public static String replaceNullString(String string) {
	//
	// return string.replace("null", "");
	// }
	public static boolean isTwoStringEqual(String firstString,
			String secondString) {
		if (firstString == null) {
			if (secondString == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return firstString.equals(secondString);
		}
	}

	public static Long getLong(String string) {
		return getLong(string, null);
	}

	public static Long getLong(String string, Long defaultValue) {
		if (string == null || "".equals(string.trim()))
			return defaultValue;
		try {
			return Long.parseLong(string.trim());
		} catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}

	public static Float getFloat(String string) {
		return getFloat(string, null);
	}

	public static Float getFloat(String string, Float defaultValue) {
		if (string == null || "".equals(string.trim()))
			return defaultValue;
		try {
			return Float.parseFloat(string.trim());
		} catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}

	public static Double getDouble(String string) {
		return getDouble(string, null);
	}

	public static Double getDouble(String string, Double defaultValue) {
		if (string == null || "".equals(string.trim()))
			return defaultValue;
		try {
			return Double.parseDouble(string.trim());
		} catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}

	public static String getString(String... strings) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String string : strings) {
			stringBuilder.append(string);
		}
		return stringBuilder.toString();
	}

	public static StringBuilder getStringBuilder(String... strings) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String string : strings) {
			stringBuilder.append(string);
		}
		return stringBuilder;
	}
}