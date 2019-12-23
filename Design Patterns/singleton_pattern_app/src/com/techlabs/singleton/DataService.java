package com.techlabs.singleton;

public class DataService {
	private static DataService bucket;
	
	private DataService() {
		System.out.println("service executed");
	}

	public void doWork() {
		System.out.println("Doing work by service " +this.hashCode());
	}
	
	public static DataService getInstance() {
		if(bucket == null) {
			bucket = new DataService();
		}
		return bucket;
	}
}
