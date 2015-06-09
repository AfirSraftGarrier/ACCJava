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
package com.acc.java.util;

import com.acc.java.model.Direction;

public class DirectionUtil {
	public static Direction getDirection(float fromX, float fromY, float toX,
			float toY) {
		if (fromX > toX) {
			if (fromY > toY) {
				return Direction.LEFTUP;
			} else if (fromY == toY) {
				return Direction.LEFT;
			} else {
				return Direction.DOWNLEFT;
			}
		} else if (fromX == toX) {
			if (fromY > toY) {
				return Direction.UP;
			} else if (fromY == toY) {
				return Direction.STOP;
			} else {
				return Direction.DOWN;
			}
		} else {
			if (fromY > toY) {
				return Direction.UPRIGHT;
			} else if (fromY == toY) {
				return Direction.RIGHT;
			} else {
				return Direction.RIGHTDOWN;
			}
		}
	}
}