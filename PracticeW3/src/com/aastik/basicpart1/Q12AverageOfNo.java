package com.aastik.basicpart1;

import java.util.Scanner;

public class Q12AverageOfNo {

	public static void main(String[] args) {
		
		//Write a program to find the average of n Numbers?

		float b = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("How many number You want to Calculate the Average :");
		int a = sc.nextInt();

		for (int i = 1; i <= a; i++) {
			System.out.println("Enter " + i + " Number: ");
			b += sc.nextFloat();
		}
		float avg = b / a;
		System.out.println("Average of the " + a + " Numbers is :" + avg);
	}

}
