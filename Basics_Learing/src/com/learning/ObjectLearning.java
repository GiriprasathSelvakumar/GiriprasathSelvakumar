package com.learning;

public class ObjectLearning {
	
	
	int MobNos; 
	String girifrndname;
	
	
	public void  Output () {
		
		System.out.println("Giri's Girlfrndname : " + girifrndname);
		System.out.println("Giri's Girifrnd Mob no :  " + MobNos);
		
	}
		
		public static void main(String args[])  {
			
			
			ObjectLearning Dating =new ObjectLearning();
			Dating.girifrndname="Harshini";
			Dating.MobNos=985856885;
			Dating.Output();
			
		}
			
			
			
			
		
		
		
		
		
		
	
}
