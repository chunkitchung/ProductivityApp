package view;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.List;
import java.awt.TextField;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.UIManager;

import model.User;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class PanelTasks extends JPanel {
private int pendingT,completedT;
private User user;
	/**
	 * Create the panel.
	 */
	public PanelTasks(User user) {
		this.user = user;
		setForeground(new Color(102, 51, 0));
		setBorder(null);
		setBackground(new Color(255, 255, 204));
		setBounds(0,0,505,574);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tasks");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(102, 51, 0));
		lblNewLabel.setFont(new Font("Goudy Old Style", Font.PLAIN, 22));
		lblNewLabel.setBounds(160, 21, 175, 45);
		add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 69, 485, 316);
		
		add(tabbedPane);
		
		List pendingList = new List();
		pendingList.setBackground(new Color(255, 255, 204));
		pendingList.setForeground(new Color(0, 0, 0));
		pendingList.setFont(new Font("Goudy Old Style", Font.PLAIN, 14));
		File tasks= new File("src\\tasks.txt");
		BufferedReader fr=null;
		try {
			fr= new BufferedReader(new FileReader(tasks));
		}
		catch (IOException e2) {
			e2.printStackTrace();
		}
		try {
			String currentLine;
			while((currentLine=fr.readLine())!= null) {
				pendingList.add(currentLine);
			}
			fr.close();
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		tabbedPane.addTab("Pending", null, pendingList, null);
		tabbedPane.setForegroundAt(0, new Color(102, 51, 0));
		tabbedPane.setBackgroundAt(0, UIManager.getColor("Button.background"));
		
		List completedList = new List();
		completedList.setBackground(new Color(255, 255, 204));
		completedList.setForeground(new Color(0, 0, 0));
		completedList.setFont(new Font("Goudy Old Style", Font.PLAIN, 14));
		File completedTasks= new File("src\\completedTasks.txt");
		try {
			fr= new BufferedReader(new FileReader(completedTasks));
		}
		catch (IOException e2) {
			e2.printStackTrace();
		}
		try {
			String currentLine;
			while((currentLine=fr.readLine())!= null) {
				completedList.add(currentLine);
			}
			fr.close();
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		tabbedPane.addTab("Completed", null, completedList, null);
		tabbedPane.setForegroundAt(1, new Color(102, 51, 0));
		tabbedPane.setBackgroundAt(1, UIManager.getColor("Button.background"));
		
		TextField input = new TextField();
		input.setText("Enter your task..");
		input.setForeground(new Color(102, 51, 0));
		input.setFont(new Font("Goudy Old Style", Font.PLAIN, 14));
		input.setBounds(10, 391, 325, 22);
		input.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(input.getText().equals(""))
				{
					input.setText("Enter your task..");
				}
			}
			@Override
			public void focusGained(FocusEvent arg0) {
				if(input.getText().equals("Enter your task.."))
				{
					input.setText("");
				}
			}
		});
		add(input);
		
		Button add = new Button("Add");
		add.setForeground(new Color(255, 255, 255));
		add.setBackground(new Color(141, 110, 99));
		add.setFont(new Font("Goudy Old Style", Font.PLAIN, 12));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filePath = "src\\tasks.txt";
				BufferedWriter fileWriter = null;
				try {
					fileWriter = new BufferedWriter(new FileWriter(filePath, true));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (e.getSource() == add) {
					try {
						fileWriter.write(input.getText());
						fileWriter.newLine();
						fileWriter.close();
						pendingList.add(input.getText());
						System.out.println("task added: "+input.getText());

						input.setText("");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		add.setBounds(347, 391, 70, 22);
		add(add);
		
		Button del = new Button("Delete");
		del.setBackground(new Color(141, 110, 99));
		del.setForeground(new Color(255, 255, 255));
		del.setFont(new Font("Goudy Old Style", Font.PLAIN, 12));
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File tasksFile = new File("src\\tasks.txt");
				BufferedReader fileReader = null;
				try {
					fileReader = new BufferedReader(new FileReader(tasksFile));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (e.getSource() == del) {
					try {
						String lineToRemove=pendingList.getSelectedItem();
						removeLine(fileReader,tasksFile,lineToRemove);
						pendingList.remove(lineToRemove);
						System.out.println("task deleted: "+lineToRemove);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		del.setBounds(425, 391, 70, 22);
		add(del);
		
		Button markComplete = new Button("Mark As Complete");
		markComplete.setForeground(new Color(255, 255, 255));
		markComplete.setBackground(new Color(141, 110, 99));
		markComplete.setFont(new Font("Goudy Old Style", Font.PLAIN, 12));
		markComplete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String filePath = "src\\completedTasks.txt";
				BufferedWriter fileWriter = null;
				try {
					fileWriter = new BufferedWriter(new FileWriter(filePath, true));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				if (e.getSource() == markComplete) {
					String taskCompleted = pendingList.getSelectedItem();
					System.out.println("Task that was completed: " + taskCompleted);

					try {

						fileWriter.write(taskCompleted);
						fileWriter.newLine();
						fileWriter.close();
						completedList.add(taskCompleted);
						
						//Adds completed task to user statistics
						user.addTask();
						
						File tasksFile = new File("src\\tasks.txt");
						BufferedReader fileReader = new BufferedReader(new FileReader(tasksFile));
						removeLine(fileReader,tasksFile,taskCompleted);

						pendingList.remove(taskCompleted);

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		markComplete.setBounds(347, 420, 148, 22);
		add(markComplete);
		setVisible(true);
		pendingT= pendingList.getItemCount();
		completedT=completedList.getItemCount();
	}
	public static void removeLine(BufferedReader br , File f,  String Line) throws IOException{
	    File temp = new File("temp.txt");
	    BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
	    String removeID = Line;
	    String currentLine;
	    while((currentLine = br.readLine()) != null){
	    	 if(currentLine.equals(Line)) continue;
	    	 bw.write(currentLine + System.getProperty("line.separator"));

	    }
	    bw.close();
	    br.close();
	    boolean delete = f.delete();
	    boolean b = temp.renameTo(f);
	    System.out.println("Delete: "+delete+" renamed: "+b);
	}
	public int getPending() {
		return pendingT;
	}
	public int getCompleted(){
		return completedT;
	}
	
}
