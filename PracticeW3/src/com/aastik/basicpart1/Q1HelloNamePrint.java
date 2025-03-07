package com.aastik.basicpart1;

import java.util.Scanner;

public class Q1HelloNamePrint {

	// Write A Java Program to print "Hello" on screen and your name on a separate line?

	public static void main(String[] args) {

		System.out.println("Hello \nAastik Sahu");

		// Second Type Using Scanner

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter First Name");
		String fname = sc.next();

		System.out.println("Enter Last Name");
		String lname = sc.next();

		System.out.println("Hello \n" + fname + " " + lname);

	}

}
