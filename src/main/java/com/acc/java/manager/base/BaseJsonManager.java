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
package com.acc.java.manager.base;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public abstract class BaseJsonManager {
	private final Gson gson;

	public BaseJsonManager() {
		this.gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
	}

	public String getJson(Object object) {
		return this.gson.toJson(object);
	}

	public <T> T getObject(String jsonString, Class<T> classT) {
		T returnObject = null;
		try {
			returnObject = this.gson.fromJson(jsonString, classT);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
		return returnObject;
	}

	public <T> T getObject(String jsonString, Type type) {
		T returnObject = null;
		try {
			returnObject = this.gson.fromJson(jsonString, type);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
		return returnObject;
	}
}