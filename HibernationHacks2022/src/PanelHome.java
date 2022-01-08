import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PanelHome extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelHome() {
		setForeground(new Color(102, 51, 0));
		setBorder(null);
		setBackground(new Color(255, 255, 204));
		
		setBounds(0,0,505,574);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home\r\n");
		lblNewLabel.setBounds(149, 168, 271, 183);
		add(lblNewLabel);
		setVisible(true);
	}
}
