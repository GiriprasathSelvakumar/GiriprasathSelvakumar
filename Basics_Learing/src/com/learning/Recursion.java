package com.learning;

public class Recursion {

	public static void main(String[] args) {
		Recus (10);

	}

	public static void Recus(int i) {

		if(i==1) {

			System.out.println(1);
		}
		else 	{
			System.out.println(i);
		Recus (i-1);

		}
	}


}

