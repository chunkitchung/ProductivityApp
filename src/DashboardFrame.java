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
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DashboardFrame extends JFrame {

	private JPanel contentPane;
	
	private Image img_logo= new ImageIcon(DashboardFrame.class.getResource("Images/logo1.jpg")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel MenuPanel = new JPanel();
		MenuPanel.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		MenuPanel.setBackground(Color.DARK_GRAY);
		MenuPanel.setBounds(0, 0, 161, 596);
		contentPane.add(MenuPanel);
		MenuPanel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(0, 11, 161, 82);
		lblLogo.setIcon(new ImageIcon(img_logo));
		MenuPanel.add(lblLogo);
	}
}
