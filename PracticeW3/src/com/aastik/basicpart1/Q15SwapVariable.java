package com.aastik.basicpart1;

import java.util.Scanner;

public class Q15SwapVariable {

	public static void main(String[] args) {

		// swap using temp variable?
//		int a, b, temp;
//		a = 15;
//		b = 27;
//		System.out.println("Before Swapping :\na = " + a + "\nb = " + b);
//
//		temp = a;
//		a = b;
//		b = temp;
//		System.out.println("After Swapping :\na = " + a + "\nb = " + b);

		// swap without using temp variable?
//		int a, b;
//		a = 15;
//		b = 27;
//		System.out.println("Before Swapping :\na = " + a + "\nb = " + b);
//		a = a + b;
//		b = a - b;
//		a = a - b;
//		System.out.println("After Swapping :\na = " + a + "\nb = " + b);
		
		//Swap using Scanner Class and without using temp variable?
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Enter First Number a:");
//		int a = sc.nextInt();
//		System.out.println("Enter Second Number b:");
//		int b = sc.nextInt();
//		
//		System.out.println("Before Swapping :\na = " + a + "\nb = " + b);
//		
//		a = a + b;
//		b = a - b;
//		a = a - b;
//		System.out.println("After Swapping :\na = " + a + "\nb = " + b);
		
		//Swap Using Scanner Class and also using temp variable?
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter First Number a:");
		int a = sc.nextInt();
		System.out.println("Enter Second Number b:");
		int b = sc.nextInt();
		
		int temp;
		System.out.println("Before Swapping :\na = " + a + "\nb = " + b);
		
		temp = a;
		a = b;
		b = temp;
		System.out.println("After Swapping :\na = " + a + "\nb = " + b);
	}

}
