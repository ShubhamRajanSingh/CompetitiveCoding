package com.java.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MaxSum {
	
	public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;
	public static void main(String arg[]) {
// THERE IS A PYTHON FILE IN THIS FOLDER FOR BFR PLEASE CHAECK IF NEEDED
	
		System.out.println(calculateDistanceInKilometer(19.2024016,73.1118384,19.2014327,73.1113331));
	}
	
	public static double calculateDistanceInKilometer(double lat1, double lng2,
	  double lat2, double lng1) {

		 double earthRadius = 6371.0d; // KM: use mile here if you want mile result

		  double dLat = toRadian(lat2 - lat1);
		  double dLng = toRadian(lng2 - lng1);

		  double a = Math.pow(Math.sin(dLat/2), 2)  + 
		          Math.cos(toRadian(lat1)) * Math.cos(toRadian(lat2)) * 
		          Math.pow(Math.sin(dLng/2), 2);

		  double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

		  return earthRadius * c*1000;
	}
	public static double toRadian(double degrees) 
	{
	  return (degrees * Math.PI) / 180.0d;
	}
}
