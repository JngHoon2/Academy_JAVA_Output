package com.javalab.anonymous03;

public class Anonymous {
	Vehicle field = new Vehicle() {
		
		@Override
		public void run() {
			System.out.println("자전거가 달립니다.");
		}
	};
	
	void method1() {
		Vehicle localVehicle = new Vehicle() {
			
			@Override
			public void run() {
				System.out.println("승용차가 달립니다.");
			}
		};
		localVehicle.run();
		System.out.println("Anonymous > method > localVehicle : " + localVehicle);
	}
	
	void method2(Vehicle v) {
		v.run();
	}
}
