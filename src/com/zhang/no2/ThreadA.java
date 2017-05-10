package com.zhang.no2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ThreadA extends Thread {
	private Lock lock;
	private Condition cond;
	int num = 0;

	public ThreadA(Lock lock, Condition cond) {
		this.lock = lock;
		this.cond = cond;
	}

	@Override
	public void run() {
		try{
		this.lock.lock();
		
		 while(num <= 10){
			 if(Test.falg){
				 Test.falg = false;
				 try {
					
					cond.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			 System.out.println(Thread.currentThread().getName()+"One");
			 num++;
			 Test.falg = true;
			 cond.signal();
		 }
		}finally {
			this.lock.unlock();
		}
	}
}