package com.zhang.no1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyThread02 extends Thread {
	private Lock lock;
	private Condition con;
	int num2 = 2;

	MyThread02(Condition con, Lock lock) {
		this.lock = lock;
		this.con = con;
	}

	@Override
	public void run() {
		try {
			this.lock.lock();

			while (num2 <= 10) {
				if(! Test.fslg){
					try {
						con.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+"----"+num2);
				Test.fslg = false;
				num2+=2;
				con.signal();
			}
		} finally {
			this.lock.unlock();

		}

	}
}
