package com.test;

import java.util.Date;

class Road {
	private String trafficLight;
	private int roadId;
	
	public Road(int roadId) {
		// TODO Auto-generated constructor stub
		this.roadId = roadId;
		this.trafficLight = "Red";
	}
	
	public void setTrafficLight(String trafficLight) {
		this.trafficLight = trafficLight;
	}
}

public class TrafficSignal {

	int ttlGreenSignal = 45;
	
	public boolean turnGreenSignalOn(Road roadId) {
		roadId.setTrafficLight("Green");
		return startTimer(ttlGreenSignal);
	}

	public void turnRedSignalOn(Road roadId) {

	}

	public void turnYellowSignalOn(Road roadId) {

	}
	
	public boolean startTimer(int seconds) {
		// scheduler -> 2 seconds prior to the ttl, it'll start another scheduler.
//		Date currentTime = new Date().compareTo();
		
		return true;
	}
	
	public static void main(String[] args) {
		int numberOfRoads = 4;
		int signals = numberOfRoads;
		int ttlGreenSignal = 45;
		Road[] roads = new Road[numberOfRoads];
		for (int i = 0; i < numberOfRoads; i++) {
			roads[i] = new Road(i);
		}
		
		
	}
	
	public void startMainSignal(int signals, int ttlGreenSignal, Road[] roads) {
		
		int id = 0;
		while (true) {
			turnGreenSignalOn(roads[id]);
			
			id = (id + 1) % signals;
		}
	}
}




/*
							1
						2		3
					4	5		6	7	

4521367

in - 4 2 5 | 1 | 6 3 7
pre - 1 2 4 5 3 6 7




*/