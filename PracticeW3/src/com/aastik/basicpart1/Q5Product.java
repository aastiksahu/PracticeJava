package com.aastik.basicpart1;

import java.util.Scanner;

public class Q5Product {
	// second one
	static int x = 25;
	static int y = 2;

	public static void main(String[] args) {

		// write a program to take a product of number?
		// first one
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Number");
		int num1 = sc.nextInt();
		System.out.println("Enter Second Number");
		int num2 = sc.nextInt();
		int pro;
		pro = num1 + num2;
		int product = num1 * num2;
		System.out.println("Product is :" + num1 * num2);
		System.out.println("Product is :" + pro);
		System.out.println("Product is :" + product);

		// second one
		System.out.println(x * y);
	}

}
