package com.learning;

public class NestedLoops {

	public static void main(String[] args) {
		
		int i , j;
		
		for(i=0;i<=3;i++) {
			
			for(j=1;j<=3;j++)
			{
				if(j==2) 
				{
					continue;	// skip the particular j =2  
				}
				System.out.println(i+" "+j);
			}
			
		}

	}

}
