package com.aastik.basicpart1;

import java.util.Scanner;

public class Q7MutliplicationTable {

	// write a program of multiplication table?

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// first type
//		System.out.println("Enter first number:");
//		System.out.println("Enter Second number:");
//
//		for (int num1 = sc.nextInt(), num2 = sc.nextInt(); num1 <= num2; num1++) {
//			
//			System.out.println();
//			System.out.println("Table of :" + num1);
//			System.out.println();
//			
//			for (int j = 1; j <= 10; j++) {
//				System.out.println(num1 + " x " + j + " = " + num1 * j);
//
//			}
//		}
		// second type
		System.out.println("Enter Lowest Number");
		int num1 = sc.nextInt();
		System.out.println("Enter Highest Number");
		int num2 = sc.nextInt();

		for (int i = num1, j = num2; i <= j; i++) {
			
			System.out.println();
			System.out.println("Table of :" + i);
			System.out.println();
			
			for (int k = 1; k <= 10; k++) {
				System.out.println(i + " x " + k + " = " + i * k);

			}

		}

	}

}
