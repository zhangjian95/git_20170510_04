package com.zhang.no2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
	private static Lock lock = new ReentrantLock();
	private static Condition cond = lock.newCondition();
	static boolean falg ;
	public static void main(String[] args) {
		ThreadA t1 = new ThreadA(lock,cond);
		ThreadB t2 = new ThreadB(lock,cond);
		t1.setName("A线程");
		t2.setName("B线程");
		t1.start();
		t2.start();
	}
}
