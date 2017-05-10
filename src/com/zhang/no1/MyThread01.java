package com.zhang.no1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyThread01 extends Thread {
	private Lock lock;
	private Condition con;
	int num = 1;

	MyThread01(Condition con, Lock lock) {
		this.lock = lock;
		this.con = con;
	}

	@Override
	public void run() {
		try {
			this.lock.lock();
			while(num <= 10){
				if(Test.fslg){
					
					try {
						con.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+"----"+num);
				Test.fslg =true;
				num+=2;
				con.signal();
			}
		} finally {
			this.lock.unlock();
		}
	}
}
