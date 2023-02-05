
	 package com.kas.java8;

import javax.management.RuntimeErrorException;

interface Calculator {

	// void switchOn();

	/* void sum(int input); */

	//Define substract method
	int substrct(int i,int j);
}

public class CalculatorImpl {

	public static void main(String[] args) {

		/*
		 * Calculator calculator = () -> System.out.println("Switch On");
		 * 
		 * calculator.switchOn();
		 */

		/*
		 * Calculator calculator = (input) -> System.out.println("Sum : " + input);
		 * calculator.sum(394);
		 */

		//implement substract method using lambda
		 Calculator calc = (i , j) ->{
			if(i>j) return i-j;
			else throw new RuntimeException("-ve Value exception");
		};
		//call substract method
		System.out.println(calc.substrct(30, 20));
	}

	// () -> {body};
}
