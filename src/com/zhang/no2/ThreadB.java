package com.zhang.no2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ThreadB extends Thread {
	private Lock lock;
	private Condition cond;
	int num2 = 1;

	public ThreadB(Lock lock, Condition cond) {
		this.lock = lock;
		this.cond = cond;
	}

	@Override
	public void run() {
		try{
			this.lock.lock();
			while(num2 <= 10){
				if(Test.falg){
//					Test.falg = true;
					try {
						
						cond.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+"Two");
				num2++;
				Test.falg = true;
				cond.signal();
			}
		}finally {
			this.lock.unlock();
		}
		
	}
}
