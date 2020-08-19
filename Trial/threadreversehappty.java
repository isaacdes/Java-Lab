import java.io.*;
import java.util.Scanner;
import java.lang.String;
import java.lang.Thread;
import java.lang.Exception;

class OddReverse{
	String reverseOdd(String str){
		int len = str.length();
		if(len %2 == 0)
			return "Cannot be reversed";
		len--;
		String rev ="";
		for(int i=len; i>=0; i--)
			rev += str.charAt(i);
		return rev;
	}
}

class OddReverseThread implements Runnable {
	String str;
	OddReverse obj1 = new OddReverse();
	Thread obj2 = new Thread(this);
	public void run(){
		try {
			obj2.sleep(1000);
		}
		catch(InterruptedException e) {
			System.out.println(e);
		}
		String rev = obj1.reverseOdd(str);
		System.out.println("Reversed String is " + rev);
	}
	
	OddReverseThread(String str){
		this.str = str;
		obj2.start();
	}
}

class HappyNumber {
	static int count = 0;
	static int flag = 0;
	
	String happyAlgorithm(int num){
		int d, sq_sum = 0;
		if(num == 4 || num == 16 || num == 37 || num == 58 || num == 89 || num == 145 || num == 42 || num ==20){
			flag = 0;
			return "Sad Number";
		}
		count ++;
		
		//To find the number of sqaures
		while (num != 0){
			d = num  % 10;
			sq_sum += d*d;
			num  = num/10;
		}
		
		//to find out if number is happy or not
		if(sq_sum == 1) {
			flag =1;
			return "Happy number with count: " + count;
		}
		else
			happyAlgorithm(sq_sum);
		
		if(flag == 1)
			return "HAppy number with count: " + count;
		
		else
			return "Sad number";
	}
}

class HappyNumberThread implements Runnable {
	int num;
	HappyNumber obj1 = new HappyNumber();
	Thread obj2 = new Thread(this);
	
	public void run() {
		try {
			obj2.sleep(1000);
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
		
		String res = obj1.happyAlgorithm(num);
		System.out.println(res);
	}
	
	HappyNumberThread(int num){
		this.num = num;
		obj2.start();
	}
}

 class threadreversehappy {
	public static void main(String[] args) {
		OddReverseThread obj1 = new OddReverseThread("Testing the program");
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
		HappyNumberThread obj2 = new HappyNumberThread(191);
		HappyNumberThread obj3 = new HappyNumberThread(48);
	}
}
