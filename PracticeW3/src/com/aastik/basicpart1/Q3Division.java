package com.aastik.basicpart1;

import java.util.Scanner;

public class Q3Division {

	public static void main(String[] args) {

		// write a program to divide two number?
		// first one
		int result = 50 / 3;
		System.out.println(result);

		// second one
		int a = 50;
		int b = 3;
		int divi;
		divi = a / b;
		int division = a / b;
		System.out.println(divi);
		System.out.println(division);
		System.out.println("division is: " + divi + " " + division);

		// third one
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Number");
		int num1 = sc.nextInt();
		System.out.println("Enter First Number");
		int num2 = sc.nextInt();
		int d = num1 / num2;
		System.out.println("Division is " + d);
	}

}
