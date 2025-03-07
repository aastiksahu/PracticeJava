package com.aastik.basicpart1;

import java.util.Scanner;

public class Q6Airthmetic {

	public static void main(String[] args) {

		// basic aithematics operation
		// first one
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number:");
		int num1 = sc.nextInt();
		System.out.println("Enter second number");
		int num2 = sc.nextInt();

		System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
		System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
		System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));
		System.out.println(num1 + "/" + num2 + "=" + (num1 / num2));
		System.out.println(num1 + "%" + num2 + "=" + (num1 % num2));
		System.out.println();

		// second one
		int sum = num1 + num2;
		int subtraction = num1 - num2;
		int multiply = num1 * num2;
		int divide = num1 / num2;
		int modulus = num1 % num2;
		System.out.printf("Sum = %d\nSubtraction = %d\nMultiply = %d\nDivide = %d\nModulus= %d\n", sum, subtraction,
				multiply, divide, modulus);
		System.out.println();
		
		System.out.println("Sum = " + sum + "\nSubtraction = " + subtraction + "\nMultiply = " + multiply + "\nDivide = "
				+ divide + "\nModulus = " + modulus);

	}

}
