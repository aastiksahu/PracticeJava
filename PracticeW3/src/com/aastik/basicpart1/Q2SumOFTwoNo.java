package com.aastik.basicpart1;

import java.util.Scanner;

public class Q2SumOFTwoNo {

	public static void main(String[] args) {

		// Write a java program to print the sum of two number?
		// first one without using variable
		int sum = 24 + 26;
		System.out.println(sum);

		// second one using variable
		int a = 24;
		int b = 26;
		int add;
		add = a + b;
		int addition = a + b;
		System.out.println(addition);
		System.out.println(add);
		System.out.println("sum is: " + add + " " + addition);

		// third one using Scanner Class
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Number:");
		int num1 = sc.nextInt();
		System.out.println("Enter Second Nymber");
		int num2 = sc.nextInt();
		int sum1 = num1 + num2;
		System.out.println("Sum: " + sum1);
	}
}
