package com.precourse.racingcar;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		

		Scanner scan = new Scanner(System.in);
		
		//자동차의 이름과 시도 횟수를 입력 받는다.
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String inputText = scan.nextLine();
		
		System.out.println("시도할 횟수는 몇회인가요?");
		int count = scan.nextInt();
		
	}
}
