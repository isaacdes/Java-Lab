import java.io.*;
import java.util.*;
import java.lang.String;
import java.lang.Thread;
import java.lang.Exception;
class oddreverse
{
	String reverseOdd(String input)
	{
		int length=input.length();
		if(length % 2 == 0)
		{
			return "Cannot be reversed! ";
		}
		
		length=length-1;
		String reverse="";
		for(int j=length ;j>=0;j--)
		{
			reverse+=input.charAt(j);
		}
		return reverse;
	}
}

class oddreversethread implements Runnable
{
	String input;
	oddreverse obj1=new oddreverse();
	Thread obj2=new Thread(this);
	
	public void run()
	{
		try
		{
			obj2.sleep(1000);	
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		String reverse=obj1.reverseOdd(input);
		System.out.println("Reversed String is "+reverse);
	}
	
	oddreversethread(String str)
	{
		input=str;
		obj2.start();
	}
	
}
	
	
class Happynumber
{
	static int count=0;
	static int flag=0;
	String happyAlgorithm(int input)
	{
		
		int number,digit,square_sum=0;
		if(input==4 || input==16 || input==37 || input==58 || input == 89 || input==145 || input == 42 || input == 20)
		{
			flag=0;
			return "sad number";
		}
		
		count++;
		
		//Finding the sum of square of digits
		number=input;
		while (number > 0)
		{
			digit=number%10;
			square_sum	+=	digit*digit;
			number=number/10;
		}
		number=square_sum;
	
		//checking whether sum is happy number or not
		if ( number==1)
		{
			flag=1;
			return "happy number with count :"+count;
		}
		else
		{
			happyAlgorithm(number);
		}
		
		
		if(flag==1)
		{
			return "happy number with count :"+count;
		}
		else
		{
			return "sad number";
		}
		
	}
}

class happynumberthread implements Runnable
{
	int number;
	Happynumber obj1=new Happynumber();
	Thread obj2=new Thread(this);
	
	public void run()
	{
		try
		{
			obj2.sleep(1000);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}	
			
		String result=obj1.happyAlgorithm(number);
		System.out.println(result);
	}
	
	
	happynumberthread(int num)
	{
		number=num;
		obj2.start();//calling run function of thread
	}

}



class threadreversehappy
{
	public static void main(String[] args)
	{
		oddreversethread object1=new oddreversethread("Testing the program");
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		happynumberthread object2=new happynumberthread(139);
	}
	
}