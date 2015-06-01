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

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

public class ACCFileUtil {

	public enum FileSizeType {
		B, KB, MB, GB
	}

	public static double getFileSize(String filePath, FileSizeType fileSizeType) {
		File file = new File(filePath);
		long blockSize = 0;
		try {
			blockSize = getFileSize(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formatFileSize(blockSize, fileSizeType);
	}

	public static String getFileSizeString(String filePath,
			FileSizeType fileSizeType) {
		return getFileSize(filePath, fileSizeType)
				+ getFileSizeString(fileSizeType);
	}

	public static String getAutoFileSizeString(String filePath) {
		File file = new File(filePath);
		long blockSize = 0;
		try {
			blockSize = getFileSize(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formetFileSize(blockSize);
	}

	private static long getFileSize(File file) throws Exception {
		long size = 0;
		if (file.isDirectory()) {
			File flist[] = file.listFiles();
			for (int i = 0; i < flist.length; i++) {
				size += getFileSize(file);
			}
		} else {
			if (file.exists()) {
				FileInputStream fileInputStream = null;
				try {
					fileInputStream = new FileInputStream(file);
					size += new FileInputStream(file).available();
				} catch (Exception exception) {
					exception.printStackTrace();
				} finally {
					if (fileInputStream != null) {
						StreamUtil.closeStream(fileInputStream);
					}
				}
			}
		}
		return size;
	}

	// private static long getDirFileSize(File file) throws Exception {
	// long size = 0;
	// File flist[] = file.listFiles();
	// for (int i = 0; i < flist.length; i++) {
	// if (flist[i].isDirectory()) {
	// size = size + getDirFileSize(flist[i]);
	// } else {
	// size = size + getFileSize(flist[i]);
	// }
	// }
	// return size;
	// }

	private static String formetFileSize(long fileSize) {
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		String fileSizeString = "";
		String wrongSize = "0B";
		if (fileSize == 0) {
			return wrongSize;
		}
		if (fileSize < 1024) {
			fileSizeString = decimalFormat.format((double) fileSize) + "B";
		} else if (fileSize < 1048576) {
			fileSizeString = decimalFormat.format((double) fileSize / 1024)
					+ "KB";
		} else if (fileSize < 1073741824) {
			fileSizeString = decimalFormat.format((double) fileSize / 1048576)
					+ "MB";
		} else {
			fileSizeString = decimalFormat
					.format((double) fileSize / 1073741824) + "GB";
		}
		return fileSizeString;
	}

	private static String getFileSizeString(FileSizeType fileSizeType) {
		switch (fileSizeType) {
		case B:
			return "B";
		case KB:
			return "KB";
		case MB:
			return "MB";
		case GB:
			return "GB";
		default:
			return "";
		}
	}

	private static double formatFileSize(long fileSize,
			FileSizeType fileSizeType) {
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		double fileSizeLong = 0;
		switch (fileSizeType) {
		case B:
			fileSizeLong = Double.valueOf(decimalFormat
					.format((double) fileSize));
			break;
		case KB:
			fileSizeLong = Double.valueOf(decimalFormat
					.format((double) fileSize / 1024));
			break;
		case MB:
			fileSizeLong = Double.valueOf(decimalFormat
					.format((double) fileSize / 1048576));
			break;
		case GB:
			fileSizeLong = Double.valueOf(decimalFormat
					.format((double) fileSize / 1073741824));
			break;
		default:
			break;
		}
		return fileSizeLong;
	}

	// private static boolean makeSureFileDirExist(File file) {
	// try {
	// File parentFile = new File(file.getParent());
	// if (!parentFile.exists()) {
	// parentFile.mkdirs()
	// } else {
	// System.out.println("文件夹不存在！");
	// File file2 = new File(file.getParent());
	// file2.mkdirs();
	// System.out.println("创建文件夹成功！");
	// if (file.isDirectory()) {
	// System.out.println("文件存在！");
	// } else {
	// file.createNewFile();// 创建文件
	// System.out.println("文件不存在，创建文件成功！");
	// }
	// }
	// return true;
	// } catch (Exception exception) {
	// exception.printStackTrace();
	// }
	// return false;
	// }
}