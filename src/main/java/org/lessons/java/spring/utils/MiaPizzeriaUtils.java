package org.lessons.java.spring.utils;

public class MiaPizzeriaUtils {
	
	public static String priceFormatter( float price) {
		
		String formattedPrice;
		
		if(price != 0) {
			
			formattedPrice =  String.format("%.2f €", price);
		}else {
			
			formattedPrice = "Free";
			
		}
		
		
		return formattedPrice;
		
	}
	
	public static String priceFormatter( double price) {
		
		String formattedPrice;
		
		if(price != 0) {
			
			formattedPrice =  String.format("%.2f €", price);
		}else {
			
			formattedPrice = "Free";
			
		}
		
		
		return formattedPrice;
		
	}

}
