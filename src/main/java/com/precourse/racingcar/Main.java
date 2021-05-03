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
		
		//�ڵ����� �̸��� �õ� Ƚ���� �Է� �޴´�.
		System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸��� ��ǥ(,) �������� ����)");
		String inputText = scan.nextLine();
		
		System.out.println("�õ��� Ƚ���� ��ȸ�ΰ���?");
		int count = scan.nextInt();
		
		// �Է¹��� �ڵ��� �̸����� ����Ʈ�� �����Ѵ�.
		carList = mainObj.createCarList(inputText);
		
		
		//�� �ڵ������� �������� ���� 4 �̻��� ��� �����ϰ�, 3������ ��� �����.
		for(int i = 0; i < count; i++) { //�õ� Ƚ����ŭ �ݺ�
			carList = mainObj.pushCar(carList);
		}
		
		//����� �ڵ��� ���ϱ�
		List<Car> winList = mainObj.getWinCars(carList);
		
		//����� �ڵ��� ����ϱ�
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
			randNum = rand.nextInt(10); //0~9������ ���� �� ���ϱ�
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
		str += "�� ���� ����߽��ϴ�.";
		
		System.out.println(str);
	}
}
