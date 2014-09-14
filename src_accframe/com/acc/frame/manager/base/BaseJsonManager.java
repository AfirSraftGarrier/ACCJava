package com.acc.frame.manager.base;

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
