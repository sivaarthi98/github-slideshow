

       class Numbers {
	int n=1;
	int total_threads;
	int total_nos;

       public Numbers(int threads, int total_nos) {
		super();
		this.total_threads = threads;
		this.total_nos = total_nos;
	}

        public void print(int ans) {
            synchronized (this) {
	while(n < total_nos) {
	      while(n % total_threads != ans) {
		try {
		      wait();
		      }
		catch(InterruptedException e) {
		      e.printStackTrace();
		       }
	        }
		if(n==101) {
		                 break;
			}
		System.out.println(Thread.currentThread().getName()+" "+n++);
			notifyAll();
                 }
              }
           }
        }
 
            class Sequence implements Runnable{
	Numbers numbers;
	int ans;
		
	     public Sequence(Numbers numbers,int ans) {
		   super();
		   this.numbers=numbers;
		   this.ans=ans;
	}
	       public void run() {
		   numbers.print(ans);
	                   }
	}


              public class Threadpgm1 {

	 static  int threads= 10;
	 static  int total_nos=100;

	public static void main(String[] args) {
	    
		Numbers numbers=new Numbers(threads, total_nos);
		
		Thread t1=new Thread(new Sequence(numbers, 1), "Thread-1");
		Thread t2=new Thread(new Sequence(numbers, 2), "Thread-2");
		Thread t3=new Thread(new Sequence(numbers, 3), "Thread-3");
		Thread t4=new Thread(new Sequence(numbers, 4), "Thread-4");
		Thread t5=new Thread(new Sequence(numbers, 5), "Thread-5");
		Thread t6=new Thread(new Sequence(numbers, 6), "Thread-6");
		Thread t7=new Thread(new Sequence(numbers, 7), "Thread-7");
		Thread t8=new Thread(new Sequence(numbers, 8), "Thread-8");
		Thread t9=new Thread(new Sequence(numbers, 9), "Thread-9");
		Thread t10=new Thread(new Sequence(numbers, 0), "Thread-10");
		
                                      t1.start();
         		   t2.start();
    		   t3.start();
     		   t4.start();
    		   t5.start();
     		  t6.start();
    		  t7.start();
     		  t8.start();
    		  t9.start();
     		  t10.start();
                }
            }


