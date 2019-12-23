package com.techlabs.adapter.pattern.Test;

import com.techlabs.adapter.pattern.QueueAdapter;

public class AdapterTest {

	public static void main(String[] args) {
		QueueAdapter<Integer> queue = new QueueAdapter<Integer>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		
		System.out.println("Count: " +queue.count());
		System.out.println("Item removed: " +queue.dequeue());
		System.out.println("Count: " +queue.count());

		for(int i: queue) {
			System.out.println(i);
		}
	}
	

}
