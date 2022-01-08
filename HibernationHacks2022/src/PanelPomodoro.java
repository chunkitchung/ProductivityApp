import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.*;

public class PanelPomodoro extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelPomodoro() {
		setForeground(new Color(102, 51, 0));
		setBorder(null);
		setBackground(new Color(255, 255, 204));
		setBounds(0,0,505,574);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pom\r\n");
		lblNewLabel.setBounds(149, 168, 271, 183);
		add(lblNewLabel);
		setVisible(true);
		
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
