import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.border.LineBorder;
import javax.swing.*;

public class PanelPomodoro extends JPanel {
	Timer timeCount;	
	JLabel timer;
	int second;
	int minute;
	String ddSecond;
	String ddMinute;
	DecimalFormat dFormat;
	
	/**
	 * Create the panel.
	 */
	public PanelPomodoro() {
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setForeground(new Color(102, 51, 0));
		setBorder(null);
		setBackground(new Color(255, 255, 204));
		setBounds(0,0,505,574);
		setLayout(null);
		
		timer = new JLabel("11:59:59");
		timer.setFont(new Font("Tahoma", Font.PLAIN, 82));
		timer.setHorizontalAlignment(SwingConstants.CENTER);
		timer.setBorder(new LineBorder(new Color(0, 0, 0)));
		timer.setBounds(94, 206, 312, 103);
		add(timer);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timeCount.start();
			}
		});
		btnStart.setBounds(125, 320, 70, 23);
		add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeCount.stop();
			}
		});
		btnStop.setBounds(210, 320, 70, 23);
		add(btnStop);
		
		//initial time and timer
		second = 0;
		minute = 25;
		timer.setText("25:00");
		dFormat = new DecimalFormat("00");
		
		//initialize timer
		this.timeCount = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				second--;
				if(second == -1) {
					second = 59;
					minute--;
					System.out.println("SECOND: " + second + ", Minute: " + minute);
				}
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);
				timer.setText(ddMinute + ":" + ddSecond);
				
				if(minute == 0 && second == 0) {
					timeCount.stop();
				}
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				second = 0;
				minute = 25;
				timer.setText("25:00");
				timeCount.stop();
			}
		});
		btnReset.setBounds(295, 320, 70, 23);
		add(btnReset);

	}

}
