package edu.usal.util;

import java.util.Scanner;

public class IOGeneral {
	
	public static void println(String frase){
		System.out.println(frase);
	}
	
	public static int leerInt(String msjInicio, String msjError){
		IOGeneral.println(msjInicio);
		Scanner scan = new Scanner(System.in);
		while(!scan.hasNextInt()){
			IOGeneral.println(msjError);
			scan.next();
		}
		return scan.nextInt();
	}
	
	public static float leerFloat(String msjInicio, String msjError){
		IOGeneral.println(msjInicio);
		Scanner scan = new Scanner(System.in);
		while(!scan.hasNextFloat()){
			IOGeneral.println(msjError);
			scan.next();
		}
		return scan.nextFloat();
	}
	
	public static double leerDouble(String msjInicio, String msjError){
		IOGeneral.println(msjInicio);
		Scanner scan = new Scanner (System.in);
		while(!scan.hasNextDouble()){
			IOGeneral.println(msjError);
			scan.next();
		}
		return scan.nextDouble();
	}
	
	public static String leerLinea(String msjInicio){
		IOGeneral.println(msjInicio);
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	public static String leerFrase(String msjInicio){
		IOGeneral.println(msjInicio);
		Scanner scan = new Scanner (System.in);
		return scan.next();
	}

}