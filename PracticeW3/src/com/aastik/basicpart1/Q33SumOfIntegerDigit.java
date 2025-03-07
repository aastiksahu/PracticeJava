package com.aastik.basicpart1;

import java.util.Scanner;

public class Q33SumOfIntegerDigit {

	public static void main(String[] args) {
		// program of sum integer Digit

		int sum = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Any 2 Digit Number :");
		long n = sc.nextLong();
		
		while (n != 0) {
			sum += n % 10;
			//System.out.println(sum);
			n /= 10;
		}
		System.out.println(sum);
	}

}
