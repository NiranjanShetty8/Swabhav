package com.techlabs.ocp.violation.test;

import com.techlabs.ocp.violation.FestivalType;
import com.techlabs.ocp.violation.FixedDeposit;

public class FixedDepositTest {

	public static void main(String[] args) {
		FixedDeposit fd1 = new FixedDeposit(101, "Niranjan", 10000, 2, FestivalType.NORMAL);
		FixedDeposit fd2 = new FixedDeposit(102, "Rajesh", 10000, 2, FestivalType.HOLI);
		FixedDeposit fd3 = new FixedDeposit(101, "Kamlesh", 10000, 2, FestivalType.DIWALI);
		
		System.out.println("Account number: " +fd1.getAccountNo() 
		+"\nAccount name: " +fd1.getName() + "\nDuration: "
				+fd1.getDuration()+ "\nInterest:" +fd1.calculateSimpleInterest());
		System.out.println("Account number: " +fd2.getAccountNo() 
		+"\nAccount name: " +fd2.getName() + "\nDuration: "
				+fd2.getDuration()+ "\nInterest:" +fd2.calculateSimpleInterest());
		System.out.println("Account number: " +fd3.getAccountNo() 
		+"\nAccount name: " +fd3.getName() + "\nDuration: "
				+fd3.getDuration()+ "\nInterest:" +fd3.calculateSimpleInterest());
	}

}
