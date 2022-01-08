import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.*;
import java.util.Date;

public class PomoTimerPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public PomoTimerPanel() {
		setLayout(null);
		
		JLabel timer = new JLabel("11:59:59");
		timer.setFont(new Font("Tahoma", Font.PLAIN, 46));
		timer.setHorizontalAlignment(SwingConstants.CENTER);
		timer.setBorder(new LineBorder(new Color(0, 0, 0)));
		timer.setBounds(103, 29, 240, 52);
		add(timer);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Timer t = new Timer(1000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
						timer.setText(sdf.format(new Date()));
					}
				});
				t.start();
			}
		});
		btnNewButton.setBounds(113, 92, 78, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(235, 92, 89, 23);
		add(btnNewButton_1);

	}
}
