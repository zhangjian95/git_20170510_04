package com.zhang.no1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
	static boolean fslg = false;
	private static Lock lock = new ReentrantLock();
	private static Condition con = lock.newCondition();
	public static void main(String[] args) {
		// TODO Auto-generated method stub	

		
		MyThread01 m1 = new MyThread01(con, lock);
		MyThread02 m2 = new MyThread02(con, lock);
		m1.setName("One");
		m2.setName("two");
		m1.start();
		m2.start();
	}

}
