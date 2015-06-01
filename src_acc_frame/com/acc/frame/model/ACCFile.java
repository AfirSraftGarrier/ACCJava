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
package com.acc.frame.model;

public class ACCFile {
	private String localPath;
	private String netUrl;
	private String tempPath;
	private String key;
	private Float progress;

	public String getNetUrl() {
		return netUrl;
	}

	public void setNetUrl(String netUrl) {
		this.netUrl = netUrl;
	}

	public String getLocalPath() {
		return localPath;
	}

	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}

	public String getTempPath() {
		return tempPath;
	}

	public void setTempPath(String tempPath) {
		this.tempPath = tempPath;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Float getProgress() {
		return progress;
	}

	public void setProgress(Float progress) {
		this.progress = progress;
	}

	// public Double getProgress() {
	// return progress;
	// }
	//
	// public void setProgress(Double progress) {
	// this.progress = progress;
	// }
}