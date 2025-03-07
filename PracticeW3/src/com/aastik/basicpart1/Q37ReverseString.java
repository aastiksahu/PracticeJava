package com.aastik.basicpart1;

import java.util.Scanner;

public class Q37ReverseString {

	public static void main(String[] args) {

		// Program to Reverse the string?
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Any String :");
		char[] a = sc.nextLine().toCharArray();

		for (int i = a.length - 1; i >= 0; i--) {
			System.out.print(a[i]);

		}
	}

}
