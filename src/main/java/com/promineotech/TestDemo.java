package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if(a > 0 && b > 0) {
			return a += b;
			
		} else throw new IllegalArgumentException("Both parameters must be positive!");
		
	}
	
	public int countSpaces(String str) {
		int spaceCount = 0;
		for(int i = 0; i < str.length(); i ++) {
			if (str.charAt(i) == ' ') {
				spaceCount ++;
			}
		}return spaceCount;
	}
	
	public int randomNumberSquared() {
		int num;
		num = getRandomInt();
		return num*num;
	}
	
	protected int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}
