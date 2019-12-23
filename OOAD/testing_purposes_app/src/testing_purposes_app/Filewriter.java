package testing_purposes_app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Filewriter {

	public static void main(String[] args) throws Exception {
		String location = "D:\\Swabhav\\Swabhav\\OOAD\\factory_method_app\\fact.properties";
		Properties p1 = new Properties();
		OutputStream os = new FileOutputStream(location);

		p1.setProperty("factory", "com.techlabs.factory.method.TeslaFactory");
		p1.store(os, "Remove # for activating the line");

		os.close();

	}
}
