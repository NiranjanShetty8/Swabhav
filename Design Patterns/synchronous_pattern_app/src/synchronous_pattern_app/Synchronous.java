package synchronous_pattern_app;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Synchronous extends JFrame {

	private static final long serialVersionUID = -2094382763290422396L;
	private static JDialog jd;

	public Synchronous() {
		this.setTitle("Hello");
		this.setLayout(null);
		JPanel jp = new JPanel();
		JButton date = new JButton("Print Date");
		date.addActionListener(new ButtonClick());
		JButton hello = new JButton("Print Hello");
		hello.addActionListener(new ButtonClick());
		jp.setBounds(0, 0, 300, 300);
		jd = new JDialog(this,"hello",true);
		jd.setBounds(150, 150, 100, 100);
		

		jp.add(date);
		jp.add(hello);
		this.setVisible(true);
		this.add(jp);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String args[]) {
		 new Synchronous();
	}
	
	public static JDialog getJd() {
		return jd;
	}
}
