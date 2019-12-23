package com.techlabs.adapter.pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class QueueAdapter<T> implements IQueue<T>,Iterable<T>{

	LinkedList<T> queue = new LinkedList<T>();
	
	@Override
	public void enqueue(T item) {
		queue.addLast(item);
		
	}

	@Override
	public T dequeue() {
		return queue.removeFirst();
	}

	@Override
	public int count() {
		int count = queue.size();
		return count;
	}

	@Override
	public Iterator<T> iterator() {
		return queue.iterator();
	}

}
