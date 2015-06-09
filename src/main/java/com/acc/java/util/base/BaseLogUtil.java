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
package com.acc.java.util.base;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.acc.java.manager.base.BaseJsonManager;
import com.acc.java.util.constant.AppLibConstant;
import com.acc.java.util.constant.HttpConstant;
import com.acc.java.util.constant.LogConstant;

public abstract class BaseLogUtil {
	private static String getStringFromObject(Object object,
			BaseJsonManager baseJsonManager) {
		String resultString;
		if (object instanceof String) {
			resultString = (String) object;
		} else {
			try {
				resultString = baseJsonManager.getJson(object);
			} catch (Exception e) {
				e.printStackTrace();
				resultString = "该类不符合规范，尝试传字符串类型";
			}
		}
		return resultString;
	}

	private static String getLogFromString(int adjustIndex) {
		adjustIndex += 7;
		return LogConstant.FROM
				+ Thread.currentThread().getStackTrace()[adjustIndex]
						.getClassName()
				+ HttpConstant.URLDOT
				+ Thread.currentThread().getStackTrace()[adjustIndex]
						.getMethodName();
	}

	protected static String getLogString(Object prefixObject,
			Object informationObject, BaseJsonManager baseJsonManager,
			int adjustIndex) {
		String informationString = getStringFromObject(informationObject,
				baseJsonManager);
		if (prefixObject != null) {
			return getStringFromObject(prefixObject, baseJsonManager)
					+ LogConstant.PRIFIX + informationString
					+ getLogFromString(adjustIndex);
		}
		return informationString + getLogFromString(adjustIndex);
	}

	protected static String getLogString(Object prefixObject,
			Object informationObject, BaseJsonManager baseJsonManager) {
		String informationString = getStringFromObject(informationObject,
				baseJsonManager);
		if (prefixObject != null) {
			return getStringFromObject(prefixObject, baseJsonManager)
					+ LogConstant.PRIFIX + informationString
					+ getLogFromString(0);
		}
		return informationString + getLogFromString(0);
	}

	protected static String getTagString(Object tagObject,
			BaseJsonManager baseJsonManager) {
		if (tagObject == null) {
			return Thread.currentThread().getStackTrace()[5].getClassName();
		} else if (tagObject instanceof String) {
			return (String) tagObject;
		} else {
			return tagObject.getClass().getName();
		}
	}

	protected static void systemOut(String string) {
		System.out.println(string);
	}

