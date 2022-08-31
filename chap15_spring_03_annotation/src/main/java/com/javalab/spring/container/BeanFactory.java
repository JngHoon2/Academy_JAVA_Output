package com.javalab.spring.container;

import com.javalab.spring.vo.*;

public class BeanFactory {
	public TV getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		} else if(beanName.equals("lg")) {
			return new LGTV();
		} else {
			return null;
		}
	}
}
