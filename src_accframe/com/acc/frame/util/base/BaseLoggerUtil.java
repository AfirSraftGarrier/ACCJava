package com.acc.frame.util.base;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.acc.frame.manager.base.BaseJsonManager;
import com.acc.frame.util.constant.AppLibConstant;
import com.acc.frame.util.constant.HttpConstant;
import com.acc.frame.util.constant.LogConstant;

public class BaseLoggerUtil {
	protected static BaseJsonManager baseJsonManager;

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

	private static String getStringFromObject(Object object) {
		String resultString;
		if (object instanceof String) {
			resultString = (String) object;
		} else {
			try {
				resultString = baseJsonManager.getJson(object);
			} catch (Exception e) {
				resultString = "该类不符合规范，尝试传字符串类型";
			}
		}
		return resultString;
	}

	protected static String getLogFromString() {
		return LogConstant.FROM
				+ Thread.currentThread().getStackTrace()[4].getClassName()
				+ HttpConstant.URLDOT
				+ Thread.currentThread().getStackTrace()[4].getMethodName();
	}

	public static String getLogString(Object informationObject) {
		return getStringFromObject(informationObject) + getLogFromString();
	}

	public static String getLogString(Object tagObject, Object informationObject) {
		String informationString = getStringFromObject(informationObject);
		if (tagObject instanceof String) {
			return tagObject + LogConstant.DIVIDER + informationString
					+ getLogFromString();
			// ;
		} else {
			return tagObject.getClass() + LogConstant.DIVIDER
					+ informationString + getLogFromString();
			// Log.d("" + tagObject.getClass(), informationString);
		}
		// return getStringFromObject(informationObject);
	}

	public static String getLogString(Object tagObject,
			String informationPrefixString, Object informationObject) {
		String informationString = getStringFromObject(informationObject);
		if (tagObject instanceof String) {
			return tagObject + LogConstant.DIVIDER + informationPrefixString
					+ LogConstant.PRIFIX + informationString
					+ getLogFromString();
			// ;
		} else {
			return tagObject.getClass() + LogConstant.DIVIDER
					+ informationPrefixString + LogConstant.PRIFIX
					+ informationString + getLogFromString();
			// Log.d("" + tagObject.getClass(), informationString);
		}
		// return getStringFromObject(informationObject);
	}

	public static void systemOut(Object informationObject) {
		if (!AppLibConstant.isUseLog()) {
			return;
		}
		systemOut(getLogString(informationObject));
	}

	public static void systemOut(Object tagObject, Object informationObject) {
		if (!AppLibConstant.isUseLog()) {
			return;
		}
		// if (!HttpConstant.LOG) {
		// return;
		// }
		// String informationString = getStringFromObject(informationObject);
		// if (informationObject instanceof String) {
		// System.out.println(getLogString(informationObject));
		// ;
		// } else {
		// System.out.println(("" + informationObject.getClass()) + "--"
		// + informationString);
		// Log.d("" + tagObject.getClass(), informationString);
		// }
		systemOut(getLogString(tagObject, informationObject));
	}

	public static void systemOut(Object tagObject,
			String informationPrefixString, Object informationObject) {
		if (!AppLibConstant.isUseLog()) {
			return;
		}
		systemOut(getLogString(tagObject, informationPrefixString,
				informationObject));
	}

	private static void systemOut(String stringInfo) {
		System.out.println(stringInfo);
	}

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

	public static void fileOut(Object informationObject) {
		if (!AppLibConstant.isUseLog()) {
			return;
		}
		fileOut(getLogString(informationObject));
	}

	public static void fileOut(Object tagObject, Object informationObject) {
		if (!AppLibConstant.isUseLog()) {
			return;
		}
		fileOut(getLogString(tagObject, informationObject));
	}

	public static void fileOut(Object tagObject,
			String informationPrefixString, Object informationObject) {
		if (!AppLibConstant.isUseLog()) {
			return;
		}
		fileOut(getLogString(tagObject, informationPrefixString,
				informationObject));
		// String informationString = getStringFromObject(informationObject);
		// if (tagObject instanceof String) {
		// fileOut(((String) tagObject) + "--" + informationPrefixString + ":"
		// + informationString);
		// // ;
		// } else {
		// fileOut(("" + tagObject.getClass()) + "--"
		// + informationPrefixString + ":" + informationString);
		// // Log.d("" + tagObject.getClass(), informationString);
		// }
	}

	private static void fileOut(String informationString) {
		// String informationString = getStringFromObject(informationObject);
		File file = new File(AppLibConstant.getLogFilePath());
		if (file.exists() == false) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(file, true));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss  ");
			String time = sdf.format(new Date());
			dos.writeUTF(time);
			dos.writeUTF(informationString + "\r\n");
			dos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				dos = null;
			}
		}
	}
}
