package com.precourse.racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		

		Main mainObj = new Main();
		Scanner scan = new Scanner(System.in);
		
		List carList = null;
		
		//자동차의 이름과 시도 횟수를 입력 받는다.
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String inputText = scan.nextLine();
		
		System.out.println("시도할 횟수는 몇회인가요?");
		int count = scan.nextInt();
		
		// 입력받은 자동차 이름으로 리스트를 생성한다.
		carList = mainObj.createCarList(inputText);
		
		
		//각 자동차마다 랜덤값을 구해 4 이상일 경우 전진하고, 3이하일 경우 멈춘다.
		for(int i = 0; i < count; i++) { //시도 횟수만큼 반복
			carList = mainObj.pushCar(carList);
		}
		
		//우승한 자동차 구하기
		List<Car> winList = mainObj.getWinCars(carList);
		
		//우승한 자동차 출력하기
		mainObj.printWinCars(winList);
		
		
		
		
	}
	
	public List<Car> createCarList(String inputText) {
		List list = new ArrayList();
		String[] names = inputText.split(",");
		
		for(String name : names) {
			Car car = new Car(name);
			list.add(car);
		}
		
		return list;
	}
	
	public List<Car> pushCar(List<Car> list) {
		Random rand = new Random();
		int randNum = 0;
		
		for(Car car : list) {
			randNum = rand.nextInt(10); //0~9까지의 랜덤 수 구하기
			if(randNum >= 4) {
				car.goCountPlus();
			}
		}
		
		return list;
	}
	
	public List<Car> getWinCars(List<Car> list) {
		List<Car> winList = new ArrayList<Car>();
		Collections.sort((List<Car>) list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				int num1 = ((Car)o1).getGoCount();
				int num2 = ((Car)o2).getGoCount();
				
				if(num1 > num2) {
					return -1;
				}else if(num1< num2) {
					return 1;
				}
				return 0;
			}
		});
		
		int winPushCount = list.get(0).getGoCount();
		
		for(int i = 0; i<list.size(); i++) {
			if(i != 0 && winPushCount != list.get(i).getGoCount()) {
				break;
			}
			winList.add(list.get(i));
		}
		
		return winList;
	}
	
	public void printWinCars(List<Car> list) {
		String str = "";
		for(int i = 0; i < list.size(); i++) {
			str += list.get(i).getName();
			if(i < list.size()-1) {
				str += ", ";
			}
		}
		str += "가 최종 우승했습니다.";
		
		System.out.println(str);
	}
}