	protected static void fileOut(String informationString) {
		File file = new File(AppLibConstant.getLogFilePath());
		if (!file.exists()) {
			try {
				new File(file.getParent()).mkdirs();
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		OutputStreamWriter outputStreamWriter = null;
		try {
			outputStreamWriter = new OutputStreamWriter(new DataOutputStream(
					new FileOutputStream(file, true)), "UTF-8");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss  ");
			String time = sdf.format(new Date());
			outputStreamWriter.write(time);
			outputStreamWriter.write(informationString + "\r\n");
			outputStreamWriter.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outputStreamWriter != null) {
				try {
					outputStreamWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				outputStreamWriter = null;
			}
		}
	}

	// private static String getLogString(Object informationObject,
	// BaseJsonManager baseJsonManager, int adjustIndex) {
	// return getStringFromObject(informationObject, baseJsonManager)
	// + getLogFromString(adjustIndex);
	// }
	//
	// private static String getLogString(Object informationObject,
	// BaseJsonManager baseJsonManager) {
	// return getStringFromObject(informationObject, baseJsonManager)
	// + getLogFromString(0);
	// }

	// protected static void systemOut(Object prefixObject,
	// Object informationObject, BaseJsonManager baseJsonManager,
	// int adjustIndex) {
	// systemOut(getLogString(prefixObject, informationObject,
	// baseJsonManager, adjustIndex));
	// }

	// protected static void fileOut(Object prefixObject,
	// Object informationObject, BaseJsonManager baseJsonManager,
	// int adjustIndex) {
	// fileOut(getLogString(prefixObject, informationObject, baseJsonManager,
	// adjustIndex));
	// }

	// protected static void systemOut(Object informationObject,
	// BaseJsonManager baseJsonManager, int adjustIndex) {
	// // if (!this.isUseLog()) {
	// // return;
	// // }
	// systemOut(getLogString(informationObject, baseJsonManager, adjustIndex));
	// }

	// protected static void systemOut(Object tagObject, Object
	// informationObject,
	// BaseJsonManager baseJsonManager, int adjustIndex) {
	// // if (!this.isUseLog()) {
	// // return;
	// // }
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// // String informationString = getStringFromObject(informationObject);
	// // if (informationObject instanceof String) {
	// // System.out.println(getLogString(informationObject));
	// // ;
	// // } else {
	// // System.out.println(("" + informationObject.getClass()) + "--"
	// // + informationString);
	// // Log.d("" + tagObject.getClass(), informationString);
	// // }
	// systemOut(getLogString(tagObject, informationObject, baseJsonManager,
	// adjustIndex));
	// }

	// public static void systemOut(Object tagObject, Object informationObject)
	// {
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// String informationString = getStringFromObject(informationObject);
	// if (tagObject instanceof String) {
	// System.out.println(((String) tagObject) + "--" + informationString);
	// // ;
	// } else {
	// System.out.println(("" + tagObject.getClass()) + "--"
	// + informationString);
	// // Log.d("" + tagObject.getClass(), informationString);
	// }
	// }

	// public static void systemOut(Object tagObject,
	// String informationPrefixString, Object informationObject) {
	// // if (!HttpConstant.LOG) {
	// // return;
	// // }
	// String informationString = getStringFromObject(informationObject);
	// if (tagObject instanceof String) {
	// System.out.println(((String) tagObject) + "--"
	// + informationPrefixString + ":" + informationString);
	// // ;
	// } else {
	// System.out.println(("" + tagObject.getClass()) + "--"
	// + informationPrefixString + ":" + informationString);
	// // Log.d("" + tagObject.getClass(), informationString);
	// }
	// }

	// public void fileOut(
	// // Object prefixObject,
	// // , String informationPrefixString,
	// Object informationObject, BaseJsonManager baseJsonManager) {
	// // if (!this.isUseLog()) {
	// // return;
	// // }
	// fileOut(getLogString(tagObject, informationPrefixString,
	// informationObject, baseJsonManager));
	// // String informationString = getStringFromObject(informationObject);
	// // if (tagObject instanceof String) {
	// // fileOut(((String) tagObject) + "--" + informationPrefixString + ":"
	// // + informationString);
	// // // ;
	// // } else {
	// // fileOut(("" + tagObject.getClass()) + "--"
	// // + informationPrefixString + ":" + informationString);
	// // // Log.d("" + tagObject.getClass(), informationString);
	// // }
	// }

	// protected static String getLogString(Object tagObject,
	// Object informationObject, BaseJsonManager baseJsonManager) {
	// // if (!this.isUseLog()) {
	// // return null;
	// // }
	// String informationString = getStringFromObject(informationObject,
	// baseJsonManager);
	// if (tagObject instanceof String) {
	// return tagObject + LogConstant.DIVIDER + informationString
	// + getLogFromString();
	// // ;
	// } else {
	// return tagObject.getClass() + LogConstant.DIVIDER
	// + informationString + getLogFromString();
	// // Log.d("" + tagObject.getClass(), informationString);
	// }
	// // return getStringFromObject(informationObject);
	// }

	// protected static String getLogString(Object prefixObject,
	// Object informationObject, BaseJsonManager baseJsonManager) {
	// String informationString = getStringFromObject(informationObject,
	// baseJsonManager);
	// if (prefixObject != null) {
	// return getStringFromObject(prefixObject, baseJsonManager)
	// + LogConstant.PRIFIX + informationString
	// + getLogFromString(0);
	// }
	// return informationString + getLogFromString(0);
	// }

	// protected BaseJsonManager baseJsonManager;
	//
	// public BaseLogManager(BaseJsonManager baseJsonManager) {
	// this.baseJsonManager = baseJsonManager;
	// }

	// private static String getStringFromObject(JsonManager jsonManager,
	// Object object) {
	// String resultString;
	// if (object instanceof String) {
	// resultString = (String) object;
	// } else {
	// try {
	// resultString = jsonManager.getJson(object);
	// } catch (Exception e) {
	// resultString = "该类不符合规范，尝试传字符串类型";
	// }
	// }
	// return resultString;
	// }

	// public abstract boolean isUseLog();

	// public abstract void initBaseJsonManager();

	// if (!this.isUseLog()) {
	// return null;
	// }
}