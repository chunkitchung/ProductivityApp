package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DashboardFrame extends JFrame {

	private JPanel contentPanel;
	
	private Image img_logo= new ImageIcon(DashboardFrame.class.getResource("Images/logo.jpg")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image img_logoHome= new ImageIcon(DashboardFrame.class.getResource("Images/Home.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	private Image img_logoCal= new ImageIcon(DashboardFrame.class.getResource("Images/Calendar.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	private Image img_logoPom= new ImageIcon(DashboardFrame.class.getResource("Images/Pomodoro.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	private Image img_logoTasks= new ImageIcon(DashboardFrame.class.getResource("Images/Tasks.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	//Switch to these panels when clicked
	private PanelHome panelHomeE;
	private PanelPomodoro panelPomodoroE;
	private PanelTasks panelTasksE;
	private PanelCalendar panelCalendarE; 
	
	//JPanel "Buttons"
	private JPanel panelHome;
	private JPanel panelPomodoro;
	private JPanel panelTasks;
	private JPanel panelCalendar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardFrame frame = new DashboardFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DashboardFrame() {
		setForeground(Color.WHITE);
		setTitle("Productivity App");
		setFont(new Font("High Tower Text", Font.PLAIN, 14));
		setBackground(Color.LIGHT_GRAY);
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 635);
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(255, 255, 204));
		contentPanel.setBorder(new LineBorder(new Color(102, 102, 102), 2, true));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		panelHomeE= new PanelHome();
		panelCalendarE= new PanelCalendar();
		panelPomodoroE= new PanelPomodoro();
		panelTasksE= new PanelTasks();
		
		JPanel MenuPanel = new JPanel();
		MenuPanel.setBorder(new LineBorder(new Color(102, 102, 102), 2, true));
		MenuPanel.setBackground(new Color(255, 255, 255));
		MenuPanel.setBounds(0, 0, 161, 596);
		contentPanel.add(MenuPanel);
		MenuPanel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(0, 11, 161, 82);
		lblLogo.setIcon(new ImageIcon(img_logo));
		MenuPanel.add(lblLogo);
		
		panelHome = new JPanel();
		panelHome.addMouseListener(new PanelButtonMouseAdapter(panelHome) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelHomeE);
			}
			
		});
		panelHome.setBorder(null);
		panelHome.setBackground(new Color(255, 255, 255));
		panelHome.setBounds(10, 104, 141, 52);
		MenuPanel.add(panelHome);
		panelHome.setLayout(null);
		
		JLabel lblHome = new JLabel("HOME");
		lblHome.setForeground(new Color(102, 51, 0));
		lblHome.setFont(new Font("Goudy Old Style", Font.PLAIN, 14));
		lblHome.setBackground(new Color(255, 255, 255));
		lblHome.setBounds(50, 11, 89, 30);
		panelHome.add(lblHome);
		
		JLabel lblHomeLogo = new JLabel("");
		lblHomeLogo.setBackground(new Color(255, 255, 255));
		lblHomeLogo.setBounds(5, 0, 40, 52);
		lblHomeLogo.setIcon(new ImageIcon(img_logoHome));
		panelHome.add(lblHomeLogo);
		
		panelPomodoro = new JPanel();
		panelPomodoro.addMouseListener(new PanelButtonMouseAdapter(panelPomodoro) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelPomodoroE);
			}
			
		});
		panelPomodoro.setBorder(null);
		panelPomodoro.setBackground(new Color(255, 255, 255));
		panelPomodoro.setBounds(10, 167, 141, 52);
		MenuPanel.add(panelPomodoro);
		panelPomodoro.setLayout(null);
		
		JLabel lblPomodoro = new JLabel("POMODORO");
		lblPomodoro.setFont(new Font("Goudy Old Style", Font.PLAIN, 14));
		lblPomodoro.setForeground(new Color(102, 51, 0));
		lblPomodoro.setBounds(50, 11, 89, 30);
		panelPomodoro.add(lblPomodoro);
		
		JLabel lblPomodoroLogo = new JLabel("");
		lblPomodoroLogo.setBackground(Color.WHITE);
		lblPomodoroLogo.setBounds(5, 0, 40, 52);
		lblPomodoroLogo.setIcon(new ImageIcon(img_logoPom));
		panelPomodoro.add(lblPomodoroLogo);
		
		panelTasks = new JPanel();
		panelTasks.addMouseListener(new PanelButtonMouseAdapter(panelTasks) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelTasksE);
			}
			
		});
		panelTasks.setBorder(null);
		panelTasks.setBackground(new Color(255, 255, 255));
		panelTasks.setBounds(10, 230, 141, 52);
		MenuPanel.add(panelTasks);
		panelTasks.setLayout(null);
		
		JLabel lblTasks = new JLabel("TASKS");
		lblTasks.setForeground(new Color(102, 51, 0));
		lblTasks.setFont(new Font("Goudy Old Style", Font.PLAIN, 14));
		lblTasks.setBounds(50, 11, 89, 30);
		panelTasks.add(lblTasks);
		
		JLabel lblTasksLogo = new JLabel("");
		lblTasksLogo.setBackground(Color.WHITE);
		lblTasksLogo.setBounds(5, 0, 40, 52);
		lblTasksLogo.setIcon(new ImageIcon(img_logoTasks));
		panelTasks.add(lblTasksLogo);
		
		panelCalendar = new JPanel();
		panelCalendar.addMouseListener(new PanelButtonMouseAdapter(panelCalendar) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelCalendarE);
			}
			
		});
		panelCalendar.setBorder(null);
		panelCalendar.setBackground(new Color(255, 255, 255));
		panelCalendar.setBounds(10, 293, 141, 52);
		MenuPanel.add(panelCalendar);
		panelCalendar.setLayout(null);
		
		JLabel lblCalendar = new JLabel("CALENDAR");
		lblCalendar.setForeground(new Color(102, 51, 0));
		lblCalendar.setFont(new Font("Goudy Old Style", Font.PLAIN, 14));
		lblCalendar.setBounds(50, 11, 89, 30);
		panelCalendar.add(lblCalendar);
		
		JLabel lblCalendarLogo = new JLabel("");
		lblCalendarLogo.setBackground(Color.WHITE);
		lblCalendarLogo.setBounds(5, 0, 40, 52);
		lblCalendarLogo.setIcon(new ImageIcon(img_logoCal));
		panelCalendar.add(lblCalendarLogo);
		
		JPanel panelMainContent = new JPanel();
		panelMainContent.setBounds(171, 11, 505, 574);
		contentPanel.add(panelMainContent);
		panelMainContent.setLayout(null);
		
		panelMainContent.add(panelHomeE);
		panelMainContent.add(panelTasksE);
		panelMainContent.add(panelCalendarE);
		panelMainContent.add(panelPomodoroE); 
		
		menuClicked(panelHomeE);

	}
	//replace panels onclick
	public void menuClicked(JPanel selectedPanel) {

		panelHomeE.setVisible(false);
		panelPomodoroE.setVisible(false);
		panelCalendarE.setVisible(false);
		panelTasksE.setVisible(false);
		
		selectedPanel.setVisible(true);

	}
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(240,240,240));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(255,255,255));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(210,210,210));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(240,240,240));
		}
	}
}