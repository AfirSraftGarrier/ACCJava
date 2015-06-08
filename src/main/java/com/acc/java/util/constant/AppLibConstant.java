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
package com.acc.java.util.constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppLibConstant {
	public static Boolean LOG_USE;
	public static String LOG_FILE;
	// public static Boolean INITED;

	static {
		init(AppLibConstant.class);
	}

	public static boolean isUseLog() {
		return LOG_USE != null ? LOG_USE : false;
	}

	public static String getLogFilePath() {
		return LOG_FILE != null ? LOG_FILE : "/sdcard/acc_log.txt";
	}

	public static void init(Class classType) {
		// if (INITED != null) {
		// return;
		// }
		try {
			InputStream inputStream = classType.getClassLoader()
					.getResourceAsStream("app.properties");
			if (inputStream == null) {
				return;
			}
			Properties properties = new Properties();
			properties.load(inputStream);
			LOG_USE = new Boolean(properties.getProperty("log_use"));
			LOG_FILE = properties.getProperty("log_file");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// INITED = true;
	}
}