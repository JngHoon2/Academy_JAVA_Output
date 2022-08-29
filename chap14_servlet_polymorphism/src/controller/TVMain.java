package controller;

import container.BeanFactory;
import vo.LGTV;
import vo.SamsungTV;
import vo.TV;

public class TVMain {
	public static void main(String[] args) {
		
//		SamsungTV samsungTV = new SamsungTV();
//		samsungTV.powerOn();
//		samsungTV.volumeUp();
//		samsungTV.volumeDown();
//		samsungTV.powerOff();
//		System.out.println();
		
//		LGTV lgTV = new LGTV();
//		lgTV.powerOn();
//		lgTV.volumeUp();
//		lgTV.volumeDown();
//		lgTV.powerOff();
//		System.out.println();
		
//		TV stv = new SamsungTV();
//		stv.powerOn();
//		stv.volumeUp();
//		stv.volumeDown();
//		stv.powerOff();
		
		BeanFactory beanFactory = new BeanFactory();
		TV tv = (TV)beanFactory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}
