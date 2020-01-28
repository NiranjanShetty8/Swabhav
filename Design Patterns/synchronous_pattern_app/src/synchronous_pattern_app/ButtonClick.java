package synchronous_pattern_app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ButtonClick implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand()=="Print Date") {
			while(true) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String x = sdf.format(new Date());
				System.out.println(x);
			}
			
		} else if(e.getActionCommand()=="Print Hello") {
			Synchronous.getJd().setVisible(true);
		}
		
	}

}
