package emp_app;

public class EmpTest {
	public static void main(String[] args) {
		EmpFileReader empf = new EmpFileReader();
		CompanyDetails ed = new CompanyDetails();
		try {
			empf.removeDuplicates();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Highest Paid : " +ed.findLargestSalary());
		
		System.out.println("Total Managers are :" +ed.getTotalManagers().size());
		for(String s: ed.getTotalManagers()) {
			System.out.println(s);
		}
		
	}
	

}
