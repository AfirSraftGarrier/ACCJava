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
package com.acc.java.util.listener;

import com.acc.java.util.listener.RequestListener.RequestFailReason;

public interface FileDownloadListener {
	void onSuccess(String key, Object valueObject);

	void onFail(String key, RequestFailReason fileDownloadFailReason);

	void onProgress(String key, double already, double total);

	// byte[] getByteArray(String url, RequestListener requestListener);
}