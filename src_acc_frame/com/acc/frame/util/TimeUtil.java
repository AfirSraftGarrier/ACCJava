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
package com.acc.frame.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeUtil {

	public enum AddDateType {
		YEAR, MONTH, DAY, HH, MM, SS
	}

	public static String getHHMMSSTimeStampFromSSIndex(int index) {
		DateFormat format = new SimpleDateFormat("hhmmss");
		String formatTime = format.format(getSSDate(index));
		return formatTime;
	}

	public static String getTimeStamp() {
		return getHHMMSSTimeStampFromSSIndex(0);
	}

	public static String getYYYYMMDDTimeStampFromDDIndex(int index) {
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		String formatTime = format.format(getDDDate(index));
		return formatTime;
	}

	public static Date getSSDate(int index) {
		Date date = getDate(new Date(), AddDateType.SS, index);
		return date;
	}

	public static Date getDDDate(int index) {
		Date date = getDate(new Date(), AddDateType.DAY, index);
		return date;
	}

	public static Date getDate(Date date, AddDateType dateType, int index) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (AddDateType.YEAR.equals(dateType)) {
			calendar.add(Calendar.YEAR, index);
			return calendar.getTime();
		}
		if (AddDateType.MONTH.equals(dateType)) {
			calendar.add(Calendar.MONTH, index);
			return calendar.getTime();
		}
		if (AddDateType.DAY.equals(dateType)) {
			calendar.add(Calendar.DAY_OF_MONTH, index);
			return calendar.getTime();
		}
		if (AddDateType.HH.equals(dateType)) {
			calendar.add(Calendar.HOUR_OF_DAY, index);
			return calendar.getTime();
		}
		if (AddDateType.MM.equals(dateType)) {
			calendar.add(Calendar.MINUTE, index);
			return calendar.getTime();
		}
		if (AddDateType.SS.equals(dateType)) {
			calendar.add(Calendar.SECOND, index);
			return calendar.getTime();
		}
		return date;
	}

	public static String getTimeYMDStr(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
		// return formatTime;
	}

	public static String getTimeYMD(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
		// return formatTime;
	}

	public static String getTimeYYMMDD(Date date) {
		return new SimpleDateFormat("yyyyMMdd").format(date);
		// return formatTime;
	}

	public static long getCurrentTimeMillis() {
		return Calendar.getInstance().getTimeInMillis();
	}

	public static Date getNewDate() {
		return new Date();
	}

	public static List<Date> getBetweenDates(Date fromDate, Date toDate
	// , int calendarType
	) {
		ArrayList<Date> resultDates = new ArrayList<Date>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fromDate);
		Date tmpDate = calendar.getTime();
		long endTime = toDate.getTime();
		while (tmpDate.before(toDate) || tmpDate.getTime() == endTime) {
			resultDates.add(calendar.getTime());
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			tmpDate = calendar.getTime();
		}
		Date[] dates = new Date[resultDates.size()];
		return resultDates;
	}
	// public static void main(String[] args) {
	// Date date = new Date("2008-04-01");
	// Date date2 = new Date("2008-08-01");
	// Date[] strArray = getDateArrays(date, date2, Calendar.DAY_OF_YEAR);
	// for (Date string : strArray) {
	// System.out.println(getTimeYMD(string));
	// }
	// }
}