package view;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;

public class PanelHome extends JPanel {

	/**
	 * Home Panel
	 */
	public PanelHome() {
		setForeground(new Color(102, 51, 0));
		setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBackground(new Color(255, 255, 204));
		
		setBounds(0,0,505,574);
		setLayout(null);
		
		JPanel dailyPomo = new JPanel();
		dailyPomo.setFont(new Font("Goudy Old Style", Font.PLAIN, 29));
		dailyPomo.setBackground(new Color(255, 255, 204));
		dailyPomo.setBounds(31, 33, 63, 60);
		add(dailyPomo);
		
		JTextPane txt1 = new JTextPane();
		txt1.setText("Daily Pomodoros");
		txt1.setBackground(new Color(255, 255, 204));
		txt1.setBounds(29, 98, 65, 34);
		add(txt1);
		
		JPanel dailyTasks = new JPanel();
		dailyTasks.setBackground(new Color(255, 255, 204));
		dailyTasks.setBounds(125, 33, 63, 60);
		add(dailyTasks);
		
		JTextPane txt2 = new JTextPane();
		txt2.setBackground(new Color(255, 255, 204));
		txt2.setText("Daily Tasks Completed");
		txt2.setBounds(125, 98, 65, 34);
		add(txt2);
		
		JPanel dailyStudy = new JPanel();
		dailyStudy.setBackground(new Color(255, 255, 204));
		dailyStudy.setBounds(219, 33, 63, 60);
		add(dailyStudy);
		
		JTextPane txt3 = new JTextPane();
		txt3.setBackground(new Color(255, 255, 204));
		txt3.setText("Daily Study Time");
		txt3.setBounds(219, 98, 65, 34);
		add(txt3);
		
		JPanel totalTasks = new JPanel();
		totalTasks.setBackground(new Color(255, 255, 204));
		totalTasks.setBounds(407, 33, 63, 60);
		add(totalTasks);
		
		JTextPane txt5 = new JTextPane();
		txt5.setBackground(new Color(255, 255, 204));
		txt5.setText("Tasks Completed");
		txt5.setBounds(407, 98, 65, 34);
		add(txt5);
		
		JPanel totalPomo = new JPanel();
		totalPomo.setBackground(new Color(255, 255, 204));
		totalPomo.setBounds(313, 33, 63, 60);
		add(totalPomo);
		
		JTextPane txt4 = new JTextPane();
		txt4.setBackground(new Color(255, 255, 204));
		txt4.setText("Pomodoros Completed");
		txt4.setBounds(311, 98, 65, 34);
		add(txt4);
		setVisible(true);
	}
}
