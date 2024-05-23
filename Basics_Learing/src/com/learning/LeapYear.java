package com.learning;

public class LeapYear {

	public static void main(String[] args) {
		int Year = 1997 ; 

		if (Year%400==0) {

			System.out.println("Leap Year : "+Year); 
		}
		else if(Year%100!=0) {

			System.out.println("Not a Leap Year :"+Year);

		}
		else if(Year%4==0) {

			System.out.println("Leap year : "+Year);

		}
		else 
			System.out.println("Non of the above ");
	}

}


