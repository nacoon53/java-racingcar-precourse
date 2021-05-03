package com.precourse.racingcar;

import java.util.ArrayList;
import java.util.List;
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
}
