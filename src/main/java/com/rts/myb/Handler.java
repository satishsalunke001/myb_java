package com.rts.myb;

import java.util.Random;

public class Handler {

	public static void main(String[] args) {
		Random random = new Random();
//		System.out.println(String.format("%09d", random.nextInt(1000000000)));
		
		String org = "596939647";
		String gen = "";
		boolean flag = true;
		
		while(flag) {
			gen = String.format("%09d", random.nextInt(1000000000));
			if(!gen.equals(org)) {
				flag = false;
				 break;
				 
			}
		}
		
		System.out.println(gen);
	}
}
