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
package com.acc.java.model;

public class GeoDataWithoutAddress {
	private double longitude;
	private double latitude;
	private GeoStatus geoStatus;
	private double accuracy;

	// private double speed;
	// private int satelliteNum;

	public GeoStatus getGeoStatus() {
		return geoStatus;
	}

	public void setGeoStatus(GeoStatus geoStatus) {
		this.geoStatus = geoStatus;
	}

	public double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	// public double getSpeed() {
	// return speed;
	// }
	//
	// public void setSpeed(double speed) {
	// this.speed = speed;
	// }
	//
	// public int getSatelliteNum() {
	// return satelliteNum;
	// }
	//
	// public void setSatelliteNum(int satelliteNum) {
	// this.satelliteNum = satelliteNum;
	// }

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
}