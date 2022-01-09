package app;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.attribute.UserPrincipalLookupService;

import javax.swing.JPanel;

import view.DashboardFrame;
import model.User;

public class app {
	
	public static void main(String args[]) {
		String filename = "user.txt";
		boolean newUser = false;
		User appUser = new User();
		
		try {
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			Object user;
			
			//looks for existing user
			try {
				user = ois.readObject();
				System.out.println("Old user found");
				appUser = (User) user;
			}catch(EOFException | ClassNotFoundException e) {
				newUser = true;
			}
			
			ois.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Error finding old user");
			newUser = true;
		}
		
		//writes new user
		if(newUser) {
			try {
				FileOutputStream fos = new FileOutputStream(filename);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(appUser);
				oos.close();
			}catch(IOException e) {
				e.printStackTrace();
				System.out.println("ERROR WRITTING");
			}
		
			
		}
		
		//Create View and Inject User
		DashboardFrame dash = new DashboardFrame(appUser);
		dash.setVisible(true);
	}
}
