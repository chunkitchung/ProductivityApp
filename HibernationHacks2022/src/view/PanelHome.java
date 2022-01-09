package view;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import model.User;

public class PanelHome extends JPanel implements Observer{
	JLabel dailyPomo;
	JLabel dailyTasks;
	JLabel dailyStudy;
	JLabel totalTasks;
	JLabel totalPomo;
	User user;
	
	/**
	 * Home Panel
	 */
	public PanelHome(User user) {
		this.user = user;
		setForeground(new Color(102, 51, 0));
		setBorder(null);
		setBackground(new Color(255, 255, 204));
		
		setBounds(0,0,505,574);
		setLayout(null);
		
		dailyPomo = new JLabel();
		dailyPomo.setHorizontalAlignment(SwingConstants.CENTER);
		dailyPomo.setHorizontalTextPosition(SwingConstants.CENTER);
		dailyPomo.setFont(new Font("Goudy Old Style", Font.PLAIN, 50));
		dailyPomo.setBackground(new Color(255, 255, 204));
		dailyPomo.setBounds(23, 30, 63, 60);
		add(dailyPomo);
		
		JTextPane txt1 = new JTextPane();
		txt1.setText("Daily Pomodoros");
		txt1.setBackground(new Color(255, 255, 204));
		txt1.setBounds(20, 85, 65, 42);
		txt1.setFont(new Font("Goudy Old Style", Font.PLAIN, 14));
		add(txt1);
		
		dailyTasks = new JLabel();
		dailyTasks.setHorizontalAlignment(SwingConstants.CENTER);
		dailyTasks.setFont(new Font("Goudy Old Style", Font.PLAIN, 50));
		dailyTasks.setBackground(new Color(255, 255, 204));
		dailyTasks.setBounds(109, 30, 63, 60);
		add(dailyTasks);
		
		JTextPane txt2 = new JTextPane();
		txt2.setBackground(new Color(255, 255, 204));
		txt2.setFont(new Font("Goudy Old Style", Font.PLAIN, 14));
		txt2.setText("Daily Tasks Completed");
		txt2.setBounds(109, 85, 65, 42);
		add(txt2);
		
		dailyStudy = new JLabel();
		dailyStudy.setHorizontalAlignment(SwingConstants.CENTER);
		dailyStudy.setFont(new Font("Goudy Old Style", Font.PLAIN, 50));
		dailyStudy.setBackground(new Color(255, 255, 204));
		dailyStudy.setBounds(195, 30, 115, 60);
		add(dailyStudy);
		
		JTextPane txt3 = new JTextPane();
		txt3.setFont(new Font("Goudy Old Style", Font.PLAIN, 14));
		txt3.setBackground(new Color(255, 255, 204));
		txt3.setText("Daily Study Time");
		txt3.setBounds(210, 85, 74, 42);
		add(txt3);
		
		totalTasks = new JLabel();
		totalTasks.setHorizontalAlignment(SwingConstants.CENTER);
		totalTasks.setBackground(new Color(255, 255, 204));
		totalTasks.setBounds(419, 30, 63, 60);
		totalTasks.setFont(new Font("Goudy Old Style", Font.PLAIN, 50));
		add(totalTasks);
		
		JTextPane txt5 = new JTextPane();
		txt5.setFont(new Font("Goudy Old Style", Font.PLAIN, 14));
		txt5.setBackground(new Color(255, 255, 204));
		txt5.setText("Tasks Completed");
		txt5.setBounds(419, 85, 65, 42);
		add(txt5);
		
		totalPomo = new JLabel();
		totalPomo.setHorizontalAlignment(SwingConstants.CENTER);
		totalPomo.setBackground(new Color(255, 255, 204));
		totalPomo.setBounds(333, 30, 63, 60);
		totalPomo.setFont(new Font("Goudy Old Style", Font.PLAIN, 50));
		add(totalPomo);
		
		JTextPane txt4 = new JTextPane();
		txt4.setBackground(new Color(255, 255, 204));
		txt4.setFont(new Font("Goudy Old Style", Font.PLAIN, 14));
		txt4.setText("Pomodoros Completed");
		txt4.setBounds(333, 85, 65, 42);
		add(txt4);
		setVisible(true);
		
		updateState();
	}
	
	//Updates the label to represent the Users data
	public void updateState() {
		String study = "" + this.user.getStudyTime() ;
		this.dailyPomo.setText(this.user.getDailyPomos() + "");
		this.dailyTasks.setText(this.user.getDailyTasks() + "");
		this.dailyStudy.setText("0.0");
		this.totalPomo.setText(this.user.getTotalPomos() + "");
		this.totalTasks.setText(this.user.getTotalTasks() + "");
	}

	@Override
	public void update(Observable o, Object arg) {
		this.user = (User) arg;
		this.dailyPomo.setText(this.user.getDailyPomos() + "");
		this.dailyTasks.setText(this.user.getDailyTasks() + "");
		this.dailyStudy.setText(this.user.getStudyTime() + "");
		this.totalPomo.setText(this.user.getTotalPomos() + "");
		this.totalTasks.setText(this.user.getTotalTasks() + "");
	}
}
