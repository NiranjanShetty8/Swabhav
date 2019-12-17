package testing_purposes_app;

public class Splitting {

	public static void main(String[] args) {
		String x = "7698,'BLAKE','MANAGER',7839,'1-MAY-81',2850,NULL,30";
		System.out.println(x.split("'")[1]);
	}
}
