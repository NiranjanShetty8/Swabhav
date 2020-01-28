package com.techlabs.async;

import java.text.SimpleDateFormat;
import java.util.Date;

public class F1Thread implements Runnable {

	@Override
	public void run() {
		while(true) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");
			String dateTime = sdf.format(new Date());
			System.out.println(dateTime);
		}
		
	}

}
