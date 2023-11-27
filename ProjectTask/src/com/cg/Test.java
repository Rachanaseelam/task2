package com.cg;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number: ");
		int num=s.nextInt();
		int sum=0;
		int rem=0;
		System.out.println(num+ "is the enterd number");
		rem=num%10;
		sum=sum+rem;
		System.out.println(sum+ " is sum of the entered number");
		num=num/10;
		
		
	}
	

}
