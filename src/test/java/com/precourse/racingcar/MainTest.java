package com.precourse.racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test
	public void testGetWinCars() {
		Main mainObj = new Main();
		
		Car car1 = new Car("A");
		Car car2 = new Car("B");
		Car car3 = new Car("C");
		
		car2.goCountPlus();
		car2.goCountPlus();
		car3.goCountPlus();
		
		List<Car> list = new ArrayList<Car>();
		list.add(car1);
		list.add(car2);
		list.add(car3);		
		assertEquals(mainObj.getWinCars(list).get(0).getName(), "B");
		
		car3.goCountPlus();
		car3.goCountPlus();		
		assertEquals(mainObj.getWinCars(list).get(0).getName(), "C");
		

		car2.goCountPlus();
		assertEquals(mainObj.getWinCars(list).size(), 2);
		
	}
}
