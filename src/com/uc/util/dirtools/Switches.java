package com.uc.util.dirtools;

import java.util.Scanner;

public class Switches {
	public static void run() {		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a #: ");
		String input = sc.nextLine();
		int monthNumber = Integer.parseInt(input);
		String text = "";
		
		switch(monthNumber) {
		case 1:
			text = "January";
			break;
		case 2:
			text = "February";
			break;
		default:
			text = "";
			break;
		}
		
		System.out.println(text);
		
		
		text = "";
		System.out.println("Enter a month");
		input = sc.nextLine();
		switch (input) {
		case "Jan":
			text = "January";
			break;
		default:
			text = ""; 
			break;
		}
		System.out.println(text);
	}
}
