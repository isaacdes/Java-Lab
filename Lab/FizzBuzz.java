


class ThreadA extends Thread {
	FizzBuzz obj = new FizzBuzz(5);
//	System.out.println("Thread A :");
	public void run() {
		obj.fizz();
	}
}

class ThreadB extends Thread {
	FizzBuzz obj  = new FizzBuzz(5);
	//System.out.println("Thread B :");
	public void run() {
		obj.buzz();
	}
}

class ThreadC extends Thread {
	FizzBuzz obj = new FizzBuzz(5);
//	System.out.println("Thread C :");
	public void run() {
		obj.fizzBuzz();
	}
}

class FizzBuzz {
	int num;
	
	public FizzBuzz(int num) {
		this.num = num;
	}
	
	public void fizz(){
		for (int i=1; i<=num; i++) {
			if (i%3 == 0 )
				System.out.print("fizz");
			else
				System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	public void buzz() {
		for (int i=1; i<=num; i++) {
			if (i%5 == 0 )
				System.out.print("buzz");
			else
				System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	public void fizzBuzz() {
		for (int i=1; i<=num; i++) {
			if ( i%3 == 0 && i%5 == 0)
				System.out.print("fizzbuzz");
			else if (i%3 == 0 )
				System.out.print("fizz");
			else if ( i%5 == 0)
				System.out.print("buzz");
			else
				System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		ThreadA A = new ThreadA();
		ThreadB B = new ThreadB();
		ThreadC C = new ThreadC();
		System.out.println("Thread A: ");
	//	A.start();
	//	System.out.println("Thread B: ");
	//	B.start();
	//	System.out.println("Thread C: ");
		C.start();
	//	System.out.println();
	}
}