package com.root.log;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LogDemoTest {

	LogDemo h;
	
	@Before
	public void setUp() throws Exception {
		h = new LogDemo();
	}

	@Test
	public void testSomme() {
		assertEquals(4, h.somme(2, 2));
	}

}
