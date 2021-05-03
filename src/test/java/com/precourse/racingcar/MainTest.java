package com.precourse.racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MainTest {
	@Test
	public void testCreateCarList(){
		Main mainObj = new Main();
		
		String str = "pobi,crong,honux";
		assertEquals(mainObj.createCarList(str).size(), 3);
		
		str = "pobi,crong";
		assertEquals(mainObj.createCarList(str).size(), 2);
	}
}
