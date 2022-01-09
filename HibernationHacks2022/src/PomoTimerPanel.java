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
	public PomoTimerPanel() {
		setBorder(new LineBorder(Color.DARK_GRAY));
		setLayout(null);
		
		timer = new JLabel("11:59:59");
		timer.setFont(new Font("Tahoma", Font.PLAIN, 46));
		timer.setHorizontalAlignment(SwingConstants.CENTER);
		timer.setBorder(new LineBorder(new Color(0, 0, 0)));
		timer.setBounds(106, 88, 240, 52);
		add(timer);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timeCount.start();
			}
		});
		btnStart.setBounds(106, 151, 70, 23);
		add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeCount.stop();
			}
		});
		btnStop.setBounds(191, 151, 70, 23);
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
		btnReset.setBounds(276, 151, 70, 23);
		add(btnReset);
				
	}	
}
