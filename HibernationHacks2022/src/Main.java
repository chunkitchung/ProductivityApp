import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;

public class Main implements ActionListener {

	private JFrame frame;
	private JLabel toDoList;
	private JTextArea list;
	private JScrollPane scrollPane;
	private JTextField task;
	private JButton addTaskButton;
	private JButton deleteTaskButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// creates frame
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(300, 60, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		toDoList = new JLabel("Tasks To Do");
		toDoList.setBounds(170, 0, 350, 100);
		toDoList.setForeground(Color.GRAY);
		toDoList.setFont(new Font("Goudy Old Style", Font.PLAIN, 40));
		toDoList.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(toDoList);

		list = new JTextArea();
		list.setBounds(45, 100, 600, 300);
		list.setEditable(false);
		list.setBackground(Color.WHITE);
		list.setFont(new Font("Goudy Old Style", Font.PLAIN, 14));
		list.setForeground(Color.BLACK);

		scrollPane = new JScrollPane(list);
		scrollPane.setBounds(45, 100, 600, 300);
		frame.getContentPane().add(list);
		frame.getContentPane().add(scrollPane);

		task = new JTextField();
		task.setBounds(45, 450, 400, 35);
		frame.getContentPane().add(task);

		addTaskButton = new JButton("Add");
		addTaskButton.setBounds(470, 450, 80, 35);
		addTaskButton.setBorderPainted(false);
		addTaskButton.setBackground(new Color(204, 255, 255));
		addTaskButton.setForeground(Color.GRAY);
		addTaskButton.setFont(new Font("Goudy Old Style", Font.PLAIN, 15));
		addTaskButton.addActionListener(this);
		frame.getContentPane().add(addTaskButton);

		deleteTaskButton = new JButton("Delete");
		deleteTaskButton.setBounds(570, 450, 90, 35);
		deleteTaskButton.setBorderPainted(false);
		deleteTaskButton.setBackground(new Color(255, 204, 255));
		deleteTaskButton.setForeground(new Color(102, 102, 102));
		deleteTaskButton.setFont(new Font("Goudy Old Style", Font.PLAIN, 15));
		deleteTaskButton.addActionListener(this);
		frame.getContentPane().add(deleteTaskButton);

		frame.getContentPane().setFocusable(true);
	}

	public void actionPerformed(ActionEvent e) {
		String filePath = "src\\tasks.txt";
		BufferedWriter fileWriter = null;
		try {
			fileWriter = new BufferedWriter(new FileWriter(filePath, true));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		if (e.getSource() == addTaskButton) {

			try {

				fileWriter.write(task.getText());
				fileWriter.newLine();
				fileWriter.close();
				list.append(task.getText());
				list.append("\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == deleteTaskButton) {
			
			String deleteWord = task.getText();
			System.out.println("Word to delete: " + deleteWord);

			File file = new File("src\\tasks.txt");
			File temp = null;
			String charset = "UTF-8";
			String delete = task.getText();

			try {
				temp = File.createTempFile("file", ".txt", file.getParentFile());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BufferedReader reader = null;
			PrintWriter writer = null;
			try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
				writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), charset));

			} catch (UnsupportedEncodingException | FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					for (String line; (line = reader.readLine()) != null;) {
						line = line.replace(delete, "");
						writer.println(line);
					}
					reader.close();
					writer.close();
					
					temp.renameTo(file);
					file.delete();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

//			int end = 0;
//			try {
//				end = list.getLineEndOffset(0);
//			} catch (BadLocationException e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}
//			list.replaceRange("", 0, end);
//
//			try {
//				fileWriter.write(task.getText() + "\n");
//				fileWriter.close();
//				list.append(task.getText());
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}
	}

}
