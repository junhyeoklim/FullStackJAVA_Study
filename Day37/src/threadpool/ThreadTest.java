package threadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {

//		1번 문제
//		System.out.println("main Thread name : "+Thread.currentThread().getName());
		
//		2번 문제
//        Runnable task1 = () -> 
//        {
//        	for(int i=0; i<20; i++)
//        	{
//        		if(i%2 == 0)
//        			System.out.print(i+" ");        		
//        	}
//        	
//        };
//
//        Thread t1 = new Thread(task1);
//        t1.start();
	
		
//		3번 문제 
//		 Runnable task = () -> {     // 쓰레드에게 시킬 작업
//	            int n1 = 10;
//	            int n2 = 20;
//	            String name = Thread.currentThread().getName();
//	            System.out.println(name + ": " + (n1 + n2));
//	        };
//	        
//	        ExecutorService tpe =Executors.newSingleThreadExecutor();
//	        
//	        tpe.submit(task);
//	        System.out.println("End : "+ Thread.currentThread().getName());
//	        tpe.shutdown();
		
//		4번 문제
//		Callable<Integer> task = () -> 
//		{
//			int sum =0;
//			for(int i=0;i<10;i++)
//				sum += i;
//			return sum;
//		};
//	        
//		ExecutorService tpe =Executors.newSingleThreadExecutor();		
//		
//		Future<Integer> fur = tpe.submit(task);
//		
//		try {
//			Integer r = fur.get();
//			System.out.println("End : "+ Thread.currentThread().getName());
//			System.out.println("result : "+r);
//			tpe.shutdown();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		5번 문제
		
		List<Integer> array = Collections.synchronizedList(new ArrayList<Integer>());
		
		for(int i=0; i<15; i++)
			array.add(i);
		System.out.println(array);
		Runnable task = () ->
		{
			synchronized (array) {
				ListIterator<Integer> iter = array.listIterator();
				
				while(iter.hasNext())
					iter.set(iter.next()+1);
			}	
		};
		
		ExecutorService exr = Executors.newFixedThreadPool(3);
		exr.submit(task);
		exr.submit(task);
		exr.submit(task);
		
		exr.shutdown();
		// 이걸 안 해주면 쓰레드 풀이 그냥 끝나버린다.
		exr.awaitTermination(100, TimeUnit.SECONDS);
		System.out.println(array);
	}
}
