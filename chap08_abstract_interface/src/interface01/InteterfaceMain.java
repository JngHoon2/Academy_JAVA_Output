package interface01;

import interface01.vo.LGTV;
import interface01.vo.SamsungTV;
import interface01.vo.TV;

public class InteterfaceMain {

	public static void main(String[] args) {
		SamsungTV sTv = new SamsungTV();
		sTv.powerOn();
		sTv.volumeUp();
		sTv.volumeDown();
		sTv.powerOff();
		System.out.println();
		
		LGTV ltv = new LGTV();
		
		ltv.powerOn();
		ltv.volumeUp();
		ltv.volumeDown();
		ltv.powerOff();
		System.out.println();
		
		TV tv = new SamsungTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		System.out.println();
		
		TV tv2 = new LGTV();
		tv2.powerOn();
		tv2.volumeUp();
		tv2.volumeDown();
		tv2.powerOff();
	}

}
