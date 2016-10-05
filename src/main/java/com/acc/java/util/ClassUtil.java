package com.acc.java.util;

import java.util.List;

public class ClassUtil {

	public static Class getClass(Object object) {
		if (object == null) {
			return null;
		}
		if (object instanceof List) {
			List objects = (List) object;
			if (ListUtil.isEmpty(objects)) {
				return null;
			}
			return objects.get(0).getClass();
		} else {
			return object.getClass();
		}
	}
}
