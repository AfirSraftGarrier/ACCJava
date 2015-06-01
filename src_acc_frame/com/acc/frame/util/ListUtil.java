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

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
	public static boolean isEmpty(List list) {
		return list == null || list.size() == 0;
	}

	public static <T> ArrayList<T> getArrayList() {
		return new ArrayList<T>();
	}

	// public static <T> List<T> getArrayList(T t) {
	// List<T> ts = new ArrayList<T>();
	// if (t != null) {
	// ts.add(t);
	// }
	// return ts;
	// }

	public static <T> List<T> makeSureInit(List<T> ts) {
		if (ts == null) {
			ts = new ArrayList<T>();
		}
		return ts;
	}

	public static <T> List<T> getList(T... ts) {
		List<T> resultTs = new ArrayList<T>();
		if (!isEmpty(ts)) {
			for (T t : ts) {
				resultTs.add(t);
			}
		}
		return resultTs;
	}

	public static <T> boolean isEmpty(T... ts) {
		if (ts == null || ts.length == 0) {
			return true;
		}
		return false;
	}

	// public static boolean containString(List<String> strings, String string)
	// {
	// if (ListUtil.isEmpty(strings) || string == null) {
	// return false;
	// }
	// for (String tempString : strings) {
	// if (string.equals(tempString)) {
	// return true;
	// }
	// }
	// return false;
	// }

	public static <T> boolean isContainString(List<T> stringObjects,
			Object stringObject) {
		if (ListUtil.isEmpty(stringObjects) || stringObject == null) {
			return false;
		}
		for (T tempStringObject : stringObjects) {
			if (stringObject.toString().equals(tempStringObject.toString())) {
				return true;
			}
		}
		return false;
	}

	public static <T> void addAll(List<T> resultTs, List<T> toAddTs) {
		if (resultTs != null && !ListUtil.isEmpty(toAddTs)) {
			resultTs.addAll(toAddTs);
		}
	}
}