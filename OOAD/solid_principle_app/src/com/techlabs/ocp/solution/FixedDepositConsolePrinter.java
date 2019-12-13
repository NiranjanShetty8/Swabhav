package com.techlabs.ocp.solution;

public class FixedDepositConsolePrinter {

	public static void main(String[] args) {
		FestInterestRate normal = new FestInterestRate();
		FestInterestRate diwali = new DiwaliRate();
		FestInterestRate holi = new HoliRate();
		
		FixedDeposit fd1 = new FixedDeposit(101, "Niranjan", 100000, 10, diwali);
		printInfo(fd1);
		FixedDeposit fd2 = new FixedDeposit(101, "Raju", 100000, 10, holi);
		printInfo(fd2);
		FixedDeposit fd3 = new FixedDeposit(101, "Brijoy", 100000, 10, normal);
		printInfo(fd3);
		
	}

	public static void printInfo(FixedDeposit obj) {
		System.out.println(obj.getAccountNo() + "\n" +obj.getDuration() + "\n" +
				obj.getName()+ "\n" +obj.getPrincipal()+ "\n"
				+obj.calculateSimpleInterest());
	}
}
