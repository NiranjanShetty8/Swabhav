package com.techlabs.decorator.test;

import com.techlabs.decorator.*;

public class BikeServiceTest {

	public static void main(String[] args) {
		IBikeService svc = new ChainAllignment(new OilChange(new BasicBikeService()));
		System.out.println("Services Done: " +svc.getDescription());
		System.out.println("Total Cost: " +svc.getCost());

	}

}
