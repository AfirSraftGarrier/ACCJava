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

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamUtil {
	// public static void copy(InputStream in, OutputStream out)
	// throws IOException {
	// byte[] b = new byte[IO_BUFFER_SIZE];
	// int read;
	// while ((read = in.read(b)) != -1) {
	// out.write(b, 0, read);
	// }
	// }

	public static void closeStream(Closeable stream) {
		if (stream != null) {
			try {
				stream.close();
			} catch (IOException e) {
			}
		}
	}

	public static String read(InputStream inputStream) {
		return read(inputStream, "UTF-8");
	}

	public static String read(InputStream inputStream, String encode) {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(
					inputStream, encode), 1024 * 4);
			for (String line = bufferedReader.readLine(); line != null; line = bufferedReader
					.readLine()) {
				stringBuilder.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return stringBuilder.toString();
	}

	public static void write(DataOutputStream dataOutputStream, String string) {
		FileInputStream fileInputStream = null;
		try {
			dataOutputStream.writeUTF(string);
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}