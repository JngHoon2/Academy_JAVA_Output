package com.javalab.spring;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class JunitTestCase {

	@Test
	public void test() {
		//assertEquals("1", "1");
		assertNotNull(new ArrayList<String>());
	}

}
