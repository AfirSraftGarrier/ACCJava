/**
 * 
 * ACCJava - ACC Java Development Platform
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

public class MD5Util {
	public static String getMD5(String sourceString) {
		try {
			java.security.MessageDigest messageDigest = java.security.MessageDigest
					.getInstance("MD5");
			byte[] byts = messageDigest.digest(sourceString.getBytes());
			String result = "";
			for (int i = 0; i < byts.length; i++) {
				String temp = Integer.toHexString(byts[i] & 0XFf);
				if (temp.length() == 1) {
					result += "0" + temp;
				} else {
					result += temp;
				}
			}
			return result;
		} catch (Exception e) {
			return "";
		}
	}
}